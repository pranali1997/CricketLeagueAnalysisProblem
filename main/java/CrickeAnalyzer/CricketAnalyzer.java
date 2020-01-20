package CrickeAnalyzer;

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