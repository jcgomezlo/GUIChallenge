import dataproviders.FilterDataProvider;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MovieListPage;
import pages.MoviePage;
import utils.DriverFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterTest extends FilterDataProvider {
    private static final Logger logger = LogManager.getLogger(FilterTest.class);

    @Feature("Filter")
    @Test(dataProvider = "Genre")
    public void VerifyMovieGenreFilter(String genre) {
        logger.info("Verify Movie Genre Filter test initiated ..");
        logger.info("Genre: " + genre);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        MovieListPage moveListPage = goToTopRatedMovies(driver);
        moveListPage.filterByGenre(genre);
        MoviePage moviePage = moveListPage.goToAnyMovie();
        assertThat(moviePage.getGenres(),hasItem(genre));
    }

    @Feature("Filter")
    @Test(dataProvider = "Filter")
    public void SortDatesAscendingOrder(String filter, String numberOfDates) {
        logger.info("Verify Movie Genre Filter test initiated ..");
        logger.info("Filter: " + filter);
        logger.info("Number Of Dates: " + numberOfDates);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        MovieListPage moveListPage = goToTopRatedMovies(driver);
        moveListPage.sortBy(filter);
        assertThat(moveListPage.datesAreInAscendingOrder(numberOfDates),is(true));
    }
}
