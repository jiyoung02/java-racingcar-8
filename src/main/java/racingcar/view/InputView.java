package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

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
        return parseTryCount(input);
    }

    private static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    private static int parseTryCount(String input) {
        int count = Integer.parseInt(input);
        return count;
    }
}
