import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import lib.CoreTestCase;

public class FirstTest extends CoreTestCase {
    private SearchPageObject searchPageObject;
    private OnboardingPageObject onboardingPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();
        searchPageObject = new SearchPageObject(driver);
        onboardingPageObject = new OnboardingPageObject(driver);
    }

    @Test
    public void testFindWord(){
        onboardingPageObject.skipOnboarding();
        String word = "Java";
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(word);
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(@text, '"+word+"')]")).size()>3);
        searchPageObject.clearButtonClick();
        Assert.assertTrue(searchPageObject.waitForCancelButtonToDisappear());
    }


    @Test
    public void testSwipeOnbording(){
        onboardingPageObject.loadOnboarding();
        Assert.assertEquals(onboardingPageObject.swipeOnboardng(),"New ways to explore");
        Assert.assertEquals(onboardingPageObject.swipeOnboardng(),"Reading lists with sync");
        Assert.assertEquals(onboardingPageObject.swipeOnboardng(),"Send anonymous data");
        onboardingPageObject.getStartedOnboarding();
        searchPageObject.initSearchInput();
   }

    @Test
    public void testTitleIsPresentTest(){
        onboardingPageObject.skipOnboarding();
        String word = "Java";
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(word);
        Assert.assertTrue(searchPageObject.isTitleofArticle());
    }
}
