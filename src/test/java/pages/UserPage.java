package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(UserPage.class);

    @FindBy(css = "div[class='content_wrapper flex'] h2 a")
    WebElement userTitle;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Check user title")
    public String getUserTitle(){
        String userTitleText = userTitle.getText();
        logger.info("User title: " + userTitleText);
        return userTitleText;
    }

}
