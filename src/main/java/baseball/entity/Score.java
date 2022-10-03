package baseball.entity;

import java.util.List;

import static baseball.constants.BaseballConstant.MAX_SIZE;

public final class Score {

    private int strike;
    private int ball;

    private Score() {}

    protected Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Score createScore(Balls player, Balls computer) {
        return calculate(player.getContainer(), computer.getContainer());
    }

    private static Score calculate(List<Integer> numbers, List<Integer> targetNumbers) {
        Score score = new Score();

        for (int i = 0; i < MAX_SIZE; i++) {
            int number = numbers.get(i);
            int targetNumber = targetNumbers.get(i);

            score.strike += addStrike(number, targetNumber);;
            score.ball += addBall(numbers, targetNumbers, i);
        }

        return score;
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

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
