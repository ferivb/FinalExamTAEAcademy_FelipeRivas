package models.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.web.config.diver.DriverManager;

public class HomePage extends BasePage {
    public HomePage() {}

    @FindBy(id = "global-user-trigger")
    private WebElement userIconButton;

    @FindBy(css = "li a[tref=\"/members/v3_1/login\"]")
    private WebElement loginIframeLauncher;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframeIframe;

    @FindBy(id = "BtnCreateAccount")
    private WebElement singUpButton;

    public void clickOnLogin(){
        clickOn(userIconButton);
        clickOn(loginIframeLauncher);
        DriverManager.getDriver().switchTo().frame(loginIframeIframe);
    }

    public void clickOnSingUp(){
        clickOn(singUpButton);
    }

    public WebElement getSingUpButton(){
        return singUpButton;
    }

}
