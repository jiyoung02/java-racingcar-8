package racingcar.exception;

public class InvalidTryCountException extends IllegalArgumentException {
    public InvalidTryCountException(String message) {
        super(message);
    }
}