package CrickeAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<BatsmenAnalyzerDAO> batsmanListValue =new ArrayList<>();
    List<BowlerAnalyzer> bowlerListValue=new ArrayList<>();


    public int loadIPLBatsmanData(String csvFilePath) throws CricketAnalyserException {

        this.batsmanListValue =new BatsmanLoader().loadIPLData(csvFilePath);
        return batsmanListValue.size();
    }

    public int loadIPLBowlerData(String csvFilePath) throws CricketAnalyserException {

        bowlerListValue=new BowlerLoader().loadIPLBowlerData(csvFilePath);
        return bowlerListValue.size();
    }


    public List<BatsmenAnalyzerDAO> getTopBatsmenRecords(SortFields.sortingFields sortFields) {
        Comparator<BatsmenAnalyzerDAO> comparator=new SortFields().getFieldBatsman(sortFields);
        batsmanListValue = batsmanListValue.stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toList());
        return this.batsmanListValue;
    }

    public List<BowlerAnalyzer> getTopBowlersRecords(SortFields.sortingFields sortFields) {
        Comparator<BowlerAnalyzer> comparator=new SortFields().getFieldBowler(sortFields);
        ArrayList arrayListValue= (ArrayList) bowlerListValue.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(arrayListValue);
        return arrayListValue;
    }


}