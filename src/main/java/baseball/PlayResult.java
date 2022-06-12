package baseball;

public class PlayResult {
    private int ball;
    private int strike;

    public PlayResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public void report(PlayStatus status) {
        if (status.isBall()) {
            this.ball++;
        }
        if (status.isStrike()) {
            this.strike++;
        }
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public boolean isEndGame() {
        return this.strike == 3;
    }
}
