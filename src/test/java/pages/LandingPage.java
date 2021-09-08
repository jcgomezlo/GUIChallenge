package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class,'primary')]//a[normalize-space()='Login']")
    private WebElement goToLoginButton;

    @FindBy(id = "inner_search_v4")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLogin(){
        goToLoginButton.click();
        return new LoginPage(driver);
    }

    public void search(String query){
        searchBar.sendKeys(query);
        searchButton.click();
    }
}
