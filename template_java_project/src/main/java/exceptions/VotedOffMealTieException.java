package main.java.exceptions;

public class VotedOffMealTieException extends RuntimeException{
    public VotedOffMealTieException() {
    }

    public VotedOffMealTieException(String message) {
        super(message);
    }

    public VotedOffMealTieException(String message, Throwable cause) {
        super(message, cause);
    }

    public VotedOffMealTieException(Throwable cause) {
        super(cause);
    }
}
