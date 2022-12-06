package stepdefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;
import utils.web.config.diver.DriverFactory;
import utils.web.config.diver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import models.pageobjects.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.web.config.WebConfig;

import java.time.Duration;

import static java.lang.String.format;
import static java.lang.String.valueOf;

public class Hooks extends WebConfig {

    public Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void testSetUp(){
        WebDriver driver = DriverFactory.valueOf(browser.toUpperCase()).createDriver();
        DriverManager.setDriver(driver);
        log.info("Deleting all Cookies");
        DriverManager.getDriver().manage().deleteAllCookies();
        log.info(format("Navigating to %s", url));
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.implicitWait();
    }

    @After
    public void tearDown() {
        DriverManager.quit();
    }
}
