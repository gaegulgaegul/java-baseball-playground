package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    public static String get() {
        List<Integer> numberList = new ArrayList<>();
        do {
            addRandomNumber(numberList);
        } while (numberList.size() < 3);

        return numberList.stream()
                .map(String::valueOf)
                .reduce("", (acc, next) -> acc += next);
    }

    private static void addRandomNumber(List<Integer> numberList) {
        int random = (int) (Math.random() * 9) + 1;
        if (!numberList.contains(random)) {
            numberList.add(random);
        }
    }

}
