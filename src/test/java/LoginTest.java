import dataproviders.Hooks;
import dataproviders.LoginDataProvider;
import entities.LoginUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.UserPage;
import utils.DriverFactory;


public class LoginTest extends LoginDataProvider {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    
    @Test(dataProvider = "ValidCredentials")
    public void SuccessfulLogin(String username, String password) {
        logger.info("Successful Login test initiated ..");
        logger.info("Username: " + username);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.goToLogin();
        loginPage.login(username,password);
        UserPage userPage = new UserPage(driver);
        Assert.assertEquals(userPage.getUserTitle(),username);
    }

    @Test(dataProvider = "InvalidCredentials")
    public void FailedLogin(String username, String password){
        logger.info("Failed Login test initiated ..");
        logger.info("Username: " + username);
        logger.info("Password: " + password);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.goToLogin();
        loginPage.login(username,password);
        Assert.assertEquals(loginPage.getErrorColor(), LoginUtils.RGB_RED);
        Assert.assertEquals(loginPage.getNumberOfErrorMessages(), 2);
    }


}
