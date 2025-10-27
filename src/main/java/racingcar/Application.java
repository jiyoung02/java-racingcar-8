package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        var carNames = InputView.readCarNames();
        var tryCount = InputView.readTryCount();


        OutputView.printResultHeader();
        OutputView.printWinners(carNames);
    }
}
