package lib.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class OnboardingPageObject extends MainPageObject{
    private static final String

    SKIP_BUTTON = "//*[contains(@text, 'SKIP')]",
    GET_STARTED = "//*[contains(@text, 'GET STARTED')]",
    TEXT_VIEW = "org.wikipedia:id/primaryTextView";
    public OnboardingPageObject(AndroidDriver driver)
    {
        super(driver);
    }
    public void skipOnboarding()
    {
        this.waitForElementPresent(By.xpath(SKIP_BUTTON),"элемент не найден", Duration.ofSeconds(5)).click();
    }
    public String swipeOnboardng()
    {
        this.swipeRightToLeft();
        WebElement title = this.waitForElementPresent(By.id(TEXT_VIEW),"элемент не найден",Duration.ofSeconds(5));
        return title.getAttribute("text");
    }
    public void loadOnboarding()
    {
        this.waitForElementPresent(By.xpath(SKIP_BUTTON),"элемент не найден", Duration.ofSeconds(5));
    }
    public void getStartedOnboarding()
    {
        this.waitForElementPresent(By.xpath(GET_STARTED),"элемент не найден",Duration.ofSeconds(5)).click();
    }
}
