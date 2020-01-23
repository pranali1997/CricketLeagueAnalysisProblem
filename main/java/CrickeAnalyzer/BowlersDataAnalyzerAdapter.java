package CrickeAnalyzer;

import java.util.List;
import java.util.Map;

public class BowlersDataAnalyzerAdapter extends CricketAdapter {

    public <E> Map<String, CricketAnalyzerDAO> loadIPLCricketData(Class<BowlerAnalyzer> bowlerClass,String... csvFilePath) throws CricketAnalyserException {
        Map<String,CricketAnalyzerDAO> cricketAnalyzerDAOList =super.loadIPLData(BowlerAnalyzer.class,csvFilePath[0]);
        return cricketAnalyzerDAOList;
    }
}
