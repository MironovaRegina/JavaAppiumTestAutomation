import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetLocalNumber()
    {
        int b = this.getLocalNumber();
        if (b==14)
        {
            System.out.println("Возвращается корректное число = " + b);
        }
        else
        {
             System.out.println("Возвращается некорректное число. Текущее число = " + b);
        }
    }
}
