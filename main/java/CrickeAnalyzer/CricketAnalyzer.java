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

    List<BatsmenAnalyzer> listValue=new ArrayList<>();

    public List loadIPLData(String csvFilePath) throws CricketAnalyserException {
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
                ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
                List playerList= icsvBuilder.getCSVList(reader, BatsmenAnalyzer.class);

                playerList.stream().filter(CensusData -> listValue.add((BatsmenAnalyzer) CensusData)).collect(Collectors.toList());                //Iterator<BatsmenAnalyzer> IPLCSVIterator = new OpenCSVBuilder().getCsvFileIterable(reader,BatsmenAnalyzer.class);
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
        ArrayList c= (ArrayList) listValue.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(c);
        System.out.println(c);
        return c;
    }

}