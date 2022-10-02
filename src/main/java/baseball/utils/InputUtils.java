package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import static baseball.utils.OutputUtils.*;

public final class InputUtils {

    private InputUtils() {}

    public static String userInput() {
        return Console.readLine();
    }

    public static String userInputWithMessage() {
        printRequestInputNumber();
        return userInput();
    }

    public static String userInputWithEndMessage() {
        printEndGame();
        return userInput();
    }
}
