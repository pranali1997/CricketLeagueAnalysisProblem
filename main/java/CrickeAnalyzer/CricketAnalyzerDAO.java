package CrickeAnalyzer;

public class CricketAnalyzerDAO {

    public int pos;
    public String player;
    public int matches;
    public int innings;
    public int notOut;
    public int runs;
    public int highScore;
    public double average;
    public int ballFest;
    public double strikeRate;
    public int century;
    public int halfCentury;
    public int fours;
    public int sixes;
    public double overs;
    public int wickets;
    public int bestBowlingInn;
    public double economicRate;
    public int fourWickets;
    public int fiveWickets;


    public CricketAnalyzerDAO(BatsmenAnalyzer batsmenAnalyzer) {
        this.pos = batsmenAnalyzer.pos;
        this.player = batsmenAnalyzer.player;
        this.matches = batsmenAnalyzer.matches;
        this.innings = batsmenAnalyzer.innings;
        this.notOut = batsmenAnalyzer.notOut;
        this.runs = batsmenAnalyzer.runs;
        this.highScore = batsmenAnalyzer.highScore;
        this.average = batsmenAnalyzer.average;
        this.ballFest = batsmenAnalyzer.ballFest;
        this.strikeRate = batsmenAnalyzer.strikeRate;
        this.century = batsmenAnalyzer.century;
        this.halfCentury = batsmenAnalyzer.halfCentury;
        this.fours = batsmenAnalyzer.fours;
        this.sixes = batsmenAnalyzer.sixes;
    }

    public CricketAnalyzerDAO(BowlerAnalyzer bowlerAnalyzer) {
        this.pos = bowlerAnalyzer.pos;
        this.player = bowlerAnalyzer.player;
        this.matches = bowlerAnalyzer.matches;
        this.innings = bowlerAnalyzer.innings;
        this.runs = bowlerAnalyzer.runs;
        this.average = bowlerAnalyzer.average;
        this.strikeRate = bowlerAnalyzer.strikeRate;
        this.overs = bowlerAnalyzer.overs;
        this.wickets = bowlerAnalyzer.wickets;
        this.bestBowlingInn = bowlerAnalyzer.bestBowlingInn;
        this.economicRate = bowlerAnalyzer.economicRate;
        this.fourWickets = bowlerAnalyzer.fourWickets;
        this.fiveWickets = bowlerAnalyzer.fiveWickets;
    }

    @Override
    public String toString() {
        return "CricketAnalyzerDAO{" +
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
                ", overs=" + overs +
                ", wickets=" + wickets +
                ", bestBowlingInn=" + bestBowlingInn +
                ", economicRate=" + economicRate +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }
}
