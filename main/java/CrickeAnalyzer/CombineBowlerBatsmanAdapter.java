package CrickeAnalyzer;

import java.util.Map;

public class CombineBowlerBatsmanAdapter extends CricketAdapter {


    public <E> Map<String, CricketAnalyzerDAO> loadIPLData( String[] csvFilePath) throws CricketAnalyserException {

        Map<String,CricketAnalyzerDAO> cricketBatsmanDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
        Map<String,CricketAnalyzerDAO> cricketBowlerDAO=super.loadIPLData(BowlerAnalyzer.class,csvFilePath[1]);
        cricketBowlerDAO.values().stream()
                .filter(cricketData-> cricketBatsmanDAO.get(cricketData.player)!=null)
                .forEach(cricketData->cricketBatsmanDAO.get(cricketData.player).bowlAverage=cricketData.bowlAverage);




//        cricketBatsmanDAO.values().stream().filter(cricketData-> cricketBowlerDAO.get(cricketData.player)!=null)
//                .forEach(cricketData->cricketBatsmanDAO.get(cricketData.player).wickets=cricketData.wickets);

        return cricketBatsmanDAO;

    }


//    @Override
//    public <E> Map<String,CricketAnalyzerDAO> loadIPLData(CricketAnalyzer.Cricket cricket,String... csvFilePath) throws CricketAnalyserException {
//
//        Map<String,CricketAnalyzerDAO> cricketBatsmanDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
//        Map<String,CricketAnalyzerDAO> cricketBowlerDAO=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
//        cricketBatsmanDAO.values().stream().filter(cricketData-> cricketBatsmanDAO.get(cricketData.player)!=null)
//                .forEach(cricketData->cricketBatsmanDAO.get(cricketData.player).average=cricketData.average);
//
//
//
//
//        cricketBatsmanDAO.values().stream().filter(cricketData-> cricketBowlerDAO.get(cricketData.player)!=null)
//                .forEach(cricketData->cricketBatsmanDAO.get(cricketData.player).wickets=cricketData.wickets);
//
//        return cricketBatsmanDAO;
//
//    }
}
