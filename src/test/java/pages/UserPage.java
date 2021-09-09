package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage {

    @FindBy(css = "div[class='content_wrapper flex'] h2 a")
    WebElement userTitle;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Step("Check user title")
    public String getUserTitle(){
        return userTitle.getText();
    }

}
