package utils.web.config.diver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Starts a static instance of the Android driver
     *
     * @author Santiago.gf
     */
    private DriverManager(){

    }

    /**
     * Retrieves the driver
     *
     * @return driver to use
     * @author Santiago.gf
     */
    public static WebDriver getDriver(){
        return driver.get();
    }

    /**
     * Sets the driver
     *
     * @param driver with browser setup
     * @author Santiago.gf
     */
    public static void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
    }

    /**
     * Instantiates wait instance
     *
     * @return WebDriverWait
     * @author Santiago.gf
     */
    public static WebDriverWait implicitWait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        return wait;
    }

    /**
     * Instantiates wait instance
     *
     * @return WebDriverWait
     * @author Santiago.gf
     */
    public static WebDriverWait explicitWait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        return wait;
    }

    /**
     * Quits the driver
     *
     * @author Santiago.gf
     */
    public static void quit(){
        DriverManager.driver.get().quit();
        driver.remove();
    }
}
