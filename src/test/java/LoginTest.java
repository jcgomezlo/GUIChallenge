import entities.LoginUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.UserPage;
import utils.DriverFactory;

import java.util.List;


public class LoginTest extends Hooks {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

//    @Test
//    public void firstTest()   {
//        WebDriver driver = DriverFactory.getInstance().getDriver();
//        By searchBar = By.id("searchInput");
//        By listLocator = By.cssSelector(".suggestions-dropdown >a");
//
//        driver.findElement(searchBar).sendKeys("Endava");
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listLocator,0));
//
//        List<WebElement> suggestedItems = driver.findElements(listLocator);
//        suggestedItems.get(1).click();
//
//        Assert.assertNotNull(null);
//    }

    @Test
    public void loginValid() throws InterruptedException {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.goToLogin();
        loginPage.login("juankg214","lapiz453");
        UserPage userPage = new UserPage(driver);
        Thread.sleep(1000);
        Assert.assertEquals(userPage.getUserTitle(),"juankg214");
    }

//    @Test
//    public void loginInvalid() throws InterruptedException {
//        WebDriver driver = DriverFactory.getInstance().getDriver();
//        LandingPage landingPage = new LandingPage(driver);
//        LoginPage loginPage = landingPage.goToLogin();
//        loginPage.login("juankg215","lapiz453");
//        Thread.sleep(1000);
//        Assert.assertEquals(loginPage.getErrorColor(), LoginUtils.RGB_RED);
//        Assert.assertEquals(loginPage.getNumberOfErrorMessages(), 2);
//    }


}
