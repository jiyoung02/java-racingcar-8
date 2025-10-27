package racingcar.exception;

public class InvalidTryCountException extends IllegalArgumentException {
    public InvalidTryCountException() {
        super("시도 횟수는 1 이상의 정수여야 합니다.");
    }
}