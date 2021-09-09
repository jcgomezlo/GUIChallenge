package utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class BrowserFactory {

    private static final Logger Logger = LogManager.getLogger(BrowserFactory.class);

    public static WebDriver getDriver(String browser) throws IllegalArgumentException {
        browser = browser.toUpperCase(Locale.ROOT);
        if(browser.equals("CHROME")){
            return new ChromeDriver();
        } else if(browser.equals("FIREFOX")){
            return new FirefoxDriver();
        }
        else if(browser.equals("EDGE")){
            return new EdgeDriver();
        } else {
            Logger.error("Invalid driver property");
            throw new IllegalArgumentException("Not recognized browser");
        }
    }
}
