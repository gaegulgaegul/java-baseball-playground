package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "1:1", "1:0", "0:1"}, delimiter = ':')
    void 볼과_스트라이크_개수_확인(int ballScore, int strikeScore) {
        Score score = new Score(ballScore, strikeScore);
        String expected = "";
        if (ballScore > 0) {
            expected += ballScore + "볼 ";
        }
        if (strikeScore > 0) {
            expected += strikeScore + "스트라이크";
        }
        assertThat(score.toString()).isEqualTo(expected.trim());
    }

    @Test
    void 게임_종료_확인() {
        Score score = new Score(0, 3);
        assertThat(score.isEndGame()).isTrue();
    }
}