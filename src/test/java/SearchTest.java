import dataproviders.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.SearchPage;
import utils.DriverFactory;

public class SearchTest extends Hooks {
    private static final Logger logger = LogManager.getLogger(SearchTest.class);

    @Test
    public void searchValid() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.search("Fight Club");
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.getTitleOfResult(0),"Fight Club");
    }
}
