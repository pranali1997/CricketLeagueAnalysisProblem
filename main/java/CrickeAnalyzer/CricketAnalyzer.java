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

        listValue =new CricketAnalyzerLoader().loadIPLData(csvFilePath);
        return listValue;
    }

    public List<BatsmenAnalyzer> getTopRecords(SortFields.sortingFields sortFields) {
        Comparator<BatsmenAnalyzer> comparator=new SortFields().getField(sortFields);
        ArrayList arrayListValue= (ArrayList) listValue.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(arrayListValue);
        return arrayListValue;
    }

}