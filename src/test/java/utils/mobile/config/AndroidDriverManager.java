package utils.mobile.config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidDriverManager {
    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private AndroidDriverManager(){

    }

    public static AndroidDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(AndroidDriver driver){
        AndroidDriverManager.driver.set(driver);
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
        AndroidDriverManager.driver.get().quit();
        driver.remove();
    }

}
