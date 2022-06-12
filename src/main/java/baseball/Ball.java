package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball answer) {
        if (answer.equals(this)) {
            return BallStatus.STRIKE;
        }

        if (answer.matchBallNumber(this.ballNumber)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
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
