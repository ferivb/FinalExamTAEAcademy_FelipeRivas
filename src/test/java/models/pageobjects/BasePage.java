package models.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.web.config.diver.DriverManager;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOn(WebElement element){
        DriverManager.explicitWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
