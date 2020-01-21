package CrickeAnalyzer;

public class BatsmenAnalyzerDAO {

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

    public BatsmenAnalyzerDAO(BatsmenAnalyzer batsmenAnalyzer) {
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

    @Override
    public String toString() {
        return "BatsmenAnalyzerDAO{" +
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
}
