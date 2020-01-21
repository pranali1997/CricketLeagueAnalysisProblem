package CrickeAnalyzer;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyzer {

    List<BatsmenAnalyzer> batsmanListValue =new ArrayList<>();
    List<BowlerAnalyzer> bowlerListValue=new ArrayList<>();

    public List loadIPLBatsmanData(String csvFilePath) throws CricketAnalyserException {

        batsmanListValue =new BatsmanAdapter().loadIPLData(csvFilePath);
        return batsmanListValue;
    }

    public List<BowlerAnalyzer> loadIPLBowlerData(String csvFilePath) throws CricketAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List playerList= icsvBuilder.getCSVList(reader, BowlerAnalyzer.class);

            playerList.stream().filter(CensusData -> bowlerListValue.add((BowlerAnalyzer)CensusData)).collect(Collectors.toList());

            return playerList;
        } catch (IOException e) {
            throw new CricketAnalyserException(e.getMessage(),
                    CricketAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BatsmenAnalyzer> getTopRecords(SortFields.sortingFields sortFields) {
        Comparator<BatsmenAnalyzer> comparator=new SortFields().getField(sortFields);
        ArrayList arrayListValue= (ArrayList) batsmanListValue.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(arrayListValue);
        return arrayListValue;
    }


}