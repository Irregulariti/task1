import java.math.BigDecimal;

import static com.google.common.math.IntMath.mod;

public class Task1 {

    private final String number;

    public Task1(int precision, String string) {
        this.number = string.substring(0, string.length() - precision) + "," + string.substring(string.length() - precision);
    }

    public String plus(Task1 other) {
        String num1, num2;
        if (this.number.length() >= other.number.length()) {
            num1 = this.number;
            num2 = other.number;
        } else {
            num2 = this.number;
            num1 = other.number;
        }
        num2 += "0".repeat(num1.length() - num2.length());
        String answer = "0".repeat(num1.length() + 1);
        int m = num1.length() - 1;
        int c = 0;
        int temp = 0;
        for (int i = num1.length(); i >= 0; i--) {
            temp = (num1.charAt(i) + '0') + (num2.charAt(i) + '0') + c;
            c = temp/10;
            temp = mod(temp,10);

        }
        return "";
    }
    @Override
    public String toString() {
        return number;
    }

}