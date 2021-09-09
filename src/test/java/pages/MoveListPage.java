package pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "(//div[@class='content']/div/div[@class='filter_panel card closed'])[1]")
    WebElement filtersButton;

    @FindBy(xpath = "//a[normalize-space()='Action']")
    WebElement actionFilterButton;

    @FindBy(xpath = "//div[@id='page_1']/div")
    List<WebElement> filterResult;

    @FindBy(xpath = "//span[@class='k-widget k-dropdown kendo_dropdown full_width font_size_1']")
    WebElement sortByButton;

    @FindBy(xpath = "//div[@class='apply full background_color light_blue enabled fixed']//a[@class='no_click load_more'][normalize-space()='Search']")
    WebElement searchFilterButton;

    @FindBy(xpath = "//div[@class='apply small background_color light_blue enabled']//a[@class='no_click load_more'][normalize-space()='Search']")
    WebElement searchSmallButton;

    @FindBy(xpath = "//div[@class='card style_1']//p")
    List<WebElement> dates;



    public MoveListPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    private void waitForSearch(){
        By asd = By.xpath("//div[@class='apply small background_color light_blue disabled']//a[@class='no_click load_more'][normalize-space()='Search']");
        driver.findElement(asd);
    }

    @Step("Filter results by some parameter")
    public void filterByGenre(){
        filtersButton.click();
        actionFilterButton.click();
        searchFilterButton.click();
        waitForSearch();
    }

    @Step("Go to movie page")
    public MoviePage goToMovie(int number){
        filterResult.get(number).click();
        return new MoviePage(driver);
    }

    public MoviePage goToAnyMovie(){
        return goToMovie(GenerateRandom.generateRandomNumber(0,filterResult.size()-1));
    }

    @Step("Apply filter to results")
    public void applyFilter(String query){
        sortByButton.click();
        By element = By.xpath("//li[normalize-space()='"+query+"']");
        driver.findElement(element).click();
    }

    @Step("Sort results by some filter")
    public void sortBy(String query) {
        applyFilter(query);
        searchSmallButton.click();
        waitForSearch();
    }

    @Step("Check if dates are in ascending order")
    public boolean datesAreInAscendingOrder(int numberOfDates){
        By element = By.xpath("(//div[@class='card style_1']//p)[position() <= "+ numberOfDates +"]");
        List<WebElement> datesElement =  driver.findElements(element);
        System.out.println(datesElement.size());
        return isSorted(getDatesFromText(datesElement));
    }



}
