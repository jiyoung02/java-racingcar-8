package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.InvalidCarNameException;
import racingcar.exception.InvalidTryCountException;

public class InputView {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> readCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        return parseCarNames(input);
    }

    public static int readTryCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        String input = Console.readLine();

        int count = validateTryCount(input);
        return count;
    }

    private static List<String> parseCarNames(String input) {
        List<String> names =  Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
        validateCarNames(names);
        return names;
    }


    private static int validateTryCount(String input) {
        if (input == null || input.isBlank()) {
            throw new InvalidTryCountException("값을 입력해주세요/");
        }
        if (!isNumeric(input)) {
            throw new InvalidTryCountException("시도 횟수는 숫자여야 합니다.");
        }
        int tryCount = Integer.parseInt(input);
        if (tryCount <= 0) {
            throw new InvalidTryCountException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
        return tryCount;
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    private static void validateCarNames(List<String> names) {
        for (String name : names) {
            if (name.isBlank() || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new InvalidCarNameException();
            }
        }
    }
}
