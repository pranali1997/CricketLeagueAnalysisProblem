package CrickeAnalyzer;

import java.util.List;
import java.util.Map;

public abstract class CricketAnalysisFactory {

    public static<E> Map<String,CricketAnalyzerDAO> loadCricketAnalyzerData(CricketAnalyzer.Cricket cricket, String... csvFilePath) throws CricketAnalyserException {
        if(cricket.equals(CricketAnalyzer.Cricket.BATSMANS)){
            return new BatsmanDataAnalyzerAdapter().loadIPLData(csvFilePath);
        }
        else if (cricket.equals(CricketAnalyzer.Cricket.BOWLERS)){
            return new BowlersDataAnalyzerAdapter().loadIPLData(csvFilePath);
        }
            else {
                throw new CricketAnalyserException("INCORRECT _FILE_DATA", CricketAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }
    }
}
