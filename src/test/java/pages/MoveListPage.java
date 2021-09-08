package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateRandom;

import java.util.List;

public class MoveListPage extends BasePage{

    @FindBy(xpath = "(//div[@class='content']/div/div[@class='filter_panel card closed'])[1]")
    WebElement filtersButton;

    @FindBy(xpath = "//a[normalize-space()='Action']")
    WebElement actionFilterButton;

    @FindBy(xpath = "//div[@id='page_1']/div")
    List<WebElement> filterResult;

    @FindBy(xpath = "//div[@class='apply full background_color light_blue enabled fixed']//a[@class='no_click load_more'][normalize-space()='Search']")
    WebElement searchFilterButton;

    public MoveListPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void filterByGenre(){
        filtersButton.click();
        actionFilterButton.click();
        searchFilterButton.click();
    }

    public MoviePage goToMovie(int number){
        filterResult.get(number).click();
        return new MoviePage(driver);
    }

    public MoviePage goToAnyMovie(){
        return goToMovie(GenerateRandom.generateRandomNumber(0,filterResult.size()));
    }



}
