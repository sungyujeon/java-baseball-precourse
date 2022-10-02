package baseball.game;

import baseball.entity.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

class BaseballComparatorTest {

    List<Integer> targetBalls;

    @BeforeEach
    public void 리스트_초기화() {
        List<Integer> initBalls = new ArrayList<>();
        initBalls.add(1);
        initBalls.add(2);
        initBalls.add(3);
        targetBalls = unmodifiableList(initBalls);
    }

    @ParameterizedTest
    @ValueSource(strings = {"456", "789"})
    void 낫싱(String input) {
        Score expected = new Score(0, 0);

        List<Integer> balls = createBalls(input);
        Score actual = BaseballComparator.calculateScore(targetBalls, balls);

        assertThat(actual.getStrike()).isEqualTo(expected.getStrike());
        assertThat(actual.getBall()).isEqualTo(expected.getBall());
    }

    @ParameterizedTest
    @ValueSource(strings = {"124", "423"})
    void 스트라이크(String input) {
        Score expected = new Score(2, 0);

        List<Integer> balls = createBalls(input);
        Score actual = BaseballComparator.calculateScore(targetBalls, balls);

        assertThat(actual.getStrike()).isEqualTo(expected.getStrike());
    }

    @ParameterizedTest
    @ValueSource(strings = {"415", "245", "435"})
    void 볼(String input) {
        Score expected = new Score(0, 1);

        List<Integer> balls = createBalls(input);
        Score actual = BaseballComparator.calculateScore(targetBalls, balls);

        assertThat(actual.getBall()).isEqualTo(expected.getBall());
    }

    @ParameterizedTest
    @ValueSource(strings = {"142", "324", "413"})
    void 스트라이크_볼(String input) {
        Score expected = new Score(1, 1);

        List<Integer> balls = createBalls(input);
        Score actual = BaseballComparator.calculateScore(targetBalls, balls);

        assertThat(actual.getStrike()).isEqualTo(expected.getStrike());
        assertThat(actual.getBall()).isEqualTo(expected.getBall());
    }


    private List<Integer> createBalls(String input) {
        List<Integer> balls = new ArrayList<>();

        for (char c : input.toCharArray()) {
            int ball = Integer.parseInt(String.valueOf(c));
            balls.add(ball);
        }

        return unmodifiableList(balls);
    }
}