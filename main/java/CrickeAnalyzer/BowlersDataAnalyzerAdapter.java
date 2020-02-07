package CrickeAnalyzer;


import csvBuilder.CsvBuilderException;

import java.util.Map;

public class BowlersDataAnalyzerAdapter extends CricketAdapter {

    public <E> Map<String, CricketAnalyzerDAO> loadIPLCricketData(Class<BowlerAnalyzer> bowlerClass,String... csvFilePath) throws CricketAnalyserException, CsvBuilderException {
        Map<String,CricketAnalyzerDAO> cricketAnalyzerDAOMap =super.loadIPLData(BowlerAnalyzer.class,csvFilePath[0]);
        return cricketAnalyzerDAOMap;
    }
}
