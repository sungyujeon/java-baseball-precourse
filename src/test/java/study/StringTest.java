package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 문자열_콤마_분리() {
        String string = "1,2";

        String[] actual = string.split(",");

        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void 문자열_시작_끝_괄호_제거() {
        String string = "(1,2)";

        String actual = string.substring(1, string.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("문자열 특정 위치의 문자를 가져온다.")
    @Test
    void getCharByIndex() {
        String string = "abc";
        int inBoundIndex = 0;

        char actual = string.charAt(inBoundIndex);

        assertThat(actual).isEqualTo('a');
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", 3));

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching(String.format("String index out of range: %d", 3));
    }
}
