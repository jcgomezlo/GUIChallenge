package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class SearchPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(SearchPage.class);


    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @Step("Get title of first result")
    public String getTitleOfResult(int number){
        By element = By.cssSelector("div[class *= 'search_results movie'] div[class *= 'card']:nth-child("+(number+1)+") h2");
        String titleText = driver.findElement(element).getText();
        logger.info("Title Text: " + titleText);
        return titleText;
    }
}
