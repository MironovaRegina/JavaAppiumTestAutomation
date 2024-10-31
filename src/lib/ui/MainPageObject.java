package lib.ui;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collections;

public class MainPageObject {
    protected AndroidDriver driver;
    public  MainPageObject(AndroidDriver driver) {
        this.driver = driver;
    }
    public boolean assertElementHasText(WebElement element, String error_message, String expected_text)
    {
        boolean result = element.getAttribute("text").equals(expected_text);
        if(!result)
        {
            System.out.println(error_message);
        }
        return result;
    }
    public WebElement waitForElementPresent(By by, String error_message, Duration timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message+ "\n");
        return wait.until((ExpectedConditions.presenceOfElementLocated(by)));
    }
    public boolean waitForElementNotPresent(By by,String err_message, Duration timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(err_message+ "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void swipeRightToLeft() {
        int duration = 800;
        Dimension screenSize = driver.manage().window().getSize();

        int startX = (int) (screenSize.width * 0.9);
        int endX = (int) (screenSize.width * 0.1);
        int y = screenSize.height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }
    public boolean assertElementPresent(By by)
    {
        return driver.findElement(by).isDisplayed();
    }
}
