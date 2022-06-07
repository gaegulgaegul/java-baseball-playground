package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringCalculator {
    private String expression;
    private Stack<String> stringNumbers;

    private final List<String> operators = Arrays.asList("+", "-", "*", "/");;

    public StringCalculator(String expression) {
        this.expression = expression;
        this.stringNumbers = new Stack<>();
    }

    public int calculation() {
        String[] values = expression.split(" ");

        for (String value : values) {
            calculate(value);
        }

        return Integer.parseInt(stringNumbers.pop());
    }

    private void calculate(String value) {
        if (this.operators.contains(value)) {
            this.stringNumbers.push(value);
            return;
        }

        if (this.stringNumbers.isEmpty()) {
            this.stringNumbers.push(value);
            return;
        }

        String operator = this.stringNumbers.pop();
        this.stringNumbers.push(String.valueOf(operate(value, operator)));
    }

    private int operate(String value, String operator) {
        switch (operator) {
            case "+":
                return Integer.parseInt(this.stringNumbers.pop()) + Integer.parseInt(value);
            case "-":
                return Integer.parseInt(this.stringNumbers.pop()) - Integer.parseInt(value);
            case "*":
                return Integer.parseInt(this.stringNumbers.pop()) * Integer.parseInt(value);
            case "/":
                return Integer.parseInt(this.stringNumbers.pop())/ Integer.parseInt(value);
            default:
                return 0;
        }
    }
}
