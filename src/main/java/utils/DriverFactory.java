package utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public void closeBrowser(){
        driver.get().close();
        driver.remove();
    }

}
