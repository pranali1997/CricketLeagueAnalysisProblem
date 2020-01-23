package CrickeAnalyzer;

import java.util.List;

public class BatsmanDataAnalyzerAdapter extends CricketAdapter {

    @Override
    public <E> List<CricketAnalyzerDAO> loadIPLData(String... csvFilePath) throws CricketAnalyserException {
        List<CricketAnalyzerDAO> cricketDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
        return cricketDAO;
    }
}
