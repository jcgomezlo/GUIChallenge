package dataproviders;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.DriverFactory;
import utils.Utilities;

import java.util.Date;
import java.util.concurrent.TimeUnit;



public class Hooks {


    @BeforeMethod
    public void setup(){
        DriverFactory.getInstance().setDriver(BrowserFactory.getDriver("chrome"));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.themoviedb.org");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDriver(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            Utilities.captureScreenshot(DriverFactory.getInstance().getDriver(), result.getName());
        }
        DriverFactory.getInstance().closeBrowser();
    }



}
