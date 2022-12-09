package models.screenobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen() {}

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.view.View).description(\"Close Takeover\")")
    private AndroidElement dismissWelcome;

//    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.ImageView).descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.ImageView).descriptionContains(\"More\")")
    private AndroidElement moreOptionsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.ImageView).descriptionStartsWith(\"Buy\")")
    private AndroidElement addPlansButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Check Dining Availability\")")
    private AndroidElement dinnerReservationButton;

    /**
     * Method to skip the popups on app launch
     *
     * @author Hans.Marquez, Felipe.Rivas
     */
    public void skipWelcomeAndUpdates(){
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * @author Hans.Marquez
     * Navigate to Login Screen from DashBoard Screen.
     */
    public MapScreen goToMapScreen() {
        skipWelcomeAndUpdates();
        click(mapButton);
        return new MapScreen();
    }

    /**
     * Navigate to the more options screen from dashboard
     *
     * @return new instance of the more options screen
     * @author Felipe.Rivas
     */
    public MoreOptionsScreen goToMoreOptionsScreen() {
        skipWelcomeAndUpdates();
        click(moreOptionsButton);
        return new MoreOptionsScreen();
    }

    /**
     * Checks if the button Add Plans is displayed
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean addPlansIsDisplayed(){
        return isElementAvailable(addPlansButton);
    }

    /**
     * Clicks the addPlansButton
     *
     * @author Felipe.Rivas
     */
    public void clickAddPlansButton(){
        click(addPlansButton);
    }

    /**
     * Checks if the button to reserve dinner is available
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean dinnerReservationIsDisplayed(){
        return isElementAvailable(dinnerReservationButton);
    }

}
