package models.pageobjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.web.config.diver.DriverManager;
import utils.web.helpers.User;

public class HomePage extends BasePage {
    /**
     * Constructor method for Home Page.
     *
     * @author Felipe.Rivas
     */
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

    @FindBy(id = "MarketingDescription")
    private WebElement marketingDescription;

    @FindBy(id = "BtnSubmit")
    private WebElement signUpSubmitButton;

    @FindBy(id = "close")
    private WebElement signUpCloseButton;

    @FindBy(css = "a[href=\"http://www.espn.com/watch/\"]")
    private WebElement watchButton;

    @FindBy(className = "display-user")
    private WebElement welcomeText;

    @FindBy(css = ".account-management li:last-child a")
    private WebElement logoutButton;

    /**
     * Login Iframe launcher.
     *
     * @author Felipe.Rivas
     */
    public void clickOnLogin(){
        clickOn(userIconButton);
        clickOn(loginIframeLauncher);
        DriverManager.getDriver().switchTo().frame(loginIframe);
    }

    /**
     * Sign up Iframe launcher.
     *
     * @author Felipe.Rivas
     */
    public void clickOnSignUp(){
        clickOn(signUpButton);
    }

    /**
     * Validates several elements
     * from the login Iframe.
     *
     * @return boolean
     * @author Felipe.Rivas
     */
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

    /**
     * Validates several elements
     * from the signup Iframe.
     *
     * @return boolean
     * @author Felipe.Rivas
     */
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

    /**
     * Fills in the signup form and submits it
     *
     * @author Felipe.Rivas
     */
    public void fillSingUpForm(){
        User validUser = new User();
        DriverManager.explicitWait().until(ExpectedConditions.visibilityOf(signUpLastName));
        signUpFirstName.sendKeys(validUser.getFirstName());
        signUpLastName.sendKeys(validUser.getLastName());
        signUpInputEmail.sendKeys(validUser.getEmail());
        signUpPassword.sendKeys(validUser.getPassword());
        clickOn(marketingDescription);
        scrollToElement(signUpSubmitButton);
        retryingFindClick(signUpSubmitButton);
        DriverManager.getDriver().switchTo().parentFrame();
        DriverManager.explicitWait().until(ExpectedConditions.visibilityOf(userIconButton));
    }

    /**
     * Navigates to the watch page
     *
     * @return WatchPage Object
     * @author Felipe.Rivas
     */
    public WatchPage goToWatchPage(){
        clickOn(watchButton);
        return new WatchPage();
    }

    /**
     * Hovers over the user icon indefinitely
     *
     * @param validating status
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean hoverOverUserIcon(boolean validating){
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(userIconButton).perform();
        return validating;
    }

    /**
     * Retrieves the contents of the welcome text WebElement
     *
     * @return String
     * @author Felipe.Rivas
     */
    public String retrieveWelcomeMessage(){
        boolean validating = true;
        String text = "";

        DriverManager.explicitWait().until(ExpectedConditions.elementToBeClickable(userIconButton));
        while(hoverOverUserIcon(validating)){
            text = welcomeText.getText();
            validating = false;
        }
        return text;
    }

    /**
     * Logs out from the webpage
     *
     * @author Felipe.Rivas
     */
    public void logOut(){
        clickOn(userIconButton);
        clickOn(logoutButton);
        DriverManager.getDriver().navigate().refresh();
    }

    /**
     * Scrolls until element is found
     *
     * @param element to scroll to
     * @author Felipe.Rivas
     */
    public void scrollToElement(WebElement element){
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element);
        action.perform();
    }

    /**
     * Retries click on element 3 times
     *
     * @param element to click
     * @author Felipe.Rivas
     */
    public boolean retryingFindClick(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                clickOn(element);
                DriverManager.explicitWait().until(ExpectedConditions.invisibilityOf(loginIframe));
                result = true;
                break;
            } catch(TimeoutException e) {
            }
            attempts++;
        }
        return result;
    }
}
