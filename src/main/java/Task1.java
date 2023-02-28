
import java.util.ArrayList;

import static com.google.common.math.IntMath.mod;
import static java.lang.Math.abs;

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
        num2 = "0".repeat(num1.length() - num2.length()) + num2;
        String answer = "0".repeat(num1.length());
        int c = 0;
        int temp = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            if (num1.charAt(i) == ',') {
                answer = answer.substring(0, i) + ',' + answer.substring(i + 1);
            } else {
                temp = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(i)) + c;
                c = temp / 10;
                temp = mod(temp, 10);
                answer = answer.substring(0, i) + temp + answer.substring(i + 1);
            }
        }
        if (c == 1) {
            answer = c + answer;
        }
        while (answer.charAt(answer.length() - 1) == '0' || answer.charAt(answer.length() - 1) == ',') {
            if (answer.charAt(answer.length() - 1) == '0') {
                answer = answer.substring(0, answer.length() - 1);
            } else {
                answer = answer.substring(0, answer.length() - 1);
                break;
            }
        }
        return answer;
    }

    public String minus(Task1 other) {
        String num1, num2;
        num1 = this.number;
        num2 = other.number;
        num2 = "0".repeat(num1.length() - num2.length()) + num2;
        String answer = "0".repeat(num1.length());
        int c = 0;
        int temp = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            if (num1.charAt(i) == ',') {
                answer = answer.substring(0, i) + ',' + answer.substring(i + 1);
            } else {
                temp = Character.getNumericValue(num1.charAt(i)) - Character.getNumericValue(num2.charAt(i)) + c;
                c = 0;
                if (temp < 0) {
                    temp += 10;
                    c = -1;
                }
                answer = answer.substring(0, i) + temp + answer.substring(i + 1);
            }
        }
        while (answer.charAt(answer.length() - 1) == '0' || answer.charAt(answer.length() - 1) == ',') {
            if (answer.charAt(answer.length() - 1) == '0') {
                answer = answer.substring(0, answer.length() - 1);
            } else {
                answer = answer.substring(0, answer.length() - 1);
                break;
            }
        }
        return answer;
    }

    public Task1 multiply(Task1 other) {
        String num1, num2;
        if (this.number.length() >= other.number.length()) {
            num1 = this.number;
            num2 = other.number;
        } else {
            num2 = this.number;
            num1 = other.number;
        }
        int comma = (num1.length() - num1.indexOf(',') - 1) + (num2.length() - num2.indexOf(',') - 1);
        num1 = num1.substring(0, num1.indexOf(',')) + num1.substring(num1.indexOf(',') + 1);
        num2 = num2.substring(0, num2.indexOf(',')) + num2.substring(num2.indexOf(',') + 1);
        String answer = "0".repeat(num1.length() + 1);
        ArrayList<Task1> process = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int c = 0;
            int temp = 0;
            if (num2.charAt(i) != ',') {
                for (int j = num1.length() - 1; j >= 0; j--) {
                    if (num1.charAt(j) != ',') {
                        temp = Character.getNumericValue(num1.charAt(j)) * Character.getNumericValue(num2.charAt(i)) + c;
                        c = temp / 10;
                        temp = mod(temp, 10);
                        answer = answer.substring(0, j) + temp + answer.substring(j + 1);
                    }
                }
                answer = answer.substring(0, answer.length() - 1);
                if (c != 0) {
                    answer = c + answer;
                }
                answer += "0".repeat(num1.length() - i - 1);
                if (answer.length() <= comma) {
                    answer = "0".repeat(abs(answer.length() - comma) + 1) + answer;
                }
                process.add(new Task1(comma, answer));
                answer = "0".repeat(num1.length() + 1);
            }
        }
        Task1 multi = process.get(0);
        System.out.println(process);
        for (int i = 1; i < process.size() ; i++) {
            multi.plus(process.get(i));
        }
        System.out.println(multi);
//        while (answer.charAt(answer.length() - 1) == '0' || answer.charAt(answer.length() - 1) == ',') {
//            if (answer.charAt(answer.length() - 1) == '0') {
//                answer = answer.substring(0, answer.length() - 1);
//            } else {
//                answer = answer.substring(0, answer.length() - 1);
//                break;
//            }
//        }
        return multi;
    }

    @Override
    public String toString() {
        return number;
    }

}