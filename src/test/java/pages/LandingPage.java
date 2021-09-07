package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPage {
    private final WebDriver driver = new ChromeDriver();

    public void goTo() {
        driver.navigate().to("https://www.google.com");
    }
}
