import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetLocalNumber()
    {
        int b = this.getLocalNumber();
        if (b==14)
        {
            System.out.println("True");
        }
        else
        {
             System.out.println("False");
        }
    }
}
