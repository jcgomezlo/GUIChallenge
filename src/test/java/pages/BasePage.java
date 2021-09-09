package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver webDriver){
        this.driver = webDriver;
    }
}
