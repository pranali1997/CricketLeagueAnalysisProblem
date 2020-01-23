package CrickeAnalyzer;

import com.opencsv.bean.CsvBindByName;

public class BowlerAnalyzer {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public double overs;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bestBowlingInn;

    @CsvBindByName(column = "Avg", required = true)
    public double  bowlAverage;

    @CsvBindByName(column = "Econ", required = true)
    public double economicRate;

    @CsvBindByName(column = "SR", required = true)
    public double bowlStrikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWickets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWickets;

    public BowlerAnalyzer() {
    }

    public BowlerAnalyzer(int pos, String player, int matches, int innings, double overs, int runs, int wickets, int bestBowlingInn, double bowlAverage, double economicRate, double bowlStrikeRate, int fourWickets, int fiveWickets) {
        this.pos = pos;
        this.player = player;
        this.matches = matches;
        this.innings = innings;
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;
        this.bestBowlingInn = bestBowlingInn;
        this.bowlAverage = bowlAverage;
        this.economicRate = economicRate;
        this.bowlStrikeRate = bowlStrikeRate;
        this.fourWickets = fourWickets;
        this.fiveWickets = fiveWickets;
    }

    @Override
    public String toString() {
        return "BowlerAnalyzer{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bestBowlingInn=" + bestBowlingInn +
                ", average=" + bowlAverage +
                ", economicRate=" + economicRate +
                ", bowlStrikeRate=" + bowlStrikeRate +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }
}
