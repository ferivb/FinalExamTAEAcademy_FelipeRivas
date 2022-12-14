package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.mobile.config.AndroidDriverManager;
import utils.mobile.config.ConfigCapabilities;
import utils.web.config.diver.DriverFactory;
import utils.web.config.diver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.HookConfig;
import utils.Log;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class Hooks extends HookConfig {

    public static AndroidDriver<AndroidElement> driver;

    /**
     * Starts the web driver and navigates to ESPN
     *
     * @author Felipe.Rivas
     */
    @Before("@WebTest")
    public void webSetUp(){
        WebDriver driver = DriverFactory.valueOf(browser.toUpperCase()).createDriver();
        DriverManager.setDriver(driver);
        Log.log.info("Deleting all Cookies");
        DriverManager.getDriver().manage().deleteAllCookies();
        Log.log.info(format("Navigating to %s", url));
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.implicitWait();
    }

    /**
     * Quits the driver
     *
     * @author Felipe.Rivas
     */
    @After("@WebTest")
    public void webTearDown() {
        DriverManager.quit();
    }

    /**
     * Starts the Android driver launches the app and
     * completes the tutorial
     *
     * @author Felipe.Rivas
     */
    @Before("@MobileTest")
    public void mobileSetup() throws MalformedURLException {
        Log.log.info("Launching the Disney Land app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                AndroidDriverManager.setDriver(driver);
            } catch (MalformedURLException exception) {
                exception.printStackTrace();
            }
        }

    /**
     * Quits the driver
     *
     * @author Felipe.Rivas
     */
    @After("@MobileTest")
    public void mobileApplicationEnd() {
        driver.quit();
    }

    }
