package baseball.entity;

import java.util.List;

import static baseball.utils.BallFactory.*;

public final class Computer {

    private List<Integer> balls = createBalls();

    public List<Integer> getBalls() {
        return balls;
    }

    public void changeBalls() {
        this.balls = createBalls();
    }
}
