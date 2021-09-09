import dataproviders.FilterDataProvider;
import dataproviders.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MoveListPage;
import pages.MoviePage;
import utils.DriverFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterTest extends FilterDataProvider {
    private static final Logger logger = LogManager.getLogger(FilterTest.class);

    @Test(dataProvider = "Genre")
    public void VerifyMovieGenreFilter(String genre) {
        logger.info("Verify Movie Genre Filter test initiated ..");
        logger.info("Genre: " + genre);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        MoveListPage moveListPage = landingPage.goToTopRatedMovies();
        moveListPage.filterByGenre(genre);
        MoviePage moviePage = moveListPage.goToAnyMovie();
        assertThat(moviePage.getGenres(),hasItem(genre));
    }

    @Test(dataProvider = "Filter")
    public void SortDatesAscendingOrder(String filter, String numberOfDates) {
        logger.info("Verify Movie Genre Filter test initiated ..");
        logger.info("Filter: " + filter);
        logger.info("Number Of Dates: " + numberOfDates);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        MoveListPage moveListPage = landingPage.goToTopRatedMovies();
        moveListPage.sortBy(filter);
        assertThat(moveListPage.datesAreInAscendingOrder(numberOfDates),is(true));
    }
}
