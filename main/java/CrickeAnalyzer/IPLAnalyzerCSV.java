package CrickeAnalyzer;

import com.opencsv.bean.CsvBindByName;


public class IPLAnalyzerCSV {
    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public int highScore;

    @CsvBindByName(column = "Avg", required = true)
    public double  average;

    @CsvBindByName(column = "BF", required = true)
    public int ballFest;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;


    public IPLAnalyzerCSV(int pos, String player, int matches, int innings, int notOut, int runs, int highScore, double average, int ballFest, double strikeRate, int century, int halfCentury, int fours, int sixes) {
        this.pos = pos;
        this.player = player;
        this.matches = matches;
        this.innings = innings;
        this.notOut = notOut;
        this.runs = runs;
        this.highScore = highScore;
        this.average = average;
        this.ballFest = ballFest;
        this.strikeRate = strikeRate;
        this.century = century;
        this.halfCentury = halfCentury;
        this.fours = fours;
        this.sixes = sixes;
    }

    public IPLAnalyzerCSV() {
    }

    @Override
    public String toString() {
        return "IPLAnalyzerCSV{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore=" + highScore +
                ", average=" + average +
                ", ballFest=" + ballFest +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }

    public double getAverage() {
        return average;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {

        return sixes;
    }



}
