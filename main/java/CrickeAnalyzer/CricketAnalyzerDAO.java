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
    public double bowlStrikeRate;
    public double bowlAverage;


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
        this.bowlAverage = bowlerAnalyzer.bowlAverage;
        this.bowlStrikeRate = bowlerAnalyzer.bowlStrikeRate;
        this.overs = bowlerAnalyzer.overs;
        this.wickets = bowlerAnalyzer.wickets;
        this.bestBowlingInn = bowlerAnalyzer.bestBowlingInn;
        this.economicRate = bowlerAnalyzer.economicRate;
        this.fourWickets = bowlerAnalyzer.fourWickets;
        this.fiveWickets = bowlerAnalyzer.fiveWickets;
    }

    public CricketAnalyzerDAO() {

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
                ", bowlStrikeRate=" + bowlStrikeRate +
                '}';
    }

    public Object getCricketDTO(CricketAnalyzer.Cricket cricket){

        if(cricket.equals(CricketAnalyzer.Cricket.BATSMANS)){
            return new BatsmenAnalyzer( pos,  player, matches, innings, notOut, runs,  highScore,  average,  ballFest,  strikeRate, century, halfCentury, fours, sixes);
        }
        return new BowlerAnalyzer(pos, player, matches, innings,  overs,  runs,  wickets, bestBowlingInn,  bowlAverage,  economicRate,  bowlStrikeRate, fourWickets, fiveWickets);

    }



}

