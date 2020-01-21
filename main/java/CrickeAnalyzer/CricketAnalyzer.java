package CrickeAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<BatsmenAnalyzer> batsmanListValue =new ArrayList<>();
    List<BowlerAnalyzer> bowlerListValue=new ArrayList<>();


    public List loadIPLBatsmanData(String csvFilePath) throws CricketAnalyserException {

        batsmanListValue =new BatsmanLoader().loadIPLData(csvFilePath);
        return batsmanListValue;
    }

    public List<BowlerAnalyzer> loadIPLBowlerData(String csvFilePath) throws CricketAnalyserException {

        bowlerListValue=new BowlerLoader().loadIPLBowlerData(csvFilePath);
        return bowlerListValue;
    }

    public List<BatsmenAnalyzer> getTopBatsmenRecords(SortFields.sortingFields sortFields) {
        Comparator<BatsmenAnalyzer> comparator=new SortFields().getField(sortFields);
        ArrayList arrayListValue= (ArrayList) batsmanListValue.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(arrayListValue);
        return arrayListValue;
    }


    public List<BowlerAnalyzer> getTopBowlersRecords(SortFields.sortingFields sortFields) {
        Comparator<BowlerAnalyzer> comparator=new SortFields().getField(sortFields);
        ArrayList arrayListValue= (ArrayList) bowlerListValue.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(arrayListValue);
        return arrayListValue;
    }

}