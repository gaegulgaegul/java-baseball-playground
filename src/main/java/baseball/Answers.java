package baseball;

import java.util.ArrayList;
import java.util.List;

public class Answers {

    private List<Integer> numbers;

    private void settings() {
        this.numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            setAnswerNumber();
        }
    }

    private void setAnswerNumber() {
        int random = getRandom();
        if (numbers.contains(random)) {
            return;
        }
        numbers.add(random);
    }

    private int getRandom() {
        return (int) (Math.random() * 9) + 1;
    }

    public Balls getBalls() {
        settings();
        return new Balls(numbers);
    }
}
