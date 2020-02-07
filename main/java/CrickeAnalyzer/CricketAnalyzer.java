package CrickeAnalyzer;

import csvBuilder.CsvBuilderException;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    public Cricket cricket;
    private CricketAnalysisLoader cricketAnalyzerFactory=new CricketAnalysisLoader();

    public CricketAnalyzer(CricketAnalysisLoader cricketAnalysisLoaderMock, Cricket cricket) {
        this.cricketAnalyzerFactory= cricketAnalysisLoaderMock;
        this.cricket=cricket;
    }

    public enum Cricket{
        BATSMANS,BOWLERS,BATBOWLMERGE}


    public CricketAnalyzer(Cricket cricket) {
        this.cricket = cricket;
    }

    Map<String,CricketAnalyzerDAO> cricketAnalyseMap = new TreeMap<>();


    public int loadCricketAnalyzerData(String... csvFilePath) throws CricketAnalyserException, CsvBuilderException {

        cricketAnalyseMap = cricketAnalyzerFactory.loadCricketAnalyzerData(cricket,csvFilePath);
        return cricketAnalyseMap.size();

    }

    public ArrayList getTopCricketRecords(SortFields.sortingFields sortFields) {
        Comparator<CricketAnalyzerDAO> comparator = new SortFields().getFieldCricketer(sortFields);
        ArrayList listSorting = (ArrayList) cricketAnalyseMap.values().stream()
                .sorted(comparator)
                .map(CricketDAO-> CricketDAO.getCricketDTO(cricket))
                .collect(Collectors.toList());
        return listSorting;
    }
}