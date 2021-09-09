package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LandingPage.class);

    @FindBy(xpath = "//ul[contains(@class,'primary')]//a[normalize-space()='Login']")
    private WebElement goToLoginButton;

    @FindBy(id = "inner_search_v4")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "(//div[@class='sub_media']/div/ul/li/a)[1]")
    private WebElement movieButton;

    @FindBy(xpath = "//a[@href='/movie/top-rated']")
    private WebElement topRatedButton;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Go to login")
    public LoginPage goToLogin(){
        goToLoginButton.click();
        logger.info("Going to login page ...");
        return new LoginPage(driver);
    }

    @Step("Search a query")
    public void search(String query){
        searchBar.sendKeys(query);
        searchButton.click();
    }

    @Step("Go to top rated movies")
    public MoveListPage goToTopRatedMovies(){

        Actions builder = new Actions(driver);
        builder.moveToElement(movieButton).perform();
        topRatedButton.click();
        return new MoveListPage(driver);
    }
}
