package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateRandom;

import java.util.ArrayList;
import java.util.List;

public class MoviePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(MoviePage.class);

    @FindBy(css = "span.genres > a")
    List<WebElement> genres;

    @FindBy(css = "section[class *= 'header poster'] h2 > a")
    WebElement title;

    @FindBy(css = "ol[class = 'people scroller'] > li.card")
    List<WebElement> cast;

    public MoviePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }


    @Step("Get genres")
    public List<String> getGenres(){
        List<String> genresText = new ArrayList<>();
        for(WebElement genre : genres){
            genresText.add(genre.getText());
        }
        logger.info("Genres found: " + genresText);
        return genresText;
    }

    @Step("Go to actor page")
    public ActorPage goToCastPage(int number){
        cast.get(number).click();
        return new ActorPage(driver);
    }

    public ActorPage goToAnyCastPage(){
        return goToCastPage(GenerateRandom.generateRandomNumber(0,3));
    }

    @Step("Check title")
    public String getTitle(){
        return title.getText();
    }

}
