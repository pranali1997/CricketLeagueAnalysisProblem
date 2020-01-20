package CrickeAnalyzer;


import java.util.*;

public class SortFields {

    public enum sortingFields{
        AVERAGE_RATE,STRIKE_RATE, FOUR_SIX_RATE,FOUR_SIX_STRIKE_RATE;
    }

    HashMap<sortingFields,Comparator<BatsmenAnalyzer>> compareHashMap =new HashMap<>();
    public Comparator getField(sortingFields sortingFields){


        compareHashMap.put(sortingFields.STRIKE_RATE,(data1, data2)-> (int) (data1.strikeRate-data2.strikeRate));
        compareHashMap.put(sortingFields.AVERAGE_RATE,(data1, data2)-> (int) (data1.average-data2.average));

        Comparator<BatsmenAnalyzer> codeComparator=(p1, p2)-> new Integer((p1.fours*4+p1.sixes*6) < (p2.fours*4+p2.sixes*6)?-1:1);
        compareHashMap.put(sortingFields.FOUR_SIX_RATE,codeComparator);
        codeComparator=codeComparator.thenComparing((data1,data2)-> (int) (data1.strikeRate-data2.strikeRate));


        compareHashMap.put(sortingFields.FOUR_SIX_STRIKE_RATE,codeComparator);

        Comparator comparator= compareHashMap.get(sortingFields);

        return comparator;
    }
}
