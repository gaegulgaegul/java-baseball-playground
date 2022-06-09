package baseball.domain;

import baseball.view.ResultView;

public class ConfirmScore {

    private Scoring scoring;
    private Score score;

    public ConfirmScore(Scoring scoring) {
        this.scoring = scoring;
    }

    public void computeScore(String numbers) {
        try {
            this.score = scoring.execute(numbers);
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
