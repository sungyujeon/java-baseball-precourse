package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.constants.BaseballConstant.*;

public final class Balls {

    private List<Integer> container = new ArrayList<>();

    private Balls() {}

    public static Balls createBalls() {
        Set<Integer> ballSet = new HashSet<>();
        while (ballSet.size() < MAX_SIZE) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            ballSet.add(pickedNumber);
        }

        Balls balls = new Balls();
        balls.container = new ArrayList<>(ballSet);

        return balls;
    }

    public static Balls createBalls(String input) {
        validate(input);

        Balls balls = new Balls();
        for (char charNumber : input.toCharArray()) {
            balls.container.add(Integer.parseInt(String.valueOf(charNumber)));
        }

        return balls;
    }

    public Score checkScore(String input) {
        Balls balls = createBalls(input);
        return Score.createScore(this, balls);
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

    public List<Integer> getContainer() {
        return container;
    }

}
