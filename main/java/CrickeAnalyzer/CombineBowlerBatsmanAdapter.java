package CrickeAnalyzer;

import csvBuilder.CsvBuilderException;

import java.util.Map;

public class CombineBowlerBatsmanAdapter extends CricketAdapter {


    public <E> Map<String, CricketAnalyzerDAO> loadIPLData( String[] csvFilePath) throws CricketAnalyserException, CsvBuilderException {

        Map<String,CricketAnalyzerDAO> cricketBatsmanDAOMap=super.loadIPLData(BatsmenAnalyzer.class,csvFilePath[0]);
        Map<String,CricketAnalyzerDAO> cricketBowlerDAOMap=super.loadIPLData(BowlerAnalyzer.class,csvFilePath[1]);
        cricketBowlerDAOMap.values().stream()
                .filter(cricketData-> cricketBatsmanDAOMap.get(cricketData.player)!=null)
                .forEach(cricketData->{cricketBatsmanDAOMap.get(cricketData.player).
                        bowlAverage=cricketData.bowlAverage;
                        cricketBatsmanDAOMap.get(cricketData.player).wickets=cricketData.wickets;
                });

        return cricketBatsmanDAOMap;

    }

}
