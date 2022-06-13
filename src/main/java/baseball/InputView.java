package baseball;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.print("숫자를 입력해주세요. : ");
        return scanner.next();
    }

    public static int replay() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }
}
