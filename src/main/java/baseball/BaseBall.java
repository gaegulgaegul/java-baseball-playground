package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBall {

    private Answers answers;
    private int code;

    public BaseBall() {
        this.answers = new Answers();
    }

    public void play() {
        do {
            inning(answers.getBalls());
            code = InputView.replay();
        } while(!isShutdown());
    }

    private void inning(Balls answers) {
        PlayResult playResult;
        do {
            playResult = answers.play(getUserNumbers());
            ResultView.score(playResult);
        } while (!playResult.isEndGame());
        ResultView.endGame();
    }

    private List<Integer> getUserNumbers() {
        String input = InputView.input();
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isShutdown() {
        return code == 2;
    }

}
