package models.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.web.config.diver.DriverManager;
import utils.web.helpers.User;

public class HomePage extends BasePage {
    public HomePage() {}

    @FindBy(id = "global-user-trigger")
    private WebElement userIconButton;

    @FindBy(css = "li a[tref=\"/members/v3_1/login\"]")
    private WebElement loginIframeLauncher;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(id = "BtnSubmit")
    private WebElement loginSubmitButton;

    @FindBy(id = "logo")
    private WebElement iframeESPNLogo;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    @FindBy(id = "Title")
    private WebElement signUpTitle;

    @FindBy(id = "InputFirstName")
    private WebElement signUpFirstName;

    @FindBy(id = "InputLastName")
    private WebElement signUpLastName;

    @FindBy(id = "InputEmail")
    private WebElement signUpInputEmail;

    @FindBy(id = "password-new")
    private WebElement signUpPassword;

    @FindBy(id = "BtnSubmit")
    private WebElement signUpSubmitButton;

    @FindBy(id = "close")
    private WebElement signUpCloseButton;

    @FindBy(css = "a[href=\"http://www.espn.com/watch/\"]")
    private WebElement watchButton;

    public void clickOnLogin(){
        clickOn(userIconButton);
        clickOn(loginIframeLauncher);
        DriverManager.getDriver().switchTo().frame(loginIframe);
    }

    public void clickOnSignUp(){
        clickOn(signUpButton);
    }

    public boolean loginModalIsPresent(){
        boolean result = false;
        DriverManager.explicitWait().until(ExpectedConditions.visibilityOf(iframeESPNLogo));
            if (
                    loginSubmitButton.isDisplayed() &&
                    iframeESPNLogo.isDisplayed() &&
                    signUpButton.isDisplayed()
            ){
                result = true;
            }
            return result;
    }

    public boolean signUpModalIsPresent(){
        boolean result = false;
        DriverManager.explicitWait().until(ExpectedConditions.visibilityOf(signUpLastName));
        if (
                    signUpTitle.isDisplayed() &&
                    signUpFirstName.isDisplayed() &&
                    signUpLastName.isDisplayed() &&
                    signUpInputEmail.isDisplayed() &&
                    signUpPassword.isDisplayed() &&
                    signUpSubmitButton.isDisplayed() &&
                    signUpCloseButton.isDisplayed()
        ){
            result = true;
        }
        return result;
    }

    public void fillSingUpForm(){
        User validUser = new User();
        DriverManager.explicitWait().until(ExpectedConditions.visibilityOf(signUpLastName));
        signUpFirstName.sendKeys(validUser.getFirstName());
        signUpLastName.sendKeys(validUser.getLastName());
        signUpInputEmail.sendKeys(validUser.getEmail());
        signUpPassword.sendKeys(validUser.getPassword());
        clickOn(signUpSubmitButton);
        DriverManager.explicitWait().until(ExpectedConditions.invisibilityOf(loginIframe));
        DriverManager.getDriver().switchTo().parentFrame();
        DriverManager.explicitWait().until(ExpectedConditions.visibilityOf(userIconButton));
    }

    public WatchPage goToWatchPage(){
        clickOn(watchButton);
        return new WatchPage();
    }
}
