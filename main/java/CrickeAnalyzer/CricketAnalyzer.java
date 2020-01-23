package CrickeAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    public Cricket cricket;

    public enum Cricket{
        BATSMANS,BOWLERS,BATBOWLMERGE}


    public CricketAnalyzer(Cricket cricket) {
        this.cricket = cricket;
    }

    Map<String,CricketAnalyzerDAO> cricketAnalyseMap = new TreeMap<>();


    public int loadCricketAnalyzerData(String... csvFilePath) throws CricketAnalyserException {

        cricketAnalyseMap =CricketAnalysisFactory.loadCricketAnalyzerData(cricket,csvFilePath);
        System.out.println(cricketAnalyseMap);
        return cricketAnalyseMap.size();

    }

    public List<CricketAnalyzerDAO> getTopBatsmenRecords(SortFields.sortingFields sortFields) {
        Comparator<CricketAnalyzerDAO> comparator = new SortFields().getFieldCricketer(sortFields);
        List listSorting = cricketAnalyseMap.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return listSorting;
    }

}