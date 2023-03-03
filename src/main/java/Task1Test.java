
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Task1Test {

    Task1 num1 = new Task1(2, "3333");
    Task1 num2 = new Task1(3, "2555");
    Task1 num3 = new Task1(6, "123456789");
    Task1 num4 = new Task1(2, "12");
    Task1 num5 = new Task1(1,"1");


    @Test
    public void plusTest() {
        assertEquals(num1.plus(num2).toString(), new Task1(3, "35885").toString());
        assertEquals(num2.plus(num3).toString(), new Task1(6, "126011789").toString());
        assertEquals(num3.plus(num4).toString(), new Task1(6, "123576789").toString());
        assertEquals(num5.plus(num5).toString(), new Task1(1, "2").toString());
    }

    @Test
    public void minusTest() {
        assertEquals(num1.minus(num2).toString(), new Task1(3, "30775").toString());
        assertEquals(num3.minus(num2).toString(), new Task1(6, "120901789").toString());
        assertEquals(num2.minus(num4).toString(), new Task1(3, "2435").toString());
    }

    @Test
    public void multiplyTest(){
        assertEquals(num1.multiply(num2).toString(), new Task1(5, "8515815").toString());
        assertEquals(num3.multiply(num4).toString(), new Task1(8, "1481481468").toString());
        assertEquals(num2.multiply(num4).toString(), new Task1(4, "3066").toString());
    }

    @Test
    public void divisionTest(){
        assertEquals(num1.division(num2, 3).toString(), new Task1(3, "13045").toString());
        assertEquals(num3.division(num4, 3).toString(), new Task1(3, "1028807").toString());
        assertEquals(num2.division(num4, 3).toString(), new Task1(3, "21292").toString());
    }

    @Test
    public void roundTest(){
        assertEquals(num1.round(1).toString(), new Task1(1, "333").toString());
        assertEquals(num2.round(2).toString(), new Task1(2, "256").toString());
        assertEquals(num3.round(3).toString(), new Task1(3, "123457").toString());
        assertEquals(num4.round(1).toString(), new Task1(1, "1").toString());
    }

}
