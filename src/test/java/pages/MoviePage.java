package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MoviePage extends BasePage {

    @FindBy(xpath = "//span[@class='genres']/a")
    List<WebElement> genres;

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

}
