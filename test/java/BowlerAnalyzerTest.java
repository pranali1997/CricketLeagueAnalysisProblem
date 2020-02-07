import CrickeAnalyzer.BowlerAnalyzer;
import CrickeAnalyzer.CricketAnalyserException;
import CrickeAnalyzer.CricketAnalyzer;
import CrickeAnalyzer.SortFields;
import csvBuilder.CsvBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BowlerAnalyzerTest {


    private String IPL_FACT_SHEET_WKTS_PATH="./src/test/resources/IPL2019Wickets.csv";



    @Test
    public void whenGivenIPLAnalyzerDataForBowler_ShouldReturnCorrectRecords() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        int numberOfRecords=iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        Assert.assertEquals(99,numberOfRecords);
    }

    @Test
    public void whenGivenSortedAverageBowlersData_shouldReturnSortedAverageDataInDescendingOrder() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplAnalyzerCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.BOWLER_AVERAGE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplAnalyzerCSVList.get(0).player);
    }

    @Test
    public void whenGivenSoredBowlersStrikeRate_ShouldReturnSortedStrikeRateDataInDescendingOrder() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.BOWLER_STRIKE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSoredBowlersEconpomyRate_ShouldReturnSortedEconomyRateDataInDescendingOrder() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.ECONOMY_RATE);
        Assert.assertEquals("Ben Cutting",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSoredBowlersStrikeRateFourWicketsAndFiveWicketsRate_ShouldReturnSortedStrikeRateFourWicketsAndFiveWicketsRateDataInDescendingOrder() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.BOWLER_FOUR_WICKETS_AND_FIVE_WICKETS_STRIKE);
        Assert.assertEquals("Krishnappa Gowtham",iplCSVList.get(0).player);
    }
    @Test
    public void whenGivenSortedAverageAndStrikeRateOfBowler_ShouldReturnHighestNumberOfAverageWithStrikeRate() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.BOWLER_AVERAGE_STRIKE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",iplCSVList.get(0).player);
    }

    @Test
    public void whenGivenSortedAverageAndWicketsRateOfBowler_ShouldReturnHighestNumberOfWicketsWithAverageRate() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer=new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        iplAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        List<BowlerAnalyzer> iplCSVList=iplAnalyzer.getTopCricketRecords(SortFields.sortingFields.AVERAGE_WICKET_RATE);
        Assert.assertEquals("Imran Tahir",iplCSVList.get(0).player);
    }


}
