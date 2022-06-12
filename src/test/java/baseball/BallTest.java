package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball ball = new Ball(1, 2);;

    @Test
    void strike() {
        PlayStatus status = ball.play(new Ball(1, 2));
        assertThat(status).isEqualTo(PlayStatus.STRIKE);
    }

    @Test
    void ball() {
        PlayStatus status = ball.play(new Ball(2, 2));
        assertThat(status).isEqualTo(PlayStatus.BALL);
    }

    @Test
    void nothing() {
        PlayStatus status = ball.play(new Ball(3, 3));
        assertThat(status).isEqualTo(PlayStatus.NOTHING);
    }
}
