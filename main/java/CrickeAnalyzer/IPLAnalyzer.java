package CrickeAnalyzer;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.OpenCSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class IPLAnalyzer {

    public int loadIPLData(String csvFilePath) throws IPLAnalyserException {
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
                Iterator<IPLAnalyzerCSV> IPLCSVIterator = new OpenCSVBuilder().getCsvFileIterable(reader,IPLAnalyzerCSV.class);
                return getCount(IPLCSVIterator);
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
                e.printStackTrace();
            }
        return 0;
    }

    private <E> int getCount(Iterator<E> iterator){
        Iterable<E> csvIterable=() -> iterator;
        int namOfEateries= (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
        return namOfEateries;
    }



}
