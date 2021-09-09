import dataproviders.Hooks;
import io.qameta.allure.Feature;
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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ActorTest extends Hooks {
    private static final Logger logger = LogManager.getLogger(ActorTest.class);

    @Feature("Actor")
    @Test
    public void ValidateActingTimeline() {
        logger.info("Validate Acting Timeline test initiated ..");

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        MoveListPage moveListPage = landingPage.goToTopRatedMovies();
        MoviePage moviePage = moveListPage.goToAnyMovie();
        String movieTitle = moviePage.getTitle();
        logger.info("Movie title " +  movieTitle);
        ActorPage actorPage = moviePage.goToAnyCastPage();
        assertThat(actorPage.hasParticipatedInMovie(movieTitle),is(true));
    }


}
