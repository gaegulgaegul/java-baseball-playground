package baseball.domain;

public class Score {
    private final int ball;
    private final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isEndGame() {
        return this.strike == 3;
    }

    @Override
    public String toString() {
        if (this.ball == 0 && this.strike == 0) {
            return "낫싱";
        }
        return scoring();
    }

    private String scoring() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.ball > 0) {
            stringBuilder.append(this.ball + "볼 ");
        }
        if (this.strike > 0) {
            stringBuilder.append(this.strike + "스트라이크");
        }
        return stringBuilder.toString().trim();
    }
}
