package CrickeAnalyzer;



import csvBuilder.CSVBuilderFactory;
import csvBuilder.CsvBuilderException;
import csvBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.StreamSupport;

public abstract class CricketAdapter {


    public<E> Map<String,CricketAnalyzerDAO> loadIPLData(Class<E> CricketCSVClass, String... csvFilePath) throws CricketAnalyserException, CsvBuilderException {
        Map<String,CricketAnalyzerDAO> mapValue =new TreeMap<>();

     try (Reader reader = Files.newBufferedReader(Paths.get(String.valueOf(csvFilePath[0])))){
        ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
         List<E> playerList1 = icsvBuilder.getCSVFileList(reader, CricketCSVClass);
        if (CricketCSVClass.getName().equals("CrickeAnalyzer.BatsmenAnalyzer")) {
            StreamSupport.stream(playerList1.spliterator(), false)
                    .map(BatsmenAnalyzer.class::cast)
                    .forEach(cricketCSV -> mapValue.put(cricketCSV.player,new CricketAnalyzerDAO(cricketCSV)));
        }
         if (CricketCSVClass.getName().equals("CrickeAnalyzer.BowlerAnalyzer")) {
             StreamSupport.stream(playerList1.spliterator(),false)
                     .map(BowlerAnalyzer.class::cast)
                     .forEach(cricketCSV -> mapValue.put(cricketCSV.player,new CricketAnalyzerDAO(cricketCSV)));
         }
             return mapValue;

    }    catch (IOException e) {
        throw new CricketAnalyserException(e.getMessage(),
                CricketAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
    } catch (CsvBuilderException e) {
        e.printStackTrace();
    }
        return mapValue;
    }



}

