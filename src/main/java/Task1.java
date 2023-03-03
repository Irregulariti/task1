
import java.util.ArrayList;

import static com.google.common.math.IntMath.mod;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Task1 {

    private final String baidjan;

    public Task1(int precision, String string) {
        if (precision != 0 && precision < string.length()) {
            string = string.substring(0, string.length() - precision) + "," + string.substring(string.length() - precision);
            while (string.charAt(string.length() - 1) == '0' || string.charAt(string.length() - 1) == ',') {
                if (string.charAt(string.length() - 1) == '0') {
                    string = string.substring(0, string.length() - 1);
                } else {
                    string += "0";
                    break;
                }
            }
            this.baidjan = string;
        } else if (precision >= string.length()) {
            string = "0" + "," + "0".repeat(precision - string.length()) + string;
            this.baidjan = string;
        } else {
            this.baidjan = string + ",0";
        }
    }

    public Task1 plus(Task1 other) {
        String num1, num2;
        num1 = this.baidjan;
        num2 = other.baidjan;
        num1 = "0".repeat(Math.max(num2.substring(0, num2.indexOf(',')).length() - num1.substring(0, num1.indexOf(',')).length(), 0)) + num1;
        num2 = "0".repeat(Math.max(num1.substring(0, num1.indexOf(',')).length() - num2.substring(0, num2.indexOf(',')).length(), 0)) + num2;
        num1 += "0".repeat(Math.max(0, num2.substring(num2.indexOf(',') + 1).length() - num1.substring(num1.indexOf(',') + 1).length()));
        num2 += "0".repeat(Math.max(0, num1.substring(num1.indexOf(',') + 1).length() - num2.substring(num2.indexOf(',') + 1).length()));
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
                answer += "0";
                break;
            }
        }
        while (answer.charAt(0) == '0' && answer != "0"){
            answer = answer.substring(1);
        }
        if (answer.indexOf(',') != -1) {
            return new Task1(answer.length() - answer.indexOf(',') - 1, answer.substring(0, answer.indexOf(',')) + answer.substring(answer.indexOf(',') + 1));
        } else {
            return new Task1(0, answer);
        }
    }

    public Task1 minus(Task1 other) {
        String num1, num2;
        num1 = this.baidjan;
        num2 = other.baidjan;
        num1 = "0".repeat(Math.max(num2.substring(0, num2.indexOf(',')).length() - num1.substring(0, num1.indexOf(',')).length(), 0)) + num1;
        num2 = "0".repeat(Math.max(num1.substring(0, num1.indexOf(',')).length() - num2.substring(0, num2.indexOf(',')).length(), 0)) + num2;
        num1 += "0".repeat(Math.max(0, num2.substring(num2.indexOf(',') + 1).length() - num1.substring(num1.indexOf(',') + 1).length()));
        num2 += "0".repeat(Math.max(0, num1.substring(num1.indexOf(',') + 1).length() - num2.substring(num2.indexOf(',') + 1).length()));
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
                answer += "0";
                break;
            }
        }
        if (answer.indexOf(',') != -1) {
            return new Task1(answer.length() - answer.indexOf(',') - 1, answer.substring(0, answer.indexOf(',')) + answer.substring(answer.indexOf(',') + 1));
        } else {
            return new Task1(0, answer);
        }
    }

    public Task1 multiply(Task1 other) {
        String num1, num2;
        if (this.baidjan.length() >= other.baidjan.length()) {
            num1 = this.baidjan;
            num2 = other.baidjan;
        } else {
            num2 = this.baidjan;
            num1 = other.baidjan;
        }
        int comma = num1.substring(num1.indexOf(',') + 1).length() + num2.substring(num2.indexOf(',') + 1).length();
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
                answer += "0".repeat(num2.length() - i - 1);
                if (answer.length() <= comma) {
                    answer = "0".repeat(abs(answer.length() - comma) + 1) + answer;
                }
                process.add(new Task1(comma, answer));
                answer = "0".repeat(num1.length() + 1);
            }
        }
        Task1 multi = process.get(0);
        for (int i = 1; i < process.size(); i++) {
            multi = multi.plus(process.get(i));
        }
        return multi;
    }

    public Task1 division(Task1 other, int precision) {
        String ans = "";
        String num1 = this.baidjan;
        String num2 = other.baidjan;
        int c2 = num2.substring(num2.indexOf(',') + 1).length();
        num2 = num2.substring(0, num2.indexOf(',')) + num2.substring(num2.indexOf(',') + 1);
        int num = Integer.parseInt(num2);
        while (c2 != 0) {
            if (num1.indexOf(',') != num1.length()-1) {
                num1 = num1.substring(0,num1.indexOf(',')) + num1.charAt(num1.indexOf(',') +  1) + ',' + num1.substring(num1.indexOf(',') + 2);
            } else {
                num1 = num1.substring(0,num1.indexOf(',')) + "0,0";
            }
            c2--;
        }
        int i = 0;
        int comma = 0;
        String temp = "";
        Boolean flag = false;
        while (true) {
            if (i != num1.length()) {
                if (num1.charAt(i) == ',') {
                    comma = ans.length();
                    flag = true;
                    i++;
                    continue;
                }
                temp += num1.charAt(i);
                i++;
            } else {
                temp += "0";
            };
            int tempInt = Integer.parseInt(temp);
            if (tempInt / num != 0) {
                ans += String.valueOf(tempInt/num);
                temp = String.valueOf(tempInt%num);
            } else {
                if (ans.length() != 0) {
                    ans += "0";
                }
            }
            if (flag && (ans.substring(comma).length() == precision + 1 || tempInt == 0)){
                break;
            }
        }
        return new Task1(ans.length()-comma, ans).round(precision);
    }

    public Task1 round(int precision) {
        String num = this.baidjan;
        String temp = num.substring(num.indexOf(',') + 1);
        String answer = num.substring(0, num.indexOf(','));
        if (temp.length() <= precision) {
            return this;
        } else {
            if (Character.getNumericValue(temp.charAt(precision)) >= 5) {
                temp = temp.substring(0, precision - 1) + (Character.getNumericValue(temp.charAt(precision - 1)) + 1);
            } else {
                temp = temp.substring(0, precision - 1) + (Character.getNumericValue(temp.charAt(precision - 1)));
            }
        }
        return new Task1(precision, answer + temp);
    }

    @Override
    public String toString() {
        return baidjan;
    }

}