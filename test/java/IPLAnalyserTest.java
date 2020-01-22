import CrickeAnalyzer.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {

private  String IPL_FACT_SHEET_RUNS_PATH="./src/test/resources/IPL2019Runs.csv";
private String IPL_FACT_SHEET_WKTS_PATH="./src/test/resources/IPL2019Wickets.csv";

    @Test
    public void whenGivenIPLAnalyzerData_ShouldReturnCorrectRecords() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer();
        int numberOfRecords=iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        Assert.assertEquals(100,numberOfRecords);
    }

    @Test
    public void whenGivenTopAverage_shouldReturnHighestAverage() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<CricketAnalyzerDAO> topBatsmenRecords = iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.AVERAGE_RATE);
        Assert.assertEquals("MS Dhoni",topBatsmenRecords.get(0).player);
    }

    @Test
    public void whenGivenSoredStrikeRate_ShouldReturnHighestRecord() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<CricketAnalyzerDAO> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.STRIKE_RATE);
        Assert.assertEquals("Ishant Sharma",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixes_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<CricketAnalyzerDAO> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.FOUR_SIX_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixesAndStrikeRate_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<CricketAnalyzerDAO> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.FOUR_SIX_STRIKE_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndStrikeRate_ShouldReturnHighestNumberOfAverageWithStrikeRate() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<CricketAnalyzerDAO> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.AVERAGE_STRIKE_RATE);
        Assert.assertEquals("MS Dhoni",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndRuns_ShouldReturnHighestNumberOfAverageWithRuns() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<CricketAnalyzerDAO> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.RUNS_AVERAGE_RATE);
        Assert.assertEquals("David Warner",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenIPLAnalyzerDataForBowler_ShouldReturnCorrectRecords() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer();
        int numberOfRecords=iplAnalyzer.loadIPLBowlerData(IPL_FACT_SHEET_WKTS_PATH);
        Assert.assertEquals(99,numberOfRecords);
    }

    @Test
    public void whenGivenSortedAverageBowlersData_shouldReturnSortedAverageDataInDescendingOrder() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer();
        iplAnalyzer.loadIPLBowlerData(IPL_FACT_SHEET_WKTS_PATH);
        List<CricketAnalyzerDAO> iplAnalyzerCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.AVERAGE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSoredBowlersStrikeRate_ShouldReturnSortedStrikeRateDataInDEscendingOrder() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBowlerData(IPL_FACT_SHEET_WKTS_PATH);
        List<CricketAnalyzerDAO> iplCSVList=iplAnalyzer.getTopBatsmenRecords(SortFields.sortingFields.STRIKE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplCSVList.get(0).player);
    }


}
