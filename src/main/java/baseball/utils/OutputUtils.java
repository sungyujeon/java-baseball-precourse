package baseball.utils;

import baseball.entity.Score;

import java.util.ArrayList;
import java.util.List;

public final class OutputUtils {

    public static void printRequestInputNumber() {
        print("숫자를 입력해주세요 : ");
    }

    public static void printResult(Score score) {
        List<String> results = makeResults(score);
        String result = "낫싱";

        if (!results.isEmpty()) {
            result = String.join(" ", results);
        }

        println(result);
    }

    public static void printEndGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static List<String> makeResults(Score score) {
        List<String> results = new ArrayList<>();
        int ball = score.getBall();
        int strike = score.getStrike();

        if (ball > 0) {
            results.add(ball + "볼");
        }

        if (strike > 0) {
            results.add(strike + "스트라이크");
        }

        return results;
    }
}
