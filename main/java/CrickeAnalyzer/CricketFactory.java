package CrickeAnalyzer;

import csvBuilder.CsvBuilderException;

import java.util.Map;

public class CricketFactory {


    public static Map<String,CricketAnalyzerDAO> loadCricketAnalyzerData(CricketAnalyzer.Cricket cricket, String... csvFilePath) throws CricketAnalyserException, CsvBuilderException {
        if(cricket.equals(CricketAnalyzer.Cricket.BATSMANS)){
            return new BatsmanDataAnalyzerAdapter().loadIPLCricketData(BatsmenAnalyzer.class,csvFilePath);
        }
        else if (cricket.equals(CricketAnalyzer.Cricket.BOWLERS)){
            return new BowlersDataAnalyzerAdapter().loadIPLCricketData(BowlerAnalyzer.class,csvFilePath);
        }
        else if (cricket.equals(CricketAnalyzer.Cricket.BATBOWLMERGE)){
            return new CombineBowlerBatsmanAdapter().loadIPLData(csvFilePath);
        }
        else {
            throw new CricketAnalyserException("INCORRECT _FILE_DATA", CricketAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }
}
