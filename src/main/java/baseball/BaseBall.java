package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBall {

    private Answers answers;

    public BaseBall() {
        this.answers = new Answers();
    }

    public void play() {
        inning(answers.getBalls());
        int code = InputView.replay();
        if (isReplay(code)) {
            play();
        }
    }

    private void inning(Balls answers) {
        PlayResult playResult = answers.play(getUserNumbers());
        ResultView.score(playResult);
        if (playResult.isEndGame()) {
            ResultView.endGame();
            return;
        }
        inning(answers);
    }

    private List<Integer> getUserNumbers() {
        String input = InputView.input();
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isReplay(int code) {
        return code == 1;
    }

}
