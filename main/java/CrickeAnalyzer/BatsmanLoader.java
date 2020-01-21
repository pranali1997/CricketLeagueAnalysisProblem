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
import java.util.stream.Collectors;

public class BatsmanAdapter {

    List<BatsmenAnalyzer> listValue=new ArrayList<>();

    public List<BatsmenAnalyzer> loadIPLData(String csvFilePath) throws CricketAnalyserException {

     try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
        ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
        List playerList= icsvBuilder.getCSVList(reader, BatsmenAnalyzer.class);

        playerList.stream().filter(CensusData -> listValue.add((BatsmenAnalyzer) CensusData)).collect(Collectors.toList());

         return playerList;
    } catch (IOException e) {
        throw new CricketAnalyserException(e.getMessage(),
                CricketAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
    } catch (CSVBuilderException e) {
        e.printStackTrace();
    }
        return null;
    }

}
