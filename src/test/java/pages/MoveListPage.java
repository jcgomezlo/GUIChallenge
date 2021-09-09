package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenerateRandom;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.google.common.collect.Iterables.isEmpty;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static utils.Utilities.getDatesFromText;
import static utils.Utilities.isSorted;

public class MoveListPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(MoveListPage.class);

    @FindBy(css = "div[class *= 'filter_panel card']:nth-child(2)")
    WebElement filtersButton;

    @FindBy(css = "div#page_1 div[class='card style_1']")
    List<WebElement> filterResult;

    @FindBy(css = "div[class='filter_panel card'] > div.filter > span")
    WebElement sortByButton;

    @FindBy(css = "div[class *= 'full'] > p.load_more > a")
    WebElement searchFilterButton;

    @FindBy(css = "div.content div[class *= 'small'] > p.load_more > a")
    WebElement searchSmallButton;


    public MoveListPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    private void waitForSearch(){
        By asd = By.cssSelector("div[class *= 'disabled'] a");
        driver.findElement(asd);
    }

    private void clickGenreFilterButton(String genre){
        By btn = By.cssSelector("ul#with_genres li:first-child a");
        driver.findElement(btn).click();
    }

    @Step("Filter results by some parameter")
    public void filterByGenre(String genre){
        logger.info("Started filter by genre " + genre);
        filtersButton.click();
        clickGenreFilterButton(genre);
        searchFilterButton.click();
        waitForSearch();
    }

    @Step("Go to movie page")
    public MoviePage goToMovie(int number){
        logger.info("Going to movie page");
        filterResult.get(number).click();
        return new MoviePage(driver);
    }

    public MoviePage goToAnyMovie(){
        return goToMovie(GenerateRandom.generateRandomNumber(0,3));
    }

    @Step("click sort")
    public void clickSort(String query){
        sortByButton.click();
        By element = By.xpath("//li[normalize-space()='"+query+"']");
        driver.findElement(element).click();
    }

    @Step("Sort results by some filter")
    public void sortBy(String query) {
        logger.info("Started sort  " + query);
        clickSort(query);
        searchSmallButton.click();
        waitForSearch();
    }

    @Step("Check if dates are in ascending order")
    public boolean datesAreInAscendingOrder(String numberOfDates){
        logger.info("Getting dates ...");
        By element = By.xpath("(//div[@class='card style_1']//p)[position() <= "+ numberOfDates +"]");
        List<WebElement> datesElement =  driver.findElements(element);
        List<LocalDate> dates = getDatesFromText(datesElement);
        logger.info("Dates: " + dates);
        return isSorted(dates);
    }



}
