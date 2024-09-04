import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

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

    @Test
    public void testGetClassNumber()
    {
        Assert.assertTrue("Число меньше или равно 45",this.getClassNumber() > 45);
    /*  if (this.getClassNumber() > 45) {
          System.out.println("Число больше 45");
      }
          else {
        Assert.fail("Число меньше или равно 45");
          }*/
      }

    }

