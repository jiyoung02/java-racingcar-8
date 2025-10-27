package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printRoundResult(List<String> statusList) {
        statusList.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(WINNER_MESSAGE + result);
    }
}