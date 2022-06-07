package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 계산기 수행")
    void execute_calculator() {
        String expression = "2 + 3 * 4 / 2";
        StringCalculator stringCalculator = new StringCalculator(expression);
        assertThat(stringCalculator.calculation()).isEqualTo(10);
    }
}
