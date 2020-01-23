package CrickeAnalyzer;

import java.util.Map;

public class CombineBowlerBatsmanAdapter extends CricketAdapter {


    public <E> Map<String, CricketAnalyzerDAO> loadIPLData( String[] csvFilePath) throws CricketAnalyserException {

        Map<String,CricketAnalyzerDAO> cricketBatsmanDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
        Map<String,CricketAnalyzerDAO> cricketBowlerDAO=super.loadIPLData(BowlerAnalyzer.class,csvFilePath[1]);
        cricketBowlerDAO.values().stream()
                .filter(cricketData-> cricketBatsmanDAO.get(cricketData.player)!=null)
                .forEach(cricketData->cricketBatsmanDAO.get(cricketData.player).bowlAverage=cricketData.bowlAverage);

        return cricketBatsmanDAO;

    }

}
