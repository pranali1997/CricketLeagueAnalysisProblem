package CrickeAnalyzer;

import java.util.List;

public class BowlersDataAnalyzerAdapter extends CricketAdapter {

    @Override
    public <E> List<CricketAnalyzerDAO> loadIPLData(String... csvFilePath) throws CricketAnalyserException {
    List<CricketAnalyzerDAO> cricketAnalyzerDAOList =super.loadIPLData(BowlerAnalyzer.class,csvFilePath[0]);
    return cricketAnalyzerDAOList;

    }
}
