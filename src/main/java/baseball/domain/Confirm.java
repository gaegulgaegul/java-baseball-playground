package baseball.domain;

import baseball.view.InputView;

public class Confirm {
    private int confirmCode = 99;

    public static boolean isRunning() {
        Confirm confirm = new Confirm();
        if (confirm.allowCode() == 1) {
            return true;
        }
        return false;
    }

    private int allowCode() {
        while (isNotAllowCode()) {
            this.confirmCode = InputView.confirm();
        }
        return this.confirmCode;
    }

    private boolean isNotAllowCode() {
        return this.confirmCode > 2;
    }
}
