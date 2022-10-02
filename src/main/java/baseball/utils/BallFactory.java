package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.constants.BaseballConstant.*;

/**
 * 공 생성 팩토리
 * - MAX_SIZE는 3으로, 공의 숫자는 1~9의 한자리 자연수로 제한한다.
 * - 파라미터값이 없을 경우 임의의 중복되지 않는 수로 생성한다.
 * - 파라미터값이 있을 경우 0값을 제외한 중복되지 않는 수로 이루어진 문자열 입력값으로 생성한다.
 */
public final class BallFactory {

    private BallFactory() {}

    public static List<Integer> createBalls() {
        Set<Integer> ballSet = new HashSet<>();
        while (ballSet.size() < MAX_SIZE) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            ballSet.add(pickedNumber);
        }

        return Collections.unmodifiableList(new ArrayList<>(ballSet));
    }

    public static List<Integer> createBalls(String input) {
        validate(input);

        List<Integer> balls = new ArrayList<>();
        for (char charNumber : input.toCharArray()) {
            balls.add(Integer.parseInt(String.valueOf(charNumber)));
        }
        return Collections.unmodifiableList(balls);
    }

    private static void validate(String input) {
        requireNonNull(input);
        validateDuplicate(input);
        validateMaxSize(input);
        validateElements(input);
    }

    private static void requireNonNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
    }

    private static void validateDuplicate(String input) {
        Set<Character> charSet = new HashSet<>();
        for (char charInput : input.toCharArray()) {
            isDuplicated(charSet, charInput);
            charSet.add(charInput);
        }
    }

    private static void isDuplicated(Set<Character> charSet, char number) {
        if (charSet.contains(number)) {
            throw new IllegalArgumentException("each input value cannot be duplicated.");
        }
    }

    private static void validateMaxSize(String input) {
        if (input.length() != MAX_SIZE) {
            throw new IllegalArgumentException("input size should be same with max size.");
        }
    }

    private static void validateElements(String input) {
        for (char number : input.toCharArray()) {
            validateIntegerInBound(number);
        }
    }

    private static void validateIntegerInBound(char number) {
        if (number < '1' || number > '9') {
            throw new IllegalArgumentException("each input value cannot exceed one natural number.");
        }
    }

}
