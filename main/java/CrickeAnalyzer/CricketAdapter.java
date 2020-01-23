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

public abstract class CricketAdapter {

    List<CricketAnalyzerDAO> listValue=new ArrayList<>();

    public<E> List<CricketAnalyzerDAO> loadIPLData(Class<E> CricketCSVClass,String... csvFilePath) throws CricketAnalyserException {

     try (Reader reader = Files.newBufferedReader(Paths.get(String.valueOf(csvFilePath[0])))){
        ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
         List<E> playerList1 = icsvBuilder.getCSVList(reader, CricketCSVClass);
        if (CricketCSVClass.getName().equals("CrickeAnalyzer.BatsmenAnalyzer")) {
            StreamSupport.stream(playerList1.spliterator(), false)
                    .map(BatsmenAnalyzer.class::cast)
                    .forEach(cricketCSV -> listValue.add(new CricketAnalyzerDAO(cricketCSV)));
        }
         if (CricketCSVClass.getName().equals("CrickeAnalyzer.BowlerAnalyzer")) {
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
        return listValue;
    }


    public abstract <E> List<CricketAnalyzerDAO> loadIPLData(String... csvFilePath) throws CricketAnalyserException;


}

