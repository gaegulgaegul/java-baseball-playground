package baseball;

public class ResultView {

    public static void score(PlayResult playResult) {
        if (playResult.isNothing()) {
            System.out.println("nothing");
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (playResult.getBall() > 0) {
            stringBuilder.append(playResult.getBall() + "ball ");
        }
        if (playResult.getStrike() > 0) {
            stringBuilder.append(playResult.getStrike() + "strike");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    public static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
