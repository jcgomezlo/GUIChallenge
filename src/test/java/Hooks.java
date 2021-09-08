import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.DriverFactory;
import utils.Screenshot;

import javax.print.DocFlavor;

public class Hooks {


    @BeforeMethod
    public void setup(){
        DriverFactory.getInstance().setDriver(BrowserFactory.getDriver("chrome"));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.themoviedb.org");
    }

    @AfterMethod
    public void closeDriver(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            Screenshot.captureScreenshot(DriverFactory.getInstance().getDriver(), result.getName());

        }
        DriverFactory.getInstance().closeBrowser();
    }
}
