package stringcalculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("계산식을 입력하세요. ");
        String inputValue = scanner.nextLine();

        StringCalculator stringCalculator = new StringCalculator(inputValue);
        int result = stringCalculator.calculation();
        System.out.println("> " + result);
    }
}
