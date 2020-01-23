package CrickeAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    public Cricket cricket;

    public enum Cricket{
        BATSMANS,BOWLERS}


    public CricketAnalyzer(Cricket cricket) {
        this.cricket = cricket;
    }

    List<CricketAnalyzerDAO> cricketAnalyseList = null;


    public int loadCricketAnalyzerData(String... csvFilePath) throws CricketAnalyserException {

        cricketAnalyseList=CricketAnalysisFactory.loadCricketAnalyzerData(cricket,csvFilePath);
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