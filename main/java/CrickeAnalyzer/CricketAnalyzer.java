package CrickeAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<CricketAnalyzerDAO> cricketAnalyseList = new ArrayList<>();


    public int loadIPLBatsmanData(String csvFilePath) throws CricketAnalyserException {

        this.cricketAnalyseList = new CricketLoader().loadIPLData(csvFilePath);
        return cricketAnalyseList.size();
    }

    public int loadIPLBowlerData(String csvFilePath) throws CricketAnalyserException {

        cricketAnalyseList = new CricketLoader().loadIPLBowlerData(csvFilePath);
        return cricketAnalyseList.size();
    }


    public List<CricketAnalyzerDAO> getTopBatsmenRecords(SortFields.sortingFields sortFields) {
        Comparator<CricketAnalyzerDAO> comparator = new SortFields().getFieldBatsman(sortFields);
        cricketAnalyseList = cricketAnalyseList.stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toList());
        return this.cricketAnalyseList;
    }

}