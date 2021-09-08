package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'search_results movie')]//div[@class='results flex']")
    private List<WebElement> resultsSearch;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public String getTitleOfResult(int number){
        By element = By.xpath("(//div[contains(@class,'search_results movie')]//div[contains(@class,'card v4 tight')]//h2)[1]");
        return driver.findElement(element).getText();
    }
}
