package CrickeAnalyzer;

public class BatsmenAnalyzerDAO {

    int pos;
    String player;
    int matches;
    int innings;
    int notOut;
    int runs;
    int highScore;
    double average;
    int ballFest;
    double strikeRate;
    int century;
    int halfCentury;
    int fours;
    int sixes;

    public BatsmenAnalyzerDAO(int pos, String player, int matches, int innings, int notOut, int runs, int highScore, double average, int ballFest, double strikeRate, int century, int halfCentury, int fours, int sixes) {
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

    public double getAverage() {
        return average;
    }

    public double getStrikeRate() {
        return strikeRate;
    }
}
