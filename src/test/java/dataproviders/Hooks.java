package dataproviders;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;
import pages.MovieListPage;
import utils.BrowserFactory;
import utils.DriverFactory;
import utils.Utilities;
import utils.reader.PropertiesReader;

import java.util.concurrent.TimeUnit;



public class Hooks {

    private static final PropertiesReader propertiesReader = new PropertiesReader("src/main/resources/config.properties");


    @BeforeMethod
    public void setup(){
        DriverFactory.getInstance().setDriver(BrowserFactory.getDriver(propertiesReader.getValue("browser")));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.navigate().to(propertiesReader.getValue("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDriver(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            Utilities.captureScreenshot(DriverFactory.getInstance().getDriver(), result.getName());
        }
        DriverFactory.getInstance().closeBrowser();
    }

    public MovieListPage goToTopRatedMovies(WebDriver driver){
        LandingPage landingPage = new LandingPage(driver);
        return landingPage.goToTopRatedMovies();
    }



}
