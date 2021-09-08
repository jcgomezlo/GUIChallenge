package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActorPage extends BasePage{

    @FindBy(xpath = "//a[@class='tooltip']")
    List<WebElement> movies;

    public ActorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public boolean hasParticipatedInMovie(String movieName){
        for(WebElement movie : movies){
            if(movie.getText().equals(movieName)){
                return true;
            }
        }
        return false;
    }

}
