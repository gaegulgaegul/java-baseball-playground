package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int ballNumber;

    public Ball(int position, int ballNumber) {
        if (isNotRangeBallNumber(ballNumber)) {
            throw new IllegalArgumentException("숫자는 1~9 사이를 입력해주세요.");
        }
        this.position = position;
        this.ballNumber = ballNumber;
    }

    private boolean isNotRangeBallNumber(int ballNumber) {
        return ballNumber < 1 && ballNumber > 9;
    }

    public PlayStatus play(Ball answer) {
        if (answer.equals(this)) {
            return PlayStatus.STRIKE;
        }

        if (answer.matchBallNumber(this.ballNumber)) {
            return PlayStatus.BALL;
        }

        return PlayStatus.NOTHING;
    }

    private boolean matchBallNumber(int ballNumber) {
        return this.ballNumber == ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
