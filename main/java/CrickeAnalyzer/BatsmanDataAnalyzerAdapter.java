package CrickeAnalyzer;

import java.util.List;
import java.util.Map;

public class BatsmanDataAnalyzerAdapter extends CricketAdapter {

    @Override
    public <E> Map<String,CricketAnalyzerDAO> loadIPLData(String... csvFilePath) throws CricketAnalyserException {
        Map<String,CricketAnalyzerDAO> cricketDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
        return cricketDAO;
    }
}
