package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls answers = new Balls(Arrays.asList(1, 2, 3));

    @Test
    void play_3strike() {
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isEndGame()).isTrue();
    }

    @Test
    void play_1ball_1strike() {
        PlayResult result = answers.play(Arrays.asList(1, 3, 4));
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void strike() {
        PlayStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(PlayStatus.STRIKE);
    }

    @Test
    void ball() {
        PlayStatus status = answers.play(new Ball(1, 2));
        assertThat(status).isEqualTo(PlayStatus.BALL);
    }

    @Test
    void nothing() {
        PlayStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(PlayStatus.NOTHING);
    }
}
