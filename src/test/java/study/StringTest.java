package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] strings = "1,2".split(",");
        assertThat(strings).containsExactly("1", "2");
        String[] split = "1".split(",");
        assertThat(split.getClass()).isEqualTo(String[].class);
        assertThat(split).contains("1");
    }

    @Test
    void substring() {
        String text = "(1,2)";
        String substring = text.substring(text.indexOf("(") + 1, text.indexOf(")"));
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 위치 값이 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
