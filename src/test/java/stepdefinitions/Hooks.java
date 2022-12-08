package stepdefinitions;

import utils.web.config.diver.DriverFactory;
import utils.web.config.diver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.web.config.WebConfig;
import utils.web.helpers.Log;

import static java.lang.String.format;

public class Hooks extends WebConfig {

    @Before
    public void testSetUp(){
        WebDriver driver = DriverFactory.valueOf(browser.toUpperCase()).createDriver();
        DriverManager.setDriver(driver);
        Log.log.info("Deleting all Cookies");
        DriverManager.getDriver().manage().deleteAllCookies();
        Log.log.info(format("Navigating to %s", url));
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.implicitWait();
    }

    @After
    public void tearDown() {
        DriverManager.quit();
    }
}
