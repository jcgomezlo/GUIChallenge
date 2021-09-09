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

public class FilterTest extends Hooks {
    private static final Logger logger = LogManager.getLogger(FilterTest.class);

    @Test
    public void filterTopMoviesByGenre() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        MoveListPage moveListPage = landingPage.goToTopRatedMovies();
        moveListPage.filterByGenre();
        MoviePage moviePage = moveListPage.goToAnyMovie();
        Assert.assertTrue(moviePage.genreIncludes("Action"));
    }

    @Test
    public void sortByDatesAscending() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        MoveListPage moveListPage = landingPage.goToTopRatedMovies();
        moveListPage.sortBy("Release Date Ascending");
        Assert.assertTrue(moveListPage.datesAreInAscendingOrder(5));
    }
}
