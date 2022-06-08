package baseball.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGame {
    private String answer;

    private int ballScore;
    private int strikeScore;

    public BaseballGame(String answer) {
        this.answer = answer;
    }

    public Score execute(String input) {
        validate(input);
        clear();
        String remainInput = checkStrikeCount(input);
        checkBallCount(remainInput);
        return new Score(this.ballScore, this.strikeScore);
    }

    private void validate(String input) {
        Set<String> distinctNumbers = Arrays.stream(input.split(""))
                .collect(Collectors.toSet());
        if (input.length() != 3 || distinctNumbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 서로 다른 3자리를 입력해주세요.");
        }
    }

    private void clear() {
        this.ballScore = 0;
        this.strikeScore = 0;
    }

    private String checkStrikeCount(String input) {
        char[] answerNumbers = this.answer.toCharArray();
        char[] inputNumbers = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < answerNumbers.length; i++) {
            char strike = strike(answerNumbers[i], inputNumbers[i]);
            appendRemainNumber(strike, stringBuilder);
        }

        return stringBuilder.toString();
    }

    private char strike(char answerNumber, char inputNumber) {
        if (answerNumber == inputNumber) {
            this.strikeScore++;
            return 0;
        }
        return inputNumber;
    }

    private void appendRemainNumber(char number, StringBuilder stringBuilder) {
        if (number != 0) {
            stringBuilder.append(number);
        }
    }

    private void checkBallCount(String input) {
        for (String inputNumber : input.split("")) {
            ball(inputNumber);
        }
    }

    private void ball(String inputNumber) {
        if (!inputNumber.isEmpty() && this.answer.contains(inputNumber)) {
            this.ballScore++;
        }
    }
}
