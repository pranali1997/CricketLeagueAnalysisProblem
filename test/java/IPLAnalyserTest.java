import CrickeAnalyzer.IPLAnalyserException;
import CrickeAnalyzer.IPLAnalyzer;
import CrickeAnalyzer.IPLAnalyzerCSV;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {

private  String IPL_FACT_SHEET_RUNS_PATH="./src/test/resources/IPL2019Runs.csv";

    @Test
    public void whenGivenIPLAnalyzerData_ShouldReturnCorrectRecords() throws IPLAnalyserException {
        IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
        int numberOfRecords=iplAnalyzer.loadIPLData(IPL_FACT_SHEET_RUNS_PATH);
        Assert.assertEquals(100,numberOfRecords);
    }

    @Test
    public void whenGivenTopAverage_shouldReturnHighestAverage() throws IPLAnalyserException {
        IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
        iplAnalyzer.loadIPLData(IPL_FACT_SHEET_RUNS_PATH);
        List<IPLAnalyzerCSV> iplCSVList=iplAnalyzer.sortingIPLDataAverageRuns();
        Assert.assertEquals(83.2, iplCSVList.get(0).average ,0);
    }

    @Test
    public void whenGivenSoredStrikeRate_ShouldReturnHighestRecord() throws IPLAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadIPLData(IPL_FACT_SHEET_RUNS_PATH);
        List<IPLAnalyzerCSV> iplCSVList=iplAnalyzer.sortingIPLDataStrikeRate();
        Assert.assertEquals(333.33,iplCSVList.get(0).strikeRate,0);

    }

    @Test
    public void whenGivenSortedFoursAndSixes_ShouldReturnHighestNumberOfFOrsAndSixes() throws IPLAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadIPLData(IPL_FACT_SHEET_RUNS_PATH);
        List<IPLAnalyzerCSV> iplAnalyzerCSVList=iplAnalyzer.sortingIPLDataBYFoursANDSixes();
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixesAndStrikeRate_ShouldReturnHighestNumberOfFOrsAndSixes() throws IPLAnalyserException {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadIPLData(IPL_FACT_SHEET_RUNS_PATH);
        List<IPLAnalyzerCSV> iplAnalyzerCSVList=iplAnalyzer.sortingStrikeRateBYFoursANDSixes();
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }


}
