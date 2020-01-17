import CrickeAnalyzer.IPLAnalyserException;
import CrickeAnalyzer.IPLAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest {

private  String IPL_FACT_SHEET_RUNS_PATH="./src/test/resources/IPL2019Runs.csv";

    @Test
    public void whenGivenIPLAnalyzerData_ShouldReturnCorrectRecords() throws IPLAnalyserException {
        IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
        int numberOfRecords=iplAnalyzer.loadIPLData(IPL_FACT_SHEET_RUNS_PATH);
        Assert.assertEquals(100,numberOfRecords);
    }

}
