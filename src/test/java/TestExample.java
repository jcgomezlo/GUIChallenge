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
import utils.DriverFactory;

import java.util.List;


public class TestExample extends Hooks {
    private static final Logger Logger = LogManager.getLogger(TestExample.class);

    @Test
    public void firstTest()   {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        By searchBar = By.id("searchInput");
        By listLocator = By.cssSelector(".suggestions-dropdown >a");

        driver.findElement(searchBar).sendKeys("Endava");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listLocator,0));

        List<WebElement> suggestedItems = driver.findElements(listLocator);
        suggestedItems.get(1).click();

        Assert.assertNotNull(null);
    }

    @Test
    public void second()   {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        By searchBar = By.id("searchInput");
        By listLocator = By.cssSelector(".suggestions-dropdown >a");

        driver.findElement(searchBar).sendKeys("Endava");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listLocator,0));

        List<WebElement> suggestedItems = driver.findElements(listLocator);
        suggestedItems.get(0).click();
    }


}
