package baseball.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    Balls targetBalls;

    @BeforeEach
    public void 리스트_초기화() {
        targetBalls = Balls.createBalls("123");
    }

    @ParameterizedTest
    @ValueSource(strings = {"456", "789"})
    void 낫싱(String input) {
        Score expected = new Score(0, 0);

        Balls balls = Balls.createBalls(input);
        Score actual = Score.createScore(balls, targetBalls);

        assertThat(actual.getStrike()).isEqualTo(expected.getStrike());
        assertThat(actual.getBall()).isEqualTo(expected.getBall());
    }

    @ParameterizedTest
    @ValueSource(strings = {"124", "423"})
    void 스트라이크(String input) {
        Score expected = new Score(2, 0);

        Balls balls = Balls.createBalls(input);
        Score actual = Score.createScore(balls, targetBalls);

        assertThat(actual.getStrike()).isEqualTo(expected.getStrike());
    }

    @ParameterizedTest
    @ValueSource(strings = {"415", "245", "435"})
    void 볼(String input) {
        Score expected = new Score(0, 1);

        Balls balls = Balls.createBalls(input);
        Score actual = Score.createScore(balls, targetBalls);
        System.out.println(actual.getBall() + " " + actual.getStrike());

        assertThat(actual.getBall()).isEqualTo(expected.getBall());
    }

    @ParameterizedTest
    @ValueSource(strings = {"142", "324", "413"})
    void 스트라이크_볼(String input) {
        Score expected = new Score(1, 1);

        Balls balls = Balls.createBalls(input);
        Score actual = Score.createScore(balls, targetBalls);

        assertThat(actual.getStrike()).isEqualTo(expected.getStrike());
        assertThat(actual.getBall()).isEqualTo(expected.getBall());
    }

}