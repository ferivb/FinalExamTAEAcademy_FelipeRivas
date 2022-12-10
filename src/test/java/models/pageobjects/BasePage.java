package models.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.web.config.diver.DriverManager;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    /**
     * Constructor method for standard Page objects.
     *
     * @author Felipe.Rivas
     */
    protected BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    /**
     * Method to click on WebElements.
     *
     * @param element to click.
     * @author Felipe.Rivas
     */
    public void clickOn(WebElement element){
        DriverManager.explicitWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
