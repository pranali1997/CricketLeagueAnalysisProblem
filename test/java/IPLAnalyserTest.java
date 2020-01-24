import CrickeAnalyzer.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {

private  String IPL_FACT_SHEET_RUNS_PATH="./src/test/resources/IPL2019Runs.csv";
private String IPL_FACT_SHEET_WKTS_PATH="./src/test/resources/IPL2019Wickets.csv";

    @Test
    public void whenGivenTopOfBothAverage_shouldReturnHighestAverage() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATBOWLMERGE);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH,IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> topBatsmenRecords = iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.AVERAGE_RATE_BOTH);
        Assert.assertEquals("MS Dhoni",topBatsmenRecords.get(0).player);
        Assert.assertEquals("Harpreet Brar",topBatsmenRecords.get(99).player);
    }


    @Test
    public void whenGivenTopOfBothRunsAndWickets_shouldReturnAllRounderCricketer() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATBOWLMERGE);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH,IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> topBatsmenRecords = iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.ALL_ROUNDER_CRICKETER);
        Assert.assertEquals("Andre Russell",topBatsmenRecords.get(0).player);
    }

}


