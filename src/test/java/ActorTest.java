import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MoveListPage;
import pages.MoviePage;
import utils.DriverFactory;

public class ActorTest extends Hooks {
    private static final Logger logger = LogManager.getLogger(ActorTest.class);

    @Test
    public void validateActingTimeLine() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        MoveListPage moveListPage = landingPage.goToTopRatedMovies();
        moveListPage.filterByGenre();
        MoviePage moviePage = moveListPage.goToAnyMovie();
        Assert.assertTrue(moviePage.genreIncludes("Action"));
    }
}
