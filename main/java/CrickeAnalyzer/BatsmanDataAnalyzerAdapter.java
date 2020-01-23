package CrickeAnalyzer;

import java.util.Map;

public class BatsmanDataAnalyzerAdapter extends CricketAdapter {

/*
    @Override
    public <E> Map<String,CricketAnalyzerDAO> loadIPLData(String... csvFilePath) throws CricketAnalyserException {
        Map<String,CricketAnalyzerDAO> cricketDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
        return cricketDAO;
    }

*/

    public <E> Map<String, CricketAnalyzerDAO> loadIPLCricketData(Class<BatsmenAnalyzer> batsmanClass,String... csvFilePath) throws CricketAnalyserException {
        Map<String,CricketAnalyzerDAO> cricketDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
        return cricketDAO;

    }
}
