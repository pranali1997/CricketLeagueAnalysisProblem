package CrickeAnalyzer;

public class IPLAnalyserException extends Throwable {
    enum ExceptionType {
        IPL_FILE_PROBLEM, UNABLE_TO_PARSE , INVALID_DELIMITER , INCORRECT_FILE_DATA;
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
