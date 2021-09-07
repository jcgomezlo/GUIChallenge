import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class TestExample {
    private static final Logger Logger = LogManager.getLogger(TestExample.class);

    @Test
    public void firstTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.wikipedia.org/");

        By searchBar = By.id("searchInput");
        By listLocator = By.cssSelector(".suggestions-dropdown >a");

        driver.findElement(searchBar).sendKeys("Endava");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listLocator,0));

        List<WebElement> suggestedItems = driver.findElements(listLocator);
        suggestedItems.get(0).click();



//        driver.quit();
    }

}
