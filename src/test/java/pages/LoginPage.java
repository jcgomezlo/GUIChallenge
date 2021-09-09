package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "login_button")
    private WebElement loginButton;

    @FindBy(css = "h2[class='background_color red']")
    private WebElement errorMessage;

    @FindBy(css = "div.carton ul")
    private List<WebElement> listErrors;



    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Authenticate credentials")
    public UserPage login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        logger.info("Login fields filled and submit button clicked");
        return new UserPage(driver);
    }

    @Step("Check error color")
    public String getErrorColor() {
        String color = errorMessage.getCssValue("background-color");
        logger.info("Color of error message " + color );
        return color;
    }

    @Step("Check number of error messages")
    public int getNumberOfErrorMessages() {
        int numberErrors = listErrors.size() + 1;
        logger.info("Number of error messages " + numberErrors );
        return numberErrors;
    }


}
