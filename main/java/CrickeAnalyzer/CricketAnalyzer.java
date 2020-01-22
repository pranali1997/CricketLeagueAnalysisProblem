package CrickeAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<CricketAnalyzerDAO> cricketAnalyseList = new ArrayList<>();


    public int loadCricketAnalyzerData(String csvFilePath) throws CricketAnalyserException {

        if(csvFilePath=="./src/test/resources/IPL2019Runs.csv") {
            this.cricketAnalyseList = new CricketLoader().loadIPLData(csvFilePath);
        }
        if(csvFilePath=="./src/test/resources/IPL2019Wickets.csv") {
            cricketAnalyseList = new CricketLoader().loadIPLData(csvFilePath);
        }
        return cricketAnalyseList.size();

    }

    public List<CricketAnalyzerDAO> getTopBatsmenRecords(SortFields.sortingFields sortFields) {
        Comparator<CricketAnalyzerDAO> comparator = new SortFields().getFieldCricketer(sortFields);
        cricketAnalyseList = cricketAnalyseList.stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toList());
        return this.cricketAnalyseList;
    }

}