package baseball.controller;

import baseball.domain.Answer;
import baseball.domain.BaseballGame;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.ResultView;

public class NumberBaseballGame {

    public void execute() {
        boolean running = true;
        while (running) {
            start();
            running = isRunning();
        }
    }

    private void start() {
        String answer = Answer.get();
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

    private boolean isRunning() {
        if (confirm() == 1) {
            return true;
        }
        return false;
    }

    private int confirm() {
        boolean isWrongCode = true;
        int confirm = 0;
        while (isWrongCode) {
            confirm = InputView.confirm();
            isWrongCode = confirm > 2;
        }
        return confirm;
    }
}
