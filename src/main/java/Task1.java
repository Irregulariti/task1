
public class Task1 {

    private final String number;

    public Task1(int precision, String string) {
        this.number = string.substring(0, string.length() - precision) + "," + string.substring(string.length() - precision);
    }

    public String plus(Task1 other) {
        String num1, num2;
        if (this.number.toString().length() >= other.number.toString().length()) {
            num1 = this.number.toString();
            num2 = other.number.toString();
        } else {
            num2 = this.number.toString();
            num1 = other.number.toString();
        }
        String answer = "0".repeat((num1.length()+1));
        num2 += "0".repeat(num1.length() - num2.length());
        System.out.printf(answer);
        for (int i = num1.length(); i > 0; i--) {
            int temp = Integer.parseInt(String.valueOf(num2.charAt(i))) + Integer.parseInt(String.valueOf(num1.charAt(i)));

        }
        return "";
    }

    @Override
    public String toString() {
        return number;
    }

}