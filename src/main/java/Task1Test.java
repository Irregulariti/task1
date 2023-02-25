
import java.io.*;

import org.testng.annotations.Test;
public class Task1Test {

    @Test
    public void test() {
        Task1 num1 = new Task1(4, "3333333");
        Task1 num2 = new Task1(4, "55555555");
        System.out.printf(num1.plus(num2));
    }

}
