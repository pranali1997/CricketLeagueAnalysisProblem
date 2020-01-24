import CrickeAnalyzer.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {

private  String IPL_FACT_SHEET_RUNS_PATH="./src/test/resources/IPL2019Runs.csv";
private String IPL_FACT_SHEET_WKTS_PATH="./src/test/resources/IPL2019Wickets.csv";

    @Test
    public void whenGivenIPLAnalyzerData_ShouldReturnCorrectRecords() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        int numberOfRecords=iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        Assert.assertEquals(100,numberOfRecords);
    }

    @Test
    public void whenGivenTopAverage_shouldReturnHighestAverage() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> topBatsmenRecords = iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.AVERAGE_RATE);
        Assert.assertEquals("MS Dhoni",topBatsmenRecords.get(0).player);
    }

    @Test
    public void whenGivenSoredStrikeRate_ShouldReturnHighestRecord() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.STRIKE_RATE);
        Assert.assertEquals("Ishant Sharma",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixes_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.FOUR_SIX_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixesAndStrikeRate_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.FOUR_SIX_STRIKE_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndStrikeRate_ShouldReturnHighestNumberOfAverageWithStrikeRate() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.AVERAGE_STRIKE_RATE);
        Assert.assertEquals("MS Dhoni",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndRuns_ShouldReturnHighestNumberOfAverageWithRuns() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.RUNS_AVERAGE_RATE);
        Assert.assertEquals("David Warner",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenIPLAnalyzerDataForBowler_ShouldReturnCorrectRecords() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        int numberOfRecords=iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        Assert.assertEquals(99,numberOfRecords);
    }

    @Test
    public void whenGivenSortedAverageBowlersData_shouldReturnSortedAverageDataInDescendingOrder() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.BOWLER_AVERAGE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSoredBowlersStrikeRate_ShouldReturnSortedStrikeRateDataInDescendingOrder() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.BOWLER_STRIKE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSoredBowlersEconpomyRate_ShouldReturnSortedEconomyRateDataInDescendingOrder() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.ECONOMY_RATE);
        Assert.assertEquals("Ben Cutting",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSoredBowlersStrikeRateFourWicketsAndFiveWicketsRate_ShouldReturnSortedStrikeRateFourWicketsAndFiveWicketsRateDataInDescendingOrder() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.BOWLER_FOUR_WICKETS_AND_FIVE_WICKETS_STRIKE);
        Assert.assertEquals("Krishnappa Gowtham",iplCSVList.get(0).player);
    }
    @Test
    public void whenGivenSortedAverageAndStrikeRateOfBowler_ShouldReturnHighestNumberOfAverageWithStrikeRate() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.BOWLER_AVERAGE_STRIKE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndWicketsRateOfBowler_ShouldReturnHighestNumberOfWicketsWithAverageRate() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.AVERAGE_WICKET_RATE);
        Assert.assertEquals("Imran Tahir",iplCSVList.get(0).player);
    }


    @Test
    public void whenGivenTopOfBothAverage_shouldReturnHighestAverage() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATBOWLMERGE);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH,IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> topBatsmenRecords = iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.AVERAGE_RATE_BOTH);
        Assert.assertEquals("MS Dhoni",topBatsmenRecords.get(0).player);
        Assert.assertEquals("Harpreet Brar",topBatsmenRecords.get(99).player);
    }


    @Test
    public void whenGivenTopOfBothRunsAndWickets_shouldReturnAllRounderCricketer() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATBOWLMERGE);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH,IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> topBatsmenRecords = iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.ALL_ROUNDER_CRICKETER);
        for(int i=0;i< topBatsmenRecords.size(); i++){
            System.out.println(" "+topBatsmenRecords.get(i).player+ " "+ topBatsmenRecords.get(i).runs);
        }
        Assert.assertEquals("Andre Russell",topBatsmenRecords.get(0).player);
    }

}


