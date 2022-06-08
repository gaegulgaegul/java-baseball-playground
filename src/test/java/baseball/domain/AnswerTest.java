package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    void 랜덤_3자리_정답_생성() {
        String answer = Answer.get();
        String[] answerNumbers = answer.split("");
        for (int i = 0; i < answerNumbers.length; i++) {
            assertThat(answer.replace(answerNumbers[i], "").contains(answerNumbers[i])).isFalse();
        }
        assertThat(answer.length()).isEqualTo(3);
    }
}