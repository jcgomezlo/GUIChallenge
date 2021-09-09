package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActorPage extends BasePage{

    @FindBy(css = "a.tooltip")
    List<WebElement> movies;

    public ActorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }


    public void test(){
        By find = By.cssSelector("a.tooltip");
        List<WebElement> elements = driver.findElements(find);
        System.out.println(elements.get(0).getText());
    }

    @Step("Check if actor has participated in a movie")
    public boolean hasParticipatedInMovie(String movieName){
        for(WebElement movie : movies){
            if(movie.getText().equals(movieName)){
                return true;
            }
        }
        return false;
    }

}
