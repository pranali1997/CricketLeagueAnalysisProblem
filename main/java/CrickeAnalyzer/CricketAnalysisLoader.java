package CrickeAnalyzer;

import csvBuilder.CsvBuilderException;

import java.util.Map;

public class CricketAnalysisLoader {

    CricketFactory cricketFactory = new CricketFactory();

    public Map<String, CricketAnalyzerDAO> loadCricketAnalyzerData(CricketAnalyzer.Cricket cricket, String... csvFilePath) throws CricketAnalyserException, CsvBuilderException {

        return CricketFactory.loadCricketAnalyzerData(cricket, csvFilePath);
    }
}