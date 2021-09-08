package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateRandom;

import java.util.List;

public class MoviePage extends BasePage {

    @FindBy(xpath = "//span[@class='genres']/a")
    List<WebElement> genres;

    @FindBy(xpath = "//section[@class='header poster']//h2/a")
    WebElement title;

    @FindBy(xpath = "//ol[@class='people scroller']/li")
    List<WebElement> cast;

    public MoviePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public boolean genreIncludes(String genreName){
        for(WebElement genre : genres){
            if(genre.getText().equals(genreName)){
                return true;
            }
        }
        return false;
    }

    public ActorPage goToCastPage(int number){
        cast.get(number).click();
        return new ActorPage(driver);
    }

    public ActorPage goToAnyCastPage(){
        return goToCastPage(GenerateRandom.generateRandomNumber(0,cast.size()-1));
    }

    public String getTitle(){
        return title.getText();
    }

}
