import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

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
        options.setApp(System.getProperty("user.dir") + "/apks/org.wikipedia.apk");

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
        WebElement element = driver.findElement(By.xpath("//*[contains(@text, 'Search Wikipedia')]"));
        element.click();
    }

    @Test
    public void secondTest(){
        WebElement element = waitForElementPresent(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),"элемент не найден",Duration.ofSeconds(5));
        boolean isContains =  assertElementHasText(element,"не содержит текст","Search Wikipedia");
        Assert.assertTrue(isContains);
    }
    private boolean assertElementHasText(WebElement element, String error_message, String expected_text)
    {
        boolean result = element.getAttribute("text").equals(expected_text);
        if(!result)
        {
            System.out.println(error_message);
        }
        return result;
    }
    private WebElement waitForElementPresent(By by, String error_message, Duration timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message+ "\n");
        return wait.until((ExpectedConditions.presenceOfElementLocated(by)));
    }
    @Test
    public void findWordTest(){
        String word = "Java";
        waitForElementPresent(By.id("org.wikipedia:id/fragment_feed_header"),"элемент не найден",Duration.ofSeconds(5)).click();
        waitForElementPresent(By.id("org.wikipedia:id/search_src_text"),"элемент не найден",Duration.ofSeconds(5)).sendKeys(word);
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(@text, '"+word+"')]")).size()>3);
        WebElement el = waitForElementPresent(By.id("org.wikipedia:id/search_close_btn"),"элемент не найден",Duration.ofSeconds(5));
        el.click();
        el.click();
        Assert.assertTrue(waitForElementNotPresent(el,"элемент не найден",Duration.ofSeconds(5)));
    }
    private boolean waitForElementNotPresent(WebElement element,String err_message, Duration timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(err_message+ "\n");
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
