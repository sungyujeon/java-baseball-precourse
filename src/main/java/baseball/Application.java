package baseball;

import baseball.entity.Computer;
import baseball.entity.Player;
import baseball.game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new Computer(), new Player());
        baseballGame.start();
    }
}