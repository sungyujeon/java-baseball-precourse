package baseball.game;

import baseball.entity.Computer;
import baseball.entity.Player;
import baseball.entity.Score;
import baseball.game.enums.GameStatus;

import static baseball.constants.BaseballConstant.MAX_SIZE;
import static baseball.game.enums.GameStatus.*;
import static baseball.utils.InputUtils.*;
import static baseball.utils.OutputUtils.*;

public final class BaseballGame {

    private GameStatus gameStatus;
    private final Computer computer;
    private final Player player;

    public BaseballGame(Computer computer, Player player) {
        gameStatus = START;
        this.computer = computer;
        this.player = player;
    }

    public void start() {
        while (gameStatus == START) {
            startTurn();
            reStart();
        }
    }

    private void startTurn() {
        String input = userInputWithMessage();
        player.changeBalls(input);

        Score score = Score.createScore(player.getBalls(), computer.getBalls());
        printResult(score);

        if (isAnswer(score)) {
            String endInput = userInputWithEndMessage();
            gameStatus = setGameStatusWithUserInput(endInput);
        }
    }

    private void reStart() {
        if (gameStatus == RESTART) {
            computer.changeBalls();
            gameStatus = START;
        }
    }

    public boolean isAnswer(Score score) {
        if (score.getStrike() == MAX_SIZE) {
            return true;
        }
        return false;
    }

    private GameStatus setGameStatusWithUserInput(String input) {
        if (!("1".equals(input) || "2".equals(input))){
            throw new IllegalArgumentException("user input to end game should be '1' or '2'.");
        }

        if ("1".equals(input)) {
            return RESTART;
        }

        return END;
    }
}
