package CrickeAnalyzer;

public class IPLAnalyserException extends Throwable {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM
    }

    ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
