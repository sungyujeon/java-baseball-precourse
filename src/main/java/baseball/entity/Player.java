package baseball.entity;

public final class Player {

    private Balls balls;

    public Balls getBalls() {
        return balls;
    }

    public void changeBalls(String input) {
        this.balls = Balls.createBalls(input);
    }
}
