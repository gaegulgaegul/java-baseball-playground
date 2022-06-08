package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.Score;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    @ParameterizedTest
    @CsvSource(value = {"713:123:1볼:1스트라이크", "467:469:'':2스트라이크", "469:469:'':3스트라이크"}, delimiter = ':')
    void 숫자_야구_게임_실행(String answer, String input, String ball, String strike) {
        BaseballGame baseballGame = new BaseballGame(answer);
        Score score = baseballGame.execute(input);
        String expected = ball + " " + strike;
        assertThat(score.toString()).isEqualTo(expected.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"21","223"})
    void 숫자_야구_게임_입력값_유효성_검사(String input) {
        BaseballGame baseballGame = new BaseballGame("123");
        assertThatThrownBy(() -> baseballGame.execute(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
