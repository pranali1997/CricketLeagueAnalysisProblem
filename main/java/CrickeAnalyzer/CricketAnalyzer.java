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

    Map<String,CricketAnalyzerDAO> cricketAnalyseMap = null;


    public int loadCricketAnalyzerData(String... csvFilePath) throws CricketAnalyserException {

        cricketAnalyseMap =CricketAnalysisFactory.loadCricketAnalyzerData(cricket,csvFilePath);
        return cricketAnalyseMap.size();

    }

    public List<CricketAnalyzerDAO> getTopBatsmenRecords(SortFields.sortingFields sortFields) {
        Comparator<CricketAnalyzerDAO> comparator = new SortFields().getFieldCricketer(sortFields);
        List listSorting = cricketAnalyseMap.values().stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toList());
        return listSorting;
    }

}