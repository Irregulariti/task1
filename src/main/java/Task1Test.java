
import java.io.*;

import org.testng.annotations.Test;
public class Task1Test {

    @Test
    public void test() {
        Task1 num1 = new Task1(1, "48");
        Task1 num2 = new Task1(1, "75");
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num1.plus(num2));
        System.out.println(num1.minus(num2));
        System.out.println(num1.multiply(num2));
    }

}
