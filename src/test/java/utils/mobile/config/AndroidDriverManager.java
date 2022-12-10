package utils.mobile.config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidDriverManager {
    /**
     * Starts a static instance of the Android driver
     *
     * @author Santiago.gf,Felipe.Rivas
     */
    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private AndroidDriverManager(){}

    /**
     * Retrieves the driver
     *
     * @return driver to use
     * @author Santiago.gf,Felipe.Rivas
     */
    public static AndroidDriver getDriver(){
        return driver.get();
    }

    /**
     * Sets the driver
     *
     * @param driver with capabilities
     * @author Santiago.gf,Felipe.Rivas
     */
    public static void setDriver(AndroidDriver driver){
        AndroidDriverManager.driver.set(driver);
    }

}
