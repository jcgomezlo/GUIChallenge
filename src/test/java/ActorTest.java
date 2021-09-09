import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActorPage;
import pages.LandingPage;
import pages.MoveListPage;
import pages.MoviePage;
import utils.DriverFactory;

public class ActorTest extends Hooks {
    private static final Logger logger = LogManager.getLogger(ActorTest.class);

    @Test
    public void validateActingTimeLine() {
        logger.info("Started test validateActingTimeLine");
        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        MoveListPage moveListPage = landingPage.goToTopRatedMovies();
        MoviePage moviePage = moveListPage.goToAnyMovie();
        String movieTitle = moviePage.getTitle();
        logger.info("Movie title " +  movieTitle);
        ActorPage actorPage = moviePage.goToAnyCastPage();
        Assert.assertTrue(actorPage.hasParticipatedInMovie(movieTitle));
    }

    @Test
    public void tests(){
        logger.info("Started test validateActingTimeLine");
    }
}
