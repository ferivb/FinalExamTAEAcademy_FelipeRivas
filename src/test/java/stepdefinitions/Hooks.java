package stepdefinitions;

import config.web.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

import static java.lang.String.format;

public class Hooks {

    private Driver driver;
    public Logger log = Logger.getLogger(Hooks.class);
    private String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    private String browser = "chrome";

    @Before
    public void testSetUp(){
        driver = new Driver(browser);
        log.info("Deleting all Cookies");
        driver.getDriver().manage().deleteAllCookies();
        log.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.getDriver().quit();
    }
}
