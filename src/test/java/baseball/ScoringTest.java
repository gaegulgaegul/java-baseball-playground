package baseball;

import baseball.domain.Scoring;
import baseball.domain.Score;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ScoringTest {

    @ParameterizedTest
    @CsvSource(value = {"713:123:1볼:1스트라이크", "467:469:'':2스트라이크", "469:469:'':3스트라이크"}, delimiter = ':')
    void 숫자_야구_게임_실행(String answer, String input, String ball, String strike) {
        Scoring scoring = new Scoring(answer);
        Score score = scoring.execute(input);
        String expected = ball + " " + strike;
        assertThat(score.toString()).isEqualTo(expected.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"21","223"})
    void 숫자_야구_게임_입력값_유효성_검사(String input) {
        Scoring scoring = new Scoring("123");
        assertThatThrownBy(() -> scoring.execute(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
