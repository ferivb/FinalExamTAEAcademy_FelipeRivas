package utils.web.config.diver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){

    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
    }

    public static WebDriverWait implicitWait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        return wait;
    }

    public static WebDriverWait explicitWait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        return wait;
    }

    public static void quit(){
        DriverManager.driver.get().quit();
        driver.remove();
    }
}
