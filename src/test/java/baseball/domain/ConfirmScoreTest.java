package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConfirmScoreTest {

    @Test
    void 스코어_검증_3스트라이크() {
        BaseballGame baseballGame = new BaseballGame("123");
        ConfirmScore confirmScore = new ConfirmScore(baseballGame);
        confirmScore.computeScore("123");
        assertThat(confirmScore.onGoing()).isFalse();
    }

    @Test
    void 스코어_검증_1볼() {
        BaseballGame baseballGame = new BaseballGame("356");
        ConfirmScore confirmScore = new ConfirmScore(baseballGame);
        confirmScore.computeScore("123");
        assertThat(confirmScore.onGoing()).isTrue();
    }
}