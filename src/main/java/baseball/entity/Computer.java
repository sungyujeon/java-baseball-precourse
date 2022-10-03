package baseball.entity;

public final class Computer {

    private Balls balls = Balls.createBalls();

    public Balls getBalls() {
        return balls;
    }

    public void changeBalls() {
        this.balls = Balls.createBalls();
    }
}
