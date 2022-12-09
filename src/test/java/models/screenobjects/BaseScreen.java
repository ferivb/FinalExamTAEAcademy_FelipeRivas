package models.screenobjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.mobile.config.AndroidDriverManager;

import java.time.Duration;

public class BaseScreen {
    /**
     * The driver.
     */


    /**
     * Constructor method for standard screens object.
     *
     * @author Arley.Bolivar, Hans.Marquez
     */
    public BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(
                AndroidDriverManager.getDriver(), Duration.ofSeconds(0)), this);
    }

    /**
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(AndroidDriverManager.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Wrapper for sendKeys event.
     *
     * @param element   : AndroidElement
     * @param sequence: String
     * @author Hans.Marquez
     */
    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(AndroidDriverManager.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(AndroidDriverManager.getDriver(), 3);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @param timeout : int
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(AndroidDriverManager.getDriver(), timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Swipes down indefinitely
     *
     * @author Felipe.Rivas
     */
    public void swipeDown()
    {
        Dimension dimension = AndroidDriverManager.getDriver().manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();
        int x = width/2;
        int bottomOfScreen = (int)(height*0.80);
        int topOfScreen = (int)(height*0.20);
        TouchAction touchScreen = new TouchAction(AndroidDriverManager.getDriver());
        touchScreen.press(PointOption.point(x, bottomOfScreen))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(x, topOfScreen))
                .release()
                .perform();
    }
}
