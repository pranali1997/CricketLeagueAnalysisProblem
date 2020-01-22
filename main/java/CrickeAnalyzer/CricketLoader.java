package CrickeAnalyzer;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class CricketLoader {

    List<CricketAnalyzerDAO> listValue=new ArrayList<>();

    public<E> List<CricketAnalyzerDAO> loadIPLData(String csvFilePath) throws CricketAnalyserException {

     try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
        ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
        if (csvFilePath=="./src/test/resources/IPL2019Runs.csv") {
            List<E> playerList1 = icsvBuilder.getCSVList(reader, BatsmenAnalyzer.class);
            StreamSupport.stream(playerList1.spliterator(), false)
                    .map(BatsmenAnalyzer.class::cast)
                    .forEach(cricketCSV -> listValue.add(new CricketAnalyzerDAO(cricketCSV)));
        }
         if (csvFilePath=="./src/test/resources/IPL2019Wickets.csv") {
             List<E> playerList1= icsvBuilder.getCSVList(reader, BowlerAnalyzer.class);
             StreamSupport.stream(playerList1.spliterator(),false)
                     .map(BowlerAnalyzer.class::cast)
                     .forEach(cricketCSV -> listValue.add(new CricketAnalyzerDAO(cricketCSV)));
         }
             return listValue;

    }    catch (IOException e) {
        throw new CricketAnalyserException(e.getMessage(),
                CricketAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
    } catch (CSVBuilderException e) {
        e.printStackTrace();
    }
        return null;
    }

}
