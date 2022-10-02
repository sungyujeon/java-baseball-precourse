package baseball.game;

import baseball.entity.Score;

import java.util.List;

import static baseball.constants.BaseballConstant.*;

public final class BaseballComparator {

    public static Score calculateScore(List<Integer> numbers, List<Integer> targetNumbers) {
        int strike = 0;
        int ball = 0;

        for (int idx = 0; idx < MAX_SIZE; idx++) {
            int number = numbers.get(idx);
            int targetNumber = targetNumbers.get(idx);
            strike += addStrike(number, targetNumber);
            ball += addBall(numbers, targetNumbers, idx);
        }

        return new Score(strike, ball);
    }

    private static int addStrike(int number, int targetNumber) {
        if (isStrike(number, targetNumber)) {
            return 1;
        }
        return 0;
    }

    private static int addBall(List<Integer> numbers, List<Integer> targetNumbers, int idx) {
        int number = numbers.get(idx);
        int targetNumber = targetNumbers.get(idx);

        if (!isStrike(number, targetNumber) && targetNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private static boolean isStrike(int number, int targetNumber) {
        if (number == targetNumber) {
            return true;
        }
        return false;
    }
}
