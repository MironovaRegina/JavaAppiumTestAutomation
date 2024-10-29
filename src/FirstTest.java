import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

public class FirstTest {
    private AndroidDriver driver;
    @Before
    public void setUP() throws Exception
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("platformName","Android");
        options.setCapability("deviceName","Pixel8");
        options.setCapability("platformVersion","10.0");
        options.setCapability("automationName","UiAutomator2");
        options.setCapability("appPackage","org.wikipedia");
        options.setCapability("appActivity",".main.MainActivity");

        driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );

    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void firstTest(){
        System.out.println("First test run");
    }
}
