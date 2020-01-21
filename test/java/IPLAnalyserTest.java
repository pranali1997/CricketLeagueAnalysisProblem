import CrickeAnalyzer.BatsmenAnalyzer;
import CrickeAnalyzer.CricketAnalyserException;
import CrickeAnalyzer.CricketAnalyzer;
import CrickeAnalyzer.SortFields;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {

private  String IPL_FACT_SHEET_RUNS_PATH="./src/test/resources/IPL2019Runs.csv";
private String IPL_FACT_SHEET_WKTS_PATH="./src/test/resources/IPL2019Wickets.csv";

    @Test
    public void whenGivenIPLAnalyzerData_ShouldReturnCorrectRecords() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer();
        List numberOfRecords=iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        Assert.assertEquals(100,numberOfRecords.size());
    }

    @Test
    public void whenGivenTopAverage_shouldReturnHighestAverage() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplCSVList=iplAnalyzer.getTopRecords(SortFields.sortingFields.AVERAGE_RATE);
        Assert.assertEquals(83.2, iplCSVList.get(0).average ,0);
    }

    @Test
    public void whenGivenSoredStrikeRate_ShouldReturnHighestRecord() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplCSVList=iplAnalyzer.getTopRecords(SortFields.sortingFields.STRIKE_RATE);
        Assert.assertEquals(333.33,iplCSVList.get(0).strikeRate,0);

    }

    @Test
    public void whenGivenSortedFoursAndSixes_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopRecords(SortFields.sortingFields.FOUR_SIX_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixesAndStrikeRate_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopRecords(SortFields.sortingFields.FOUR_SIX_STRIKE_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndStrikeRate_ShouldReturnHighestNumberOfAverageWithStrikeRate() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopRecords(SortFields.sortingFields.AVERAGE_STRIKE_RATE);
        Assert.assertEquals("MS Dhoni",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndRuns_ShouldReturnHighestNumberOfAverageWithRuns() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer();
        iplAnalyzer.loadIPLBatsmanData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopRecords(SortFields.sortingFields.RUNS_AVERAGE_RATE);
        Assert.assertEquals("David Warner",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenIPLAnalyzerDataForBowler_ShouldReturnCorrectRecords() throws CricketAnalyserException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer();
        List numberOfRecords=iplAnalyzer.loadIPLBowlerData(IPL_FACT_SHEET_WKTS_PATH);
        Assert.assertEquals(99,numberOfRecords.size());
    }

}
