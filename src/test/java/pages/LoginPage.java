package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "login_button")
    private WebElement loginButton;

    @FindBy(xpath = "//h2[@class='background_color red']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='carton']//ul")
    private List<WebElement> listErrors;



    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Authenticate credentials")
    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @Step("Check error color")
    public String getErrorColor() {
        return errorMessage.getCssValue("background-color");
    }

    @Step("Check number of error messages")
    public int getNumberOfErrorMessages() {
        return listErrors.size() + 1;
    }
}
