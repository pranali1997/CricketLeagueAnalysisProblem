package CrickeAnalyzer;

import java.util.*;

public class SortFields {

    public enum sortingFields {
        AVERAGE_RATE, STRIKE_RATE, FOUR_SIX_RATE, FOUR_SIX_STRIKE_RATE, AVERAGE_STRIKE_RATE, RUNS_AVERAGE_RATE, ECONOMY_RATE;
    }

    HashMap<sortingFields, Comparator<CricketAnalyzerDAO>> compareBatsmanHashMap = new HashMap<>();

    public Comparator getFieldBatsman(sortingFields sortingFields) {

        compareBatsmanHashMap.put(sortingFields.STRIKE_RATE, (data1, data2) -> (int) (data1.strikeRate - data2.strikeRate));

        compareBatsmanHashMap.put(sortingFields.AVERAGE_RATE, (data1, data2) -> (int) (data1.average - data2.average));

        Comparator<CricketAnalyzerDAO> codeComparator = (f1, f2) -> ((f1.fours * 4 + f1.sixes * 6) < (f2.fours * 4 + f2.sixes * 6) ? -1 : 1);
        compareBatsmanHashMap.put(sortingFields.FOUR_SIX_RATE, codeComparator);
        codeComparator = codeComparator.thenComparing((data1, data2) -> (int) (data1.strikeRate - data2.strikeRate));
        compareBatsmanHashMap.put(sortingFields.FOUR_SIX_STRIKE_RATE, codeComparator);

        Comparator<CricketAnalyzerDAO> codeAvgComparator = (data1, data2) -> ((int) (data1.average - data2.average));
        Comparator<CricketAnalyzerDAO> codeStrikeComparator = (data1, data2) -> ((int) (data1.strikeRate - data2.strikeRate));
        codeComparator.thenComparing(codeStrikeComparator);
        compareBatsmanHashMap.put(SortFields.sortingFields.AVERAGE_STRIKE_RATE, codeAvgComparator);

        Comparator<CricketAnalyzerDAO> codeRunsComparator = (data1, data2) -> ((int) (data1.runs - data2.runs));
        codeComparator.thenComparing(codeAvgComparator);
        compareBatsmanHashMap.put(SortFields.sortingFields.RUNS_AVERAGE_RATE, codeRunsComparator);

        compareBatsmanHashMap.put(SortFields.sortingFields.ECONOMY_RATE,(data1,data2)-> (data1.economicRate  < data2.economicRate)? -1 : 1);

        Comparator comparator = compareBatsmanHashMap.get(sortingFields);
        return comparator;
    }

}
