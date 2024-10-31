package lib.ui;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.time.Duration;

public class SearchPageObject extends MainPageObject{
    private static final String
    SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
    SEARCH_INPUT = "org.wikipedia:id/search_src_text",
    SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
    VIEW_GROUP = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/search_results_list\"]/android.view.ViewGroup[1]",
    WEB_VIEW = "org.wikipedia:id/page_web_view",
    TITLE = "//android.view.View[@resource-id=\"pcs-edit-section-title-description\"]";
    public SearchPageObject(AndroidDriver driver)
    {
        super(driver);
    }

    public void initSearchInput()
    {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"элемент не найден", Duration.ofSeconds(5)).click();
    }
    public void typeSearchLine(String word)
    {
        this.waitForElementPresent(By.id(SEARCH_INPUT),"элемент не найден",Duration.ofSeconds(5)).sendKeys(word);
    }
    public void clearButtonClick()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON),"элемент не найден",Duration.ofSeconds(5)).click();
    }
    public void waitForCancelButtonToAppear(){
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON),"элемент не найден",Duration.ofSeconds(5));

    }
    public boolean waitForCancelButtonToDisappear(){
        return this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON),"элемент не найден",Duration.ofSeconds(5));
    }
    public boolean isTitleofArticle(){
        this.waitForElementPresent(By.xpath(VIEW_GROUP),"элемент не найден",Duration.ofSeconds(5)).click();
        this.waitForElementPresent(By.id(WEB_VIEW),"элемент не найден",Duration.ofSeconds(15)).click();
        return this.assertElementPresent(By.xpath(TITLE));
    }

}
