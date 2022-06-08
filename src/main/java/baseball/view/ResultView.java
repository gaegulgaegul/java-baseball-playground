package baseball.view;

import baseball.domain.Score;

public class ResultView {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Score score) {
        System.out.println(score);
    }

    public static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
