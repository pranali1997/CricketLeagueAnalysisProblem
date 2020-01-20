package CrickeAnalyzer;


import java.util.*;

public class SortFields {

    public enum sortingFields{
        AVERAGE_RATE,STRIKE_RATE, FOUR_SIX_RATE,FOUR_SIX_STRIKE_RATE,AVERAGE_STRIKE_RATE,RUNS_AVERAGE_RATE,RUN_RATE;
    }

    HashMap<sortingFields,Comparator<BatsmenAnalyzer>> compareHashMap =new HashMap<>();

    public Comparator getField(sortingFields sortingFields){

        compareHashMap.put(sortingFields.STRIKE_RATE,(data1, data2)-> (int) (data1.strikeRate-data2.strikeRate));

        compareHashMap.put(sortingFields.AVERAGE_RATE,(data1, data2)-> (int) (data1.average-data2.average));

        Comparator<BatsmenAnalyzer> codeComparator=(f1, f2)-> ((f1.fours*4+f1.sixes*6) < (f2.fours*4+f2.sixes*6)?-1:1);
        compareHashMap.put(sortingFields.FOUR_SIX_RATE,codeComparator);
        codeComparator=codeComparator.thenComparing((data1,data2)-> (int) (data1.strikeRate-data2.strikeRate));
        compareHashMap.put(sortingFields.FOUR_SIX_STRIKE_RATE,codeComparator);

        Comparator<BatsmenAnalyzer> codeAvgComparator=(data1,data2)->((int) (data1.average-data2.average));
        Comparator<BatsmenAnalyzer> codeStrikeComparator=(data1,data2)->((int) (data1.strikeRate-data2.strikeRate));
        codeComparator.thenComparing(codeStrikeComparator);
        compareHashMap.put(SortFields.sortingFields.AVERAGE_STRIKE_RATE,codeAvgComparator);

        Comparator<BatsmenAnalyzer> codeRunsComparator=(data1,data2)->((int) (data1.runs-data2.runs));
        codeComparator.thenComparing(codeAvgComparator);
        compareHashMap.put(SortFields.sortingFields.RUNS_AVERAGE_RATE,codeRunsComparator);

        Comparator comparator= compareHashMap.get(sortingFields);
        return comparator;
    }
}
