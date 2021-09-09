import dataproviders.LoginDataProvider;
import entities.LoginUtils;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.UserPage;
import utils.DriverFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends LoginDataProvider {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Feature("Login")
    @Test(dataProvider = "ValidCredentials")
    public void SuccessfulLogin(String username, String password) {
        logger.info("Successful Login test initiated ..");
        logger.info("Username: " + username);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.goToLogin();
        UserPage userPage = loginPage.login(username,password);
        assertThat(userPage.getUserTitle(),equalTo(username));
    }

    @Feature("Login")
    @Test(dataProvider = "InvalidCredentials")
    public void FailedLogin(String username, String password){
        logger.info("Failed Login test initiated ..");
        logger.info("Username: " + username);
        logger.info("Password: " + password);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.goToLogin();
        loginPage.login(username,password);
        assertThat(loginPage.getErrorColor(),equalTo(LoginUtils.RGB_RED));
        assertThat(loginPage.getNumberOfErrorMessages(),equalTo(2));
    }


}
