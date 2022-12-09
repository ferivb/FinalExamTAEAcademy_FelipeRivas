package utils.web.config.diver;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.mobile.config.AndroidDriverManager;

public enum DriverFactory {

    CHROME{
        @Override
        public WebDriver createDriver(){
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver();
        }
    },

    FIREFOX{
        @Override
        public WebDriver createDriver(){
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver createDriver();

}
