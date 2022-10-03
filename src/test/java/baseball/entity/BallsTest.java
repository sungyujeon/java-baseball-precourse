package baseball.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @Test
    void set_사이즈() {
        Balls actual = Balls.createBalls("123");

        assertThat(actual.getContainer().size()).isEqualTo(3);
    }

    @Test
    void 공_생성() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);
        expected.add(6);

        Balls actual = Balls.createBalls("456");

        assertThat(actual.getContainer()).isEqualTo(expected);
    }

    @Test
    void 입력값_null() {
        assertThatThrownBy(() -> Balls.createBalls(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("input cannot be null.");
    }

    @Test
    void 입력값_중복_숫자_포함() {
        assertThatThrownBy(() -> Balls.createBalls("001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("each input value cannot be duplicated.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12", "1234"})
    void 입력값_사이즈_불일치(String input) {
        assertThatThrownBy(() -> Balls.createBalls(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("input size should be same with max size.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "a1c", ":^1"})
    void 각_입력값_한자리_자연수_미입력(String input) {
        assertThatThrownBy(() -> Balls.createBalls(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("each input value cannot exceed one natural number.");
    }

}