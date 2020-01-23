package CrickeAnalyzer;


import java.util.*;

public class SortFields {

    public enum sortingFields {
        AVERAGE_RATE, BOWLER_AVERAGE_RATE,STRIKE_RATE,BOWLER_STRIKE_RATE, FOUR_SIX_RATE, FOUR_SIX_STRIKE_RATE, AVERAGE_STRIKE_RATE, BOWLER_AVERAGE_STRIKE_RATE,RUNS_AVERAGE_RATE, ECONOMY_RATE , FOUR_WICKETS_AND_FIVE_WICKETS, FOUR_WICKETS_AND_FIVE_WICKETS_STRIKE, BOWLER_FOUR_WICKETS_AND_FIVE_WICKETS_STRIKE, AVERAGE_WICKET_RATE,AVERAGE_RATE_BOTH;
    }

    Map<sortingFields, Comparator<CricketAnalyzerDAO>> compareBatsmanHashMap = new HashMap<>();

    public Comparator getFieldCricketer(sortingFields sortingFields) {

        Comparator<CricketAnalyzerDAO> codeStrikeComparator = (data1, data2) -> ((data1.strikeRate > data2.strikeRate)? -1 : 1);

        Comparator<CricketAnalyzerDAO> codeAvgComparator = (data1, data2) -> (int) (data2.average - data1.average);

        compareBatsmanHashMap.put(sortingFields.STRIKE_RATE, codeStrikeComparator);


        compareBatsmanHashMap.put(sortingFields.AVERAGE_RATE,codeAvgComparator);

        Comparator<CricketAnalyzerDAO> bowlStrikeRate = (data1 , data2) -> (int)((data2.bowlStrikeRate - data1.bowlStrikeRate));
        compareBatsmanHashMap.put(SortFields.sortingFields.BOWLER_STRIKE_RATE,bowlStrikeRate);

        Comparator<CricketAnalyzerDAO> bowlAverageRate = (data1 , data2) -> (int)((data2.bowlAverage - data1.bowlAverage));
        compareBatsmanHashMap.put(SortFields.sortingFields.BOWLER_AVERAGE_RATE,bowlAverageRate);


        Comparator<CricketAnalyzerDAO> codeComparator = (f1, f2) -> ((f1.fours * 4 + f1.sixes * 6) > (f2.fours * 4 + f2.sixes * 6) ? -1 : 1);
        compareBatsmanHashMap.put(sortingFields.FOUR_SIX_RATE, codeComparator);
        codeComparator = codeComparator.thenComparing((data1, data2) -> (data1.strikeRate > data2.strikeRate)? -1 : 1);
        compareBatsmanHashMap.put(sortingFields.FOUR_SIX_STRIKE_RATE, codeComparator);



        codeComparator.thenComparing(codeStrikeComparator);
        compareBatsmanHashMap.put(SortFields.sortingFields.AVERAGE_STRIKE_RATE, codeAvgComparator);


        bowlStrikeRate.thenComparing(bowlAverageRate);
        compareBatsmanHashMap.put(SortFields.sortingFields.BOWLER_AVERAGE_STRIKE_RATE, bowlAverageRate);


        Comparator<CricketAnalyzerDAO> codeRunsComparator = (data1, data2) -> ((data1.runs > data2.runs)? -1 : 1);
        codeComparator.thenComparing(codeAvgComparator);
        compareBatsmanHashMap.put(SortFields.sortingFields.RUNS_AVERAGE_RATE, codeRunsComparator);

        compareBatsmanHashMap.put(SortFields.sortingFields.ECONOMY_RATE,(data1,data2)-> (data1.economicRate > data2.economicRate)? -1 : 1);


        compareBatsmanHashMap.put(SortFields.sortingFields.FOUR_WICKETS_AND_FIVE_WICKETS,(data1, data2)->((data1.fourWickets*4 + data1.fiveWickets*5) - (data2.fourWickets*4 + data2.fiveWickets*5)));

        compareBatsmanHashMap.put(sortingFields.BOWLER_FOUR_WICKETS_AND_FIVE_WICKETS_STRIKE,compareBatsmanHashMap.get(SortFields.sortingFields.FOUR_WICKETS_AND_FIVE_WICKETS)
                .thenComparing(compareBatsmanHashMap.get(SortFields.sortingFields.BOWLER_STRIKE_RATE)));

        Comparator<CricketAnalyzerDAO> codeWicketCompare=(data1,data2)-> (data1.wickets > data2.wickets)? -1 :1;

        codeWicketCompare.thenComparing(codeAvgComparator);
        compareBatsmanHashMap.put(SortFields.sortingFields.AVERAGE_WICKET_RATE,codeWicketCompare);


        compareBatsmanHashMap.put(SortFields.sortingFields.AVERAGE_RATE_BOTH,compareBatsmanHashMap.get(SortFields.sortingFields.AVERAGE_RATE)
         .thenComparing(compareBatsmanHashMap.get(SortFields.sortingFields.BOWLER_AVERAGE_RATE)));


        Comparator comparator = compareBatsmanHashMap.get(sortingFields);
        return comparator;
    }

}
