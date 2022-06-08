package baseball.controller;

import baseball.domain.Answer;
import baseball.domain.BaseballGame;
import baseball.domain.ConfirmScore;
import baseball.domain.Rerun;
import baseball.view.InputView;
import baseball.view.ResultView;

public class NumberBaseballGame {

    public void execute() {
        do {
            start();
        } while (Rerun.isRunning());
    }

    private void start() {
        BaseballGame baseballGame = new BaseballGame(Answer.get());
        ConfirmScore confirmScore = new ConfirmScore(baseballGame);
        do {
            confirmScore.computeScore(InputView.numbers());
        } while (confirmScore.onGoing());
        ResultView.endGame();
    }

}
