package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 사이즈를 구한다.")
    @Test
    void getSizeOfSet() {
        int actual = numbers.size();

        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("Set에 주어진 수가 있는지 확인한다.(오직 값이 있는 경우만 검증한다)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContainedGivenNumber(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set에 주어진 수가 있는지 확인한다.(값이 없는 경우도 검증한다)")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false"})
    void isContainedGivenNumber(String input, String expected) {
        int inputValue = Integer.parseInt(input);
        boolean expectedValue = Boolean.valueOf(expected);
        boolean actualValue = numbers.contains(inputValue);

        assertEquals(expectedValue, actualValue);
    }
}
