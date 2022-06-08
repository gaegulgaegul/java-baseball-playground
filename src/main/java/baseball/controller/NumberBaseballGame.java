package baseball.controller;

import baseball.domain.Answer;
import baseball.domain.BaseballGame;
import baseball.domain.Confirm;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.ResultView;

public class NumberBaseballGame {

    public void execute() {
        do {
            start();
        } while (Confirm.isRunning());
    }

    private void start() {
        String answer = Answer.get();
        System.out.println(answer);
        BaseballGame baseballGame = new BaseballGame(answer);
        boolean gaming = true;
        while (gaming) {
            gaming = isGaming(baseballGame);
        }
        ResultView.endGame();
    }

    private boolean isGaming(BaseballGame baseballGame) {
        String numbers = InputView.numbers();
        try {
            Score score = baseballGame.execute(numbers);
            ResultView.print(score);
            return !score.isEndGame();
        } catch (IllegalArgumentException e) {
            ResultView.print(e.getMessage());
            return true;
        }
    }
}
