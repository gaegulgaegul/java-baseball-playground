package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> answers;

    public Balls(List<Integer> numbers) {
        this.answers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answers.add(new Ball((i+1), numbers.get(i)));
        }
    }

    public PlayStatus play(Ball answer) {
        return this.answers.stream()
                .map(answer::play)
                .filter(PlayStatus::isNotNothing)
                .findFirst()
                .orElse(PlayStatus.NOTHING);
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();

        for (Ball answer : this.answers) {
            PlayStatus status = userBalls.play(answer);
            result.report(status);
        }

        return result;
    }
}
