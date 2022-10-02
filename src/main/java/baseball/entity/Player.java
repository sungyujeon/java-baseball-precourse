package baseball.entity;

import baseball.utils.BallFactory;

import java.util.ArrayList;
import java.util.List;

public final class Player {

    private List<Integer> balls = new ArrayList<>();

    public List<Integer> getBalls() {
        return balls;
    }

    public void changeBalls(String input) {
        this.balls = BallFactory.createBalls(input);
    }
}
