package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import junit.framework.TestCase;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AndroidDriver driver;
    private static String AppiumUrl = "http://127.0.0.1:4723";
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("platformName","Android");
        options.setCapability("deviceName","Pixel8");
        options.setCapability("platformVersion","10.0");
        options.setCapability("automationName","UiAutomator2");
        options.setCapability("appPackage","org.wikipedia");
        options.setCapability("appActivity",".main.MainActivity");
        options.setApp(System.getProperty("user.dir") + "/apks/org.wikipedia_1.apk");

        driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL(AppiumUrl), options
        );

    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();driver.quit();
    }
}
