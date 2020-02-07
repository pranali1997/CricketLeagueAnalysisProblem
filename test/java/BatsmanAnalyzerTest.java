import CrickeAnalyzer.BatsmenAnalyzer;
import CrickeAnalyzer.CricketAnalyserException;
import CrickeAnalyzer.CricketAnalyzer;
import CrickeAnalyzer.SortFields;
import csvBuilder.CsvBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BatsmanAnalyzerTest {

    private  String IPL_FACT_SHEET_RUNS_PATH="./src/test/resources/IPL2019Runs.csv";

    @Test
    public void whenGivenIPLAnalyzerData_ShouldReturnCorrectRecords() {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        int numberOfRecords= 0;
        try {
            numberOfRecords = iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        } catch (csvBuilder.CsvBuilderException | CricketAnalyserException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(100,numberOfRecords);
    }

    @Test
    public void whenGivenTopAverage_shouldReturnHighestAverage() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> topBatsmenRecords = iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.AVERAGE_RATE);
        Assert.assertEquals("MS Dhoni",topBatsmenRecords.get(0).player);
    }

    @Test
    public void whenGivenSoredStrikeRate_ShouldReturnHighestRecord() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.STRIKE_RATE);
        Assert.assertEquals("Ishant Sharma",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixes_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.FOUR_SIX_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedFoursAndSixesAndStrikeRate_ShouldReturnHighestNumberOfFOrsAndSixes() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.FOUR_SIX_STRIKE_RATE);
        Assert.assertEquals("Andre Russell",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndStrikeRate_ShouldReturnHighestNumberOfAverageWithStrikeRate() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.AVERAGE_STRIKE_RATE);
        Assert.assertEquals("MS Dhoni",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndRuns_ShouldReturnHighestNumberOfAverageWithRuns() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BATSMANS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_RUNS_PATH);
        List<BatsmenAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.RUNS_AVERAGE_RATE);
        Assert.assertEquals("David Warner",iplAnalyzerCSVList.get(0).player);
    }

}
