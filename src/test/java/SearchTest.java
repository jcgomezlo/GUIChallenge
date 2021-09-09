import dataproviders.SearchDataProvider;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.SearchPage;
import utils.DriverFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTest extends SearchDataProvider {
    private static final Logger logger = LogManager.getLogger(SearchTest.class);

    @Feature("Search")
    @Test(dataProvider = "Movies")
    public void SuccessfulSearch(String movie) {
        logger.info("Successful Search test initiated ..");
        logger.info("Movie: " + movie);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.search(movie);
        SearchPage searchPage = new SearchPage(driver);
        assertThat(searchPage.getTitleOfResult(0),equalTo(movie));
    }
}
