package CrickeAnalyzer;

import java.util.List;
import java.util.Map;

public class BowlersDataAnalyzerAdapter extends CricketAdapter {
/*

    @Override
    public <E> Map<String,CricketAnalyzerDAO> loadIPLData(String... csvFilePath) throws CricketAnalyserException {
    Map<String,CricketAnalyzerDAO> cricketAnalyzerDAOList =super.loadIPLData(BowlerAnalyzer.class,csvFilePath[0]);
    return cricketAnalyzerDAOList;

    }
*/


    public <E> Map<String, CricketAnalyzerDAO> loadIPLCricketData(Class<BowlerAnalyzer> bowlerClass,String... csvFilePath) throws CricketAnalyserException {
        Map<String,CricketAnalyzerDAO> cricketAnalyzerDAOList =super.loadIPLData(BowlerAnalyzer.class,csvFilePath[0]);
        return cricketAnalyzerDAOList;
    }
}
