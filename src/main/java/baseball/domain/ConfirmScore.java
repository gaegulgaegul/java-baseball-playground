package baseball.domain;

import baseball.view.ResultView;

public class ConfirmScore {

    private BaseballGame baseballGame;
    private Score score;

    public ConfirmScore(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void computeScore(String numbers) {
        try {
            this.score = baseballGame.execute(numbers);
            ResultView.print(score);
        } catch (IllegalArgumentException e) {
            ResultView.print(e.getMessage());
        }
    }

    public boolean onGoing() {
        if (this.score == null) {
            return true;
        }
        return !this.score.isEndGame();
    }
}
