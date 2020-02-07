import CrickeAnalyzer.*;
import csvBuilder.CsvBuilderException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class BatsmanAnalyzerMockitoTest {

    private String IPL_FACT_SHEET_WKTS_PATH="./src/test/resources/IPL2019Wickets.csv";

    @Mock
    CricketAnalysisLoader cricketAnalysisLoaderMock;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    @Test
    public void whenGivenIPLAnalyzerDataForBowler_ShouldReturnCorrectRecords() throws CricketAnalyserException, CsvBuilderException {
        CricketAnalyzer iplAnalyzer = new CricketAnalyzer(CricketAnalyzer.Cricket.BOWLERS);
        Map<String, CricketAnalyzerDAO> cricketAnalyzerMap = new HashMap<>();
        CricketAnalyzerDAO cricketAnalyzerDAO=new CricketAnalyzerDAO();
        cricketAnalyzerMap.put("Imran Tahir", cricketAnalyzerDAO);
        CricketAnalyzer cricketAnalyzer=new CricketAnalyzer(cricketAnalysisLoaderMock,CricketAnalyzer.Cricket.BOWLERS);
        when(cricketAnalysisLoaderMock.loadCricketAnalyzerData(CricketAnalyzer.Cricket.BOWLERS,IPL_FACT_SHEET_WKTS_PATH)).thenReturn(cricketAnalyzerMap);
        int numberOfRecords=cricketAnalyzer.loadCricketAnalyzerData(IPL_FACT_SHEET_WKTS_PATH);
        Assert.assertEquals(1,numberOfRecords);
        Assert.assertEquals(1,cricketAnalyzerMap.size());
    }


}
