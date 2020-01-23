package CrickeAnalyzer;

import java.util.Map;

public abstract class CricketAnalysisFactory {

    public static<E> Map<String,CricketAnalyzerDAO> loadCricketAnalyzerData(CricketAnalyzer.Cricket cricket, String... csvFilePath) throws CricketAnalyserException {
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
