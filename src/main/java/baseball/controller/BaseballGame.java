package baseball.controller;

import baseball.domain.Answer;
import baseball.domain.Scoring;
import baseball.domain.ConfirmScore;
import baseball.domain.Rerun;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {

    public void play() {
        do {
            start();
        } while (Rerun.isRunning());
    }

    private void start() {
        Scoring scoring = new Scoring(Answer.get());
        ConfirmScore confirmScore = new ConfirmScore(scoring);
        do {
            confirmScore.computeScore(InputView.numbers());
        } while (confirmScore.onGoing());
        ResultView.endGame();
    }

}
