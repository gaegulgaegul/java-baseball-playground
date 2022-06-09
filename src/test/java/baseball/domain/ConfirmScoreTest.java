package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConfirmScoreTest {

    @Test
    void 스코어_검증_3스트라이크() {
        Scoring scoring = new Scoring("123");
        ConfirmScore confirmScore = new ConfirmScore(scoring);
        confirmScore.computeScore("123");
        assertThat(confirmScore.onGoing()).isFalse();
    }

    @Test
    void 스코어_검증_1볼() {
        Scoring scoring = new Scoring("356");
        ConfirmScore confirmScore = new ConfirmScore(scoring);
        confirmScore.computeScore("123");
        assertThat(confirmScore.onGoing()).isTrue();
    }
}