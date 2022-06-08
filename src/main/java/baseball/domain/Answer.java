package baseball.domain;

import java.util.*;

public class Answer {

    public static String get() {
        Set<Integer> numberSet = new HashSet<>();
        do {
            int random = (int) (Math.random() * 9) + 1;
            numberSet.add(random);
        } while (numberSet.size() < 3);

        return numberSet.stream()
                .map(String::valueOf)
                .reduce("", (acc, next) -> acc += next);
    }
}
