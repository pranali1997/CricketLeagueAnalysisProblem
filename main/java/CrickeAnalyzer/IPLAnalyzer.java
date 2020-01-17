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

public class IPLAnalyzer {

    List<IPLAnalyzerCSV> listValue=new ArrayList<>();

    public int loadIPLData(String csvFilePath) throws IPLAnalyserException {
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
                ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
                List playerList= icsvBuilder.getCSVList(reader, IPLAnalyzerCSV.class);

                playerList.stream().filter(CensusData -> listValue.add((IPLAnalyzerCSV) CensusData)).collect(Collectors.toList());                //Iterator<IPLAnalyzerCSV> IPLCSVIterator = new OpenCSVBuilder().getCsvFileIterable(reader,IPLAnalyzerCSV.class);
                return playerList.size();
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
                e.printStackTrace();
            }
        return 0;
    }


    public List sortingIPLDataAverageRuns() throws  IPLAnalyserException {

        if(listValue == null || listValue.size() == 0) {
            throw new IPLAnalyserException("NO_CENSUS_DATA", IPLAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }
        List sortedList = listValue.stream().sorted(Comparator.comparing(IPLAnalyzerCSV::getAverage).reversed()).collect(Collectors.toList());
        return sortedList;
    }
}
