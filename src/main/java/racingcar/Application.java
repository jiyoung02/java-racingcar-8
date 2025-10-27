package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        var carNames = InputView.readCarNames();
        var tryCount = InputView.readTryCount();

        var game = new RacingGame(carNames);

        OutputView.printResultHeader();
        repeatRace(game, tryCount);
        OutputView.printWinners(game.winners());
    }

    private static void repeatRace(RacingGame game, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            game.playRound();
            OutputView.printRoundResult(game.status());
        }
    }
}
