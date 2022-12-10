package models.screenobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;


/**
 * More options Screen
 *
 * @author Felipe.Rivas
 */
public class MoreOptionsScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @author Arley.Bolivar, Hans.Marquez
     */
    public MoreOptionsScreen() {

    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Tickets\")")
    private AndroidElement ticketsAndPasses;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"MagicBand\")")
    private AndroidElement magicBand;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Board\")")
    private AndroidElement board;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Privacy\")")
    private AndroidElement privacyAndLegalButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\")")
    private List<AndroidElement> categories;

    /**
     * Checks whether the tickets and passes option is present or not
     *
     * @return boolean: true if present false if not
     * @author Felipe.Rivas
     */
    public boolean ticketsAndPassesIsDisplayed(){
        return isElementAvailable(ticketsAndPasses);
    }

    /**
     * Validates if AndroidElement is present.
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean magicBandIsDisplayed(){
        return isElementAvailable(magicBand);
    }

    /**
     * Validates if AndroidElement is present.
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean tipBoardIsDisplayed(){
        return isElementAvailable(board);
    }

    /**
     * Validates if the More options screen contains all elements.
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean moreOptionsScreenIsDisplayed(){
        return ticketsAndPassesIsDisplayed() &&
                magicBandIsDisplayed() &&
                tipBoardIsDisplayed();
    }

    /**
     * Checks whether all items in the categories are unique
     *
     * @return boolean: true if all are unique, false if duplicates are found
     * @author Felipe.Rivas
     */
    public boolean areCategoriesDifferent(){
        List<String> trimmedCategories = new ArrayList<>();
        for (AndroidElement i: categories) {
            String category = i.getText();
            trimmedCategories.add(category);
        }
        return trimmedCategories.stream().distinct().count() == trimmedCategories.size();
    }

    /**
     * Checks whether the button for Privacy and Legal is present
     *
     * @return boolean: true if it is present, false if not
     * @author Felipe.Rivas
     */
    public boolean isPrivacyAndLegalDisplayed(){
        return isElementAvailable(privacyAndLegalButton);
    }

    /**
     * Swipes vertically downwards until the Privacy and legal option is found
     *
     * @author Felipe.Rivas
     */
    public void swipeToPrivacyAndLegal(){
        do {
            swipeDown();
        } while(!isPrivacyAndLegalDisplayed());
    }

    /**
     * Navigates to the PrivacyAndLegalScreen
     *
     * @return new instance of class PrivacyAndLegal
     * @author Felipe.Rivas
     */
    public PrivacyAndLegalScreen goToPrivacyAndLegalScreen(){
        click(privacyAndLegalButton);
        return new PrivacyAndLegalScreen();
    }


}
