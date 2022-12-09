package models.screenobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Privacy & Legal Screen
 *
 * @author Felipe.Rivas
 */
public class PrivacyAndLegalScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public PrivacyAndLegalScreen() {

    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Privacy & Legal\")")
    private AndroidElement titleText;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Privacy Policy\")")
    private AndroidElement privacyPolicy;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Terms of Use\")")
    private AndroidElement termsOfUse;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Supplemental\")")
    private AndroidElement supplemental;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Legal Notices\")")
    private AndroidElement legalNotices;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Property Rules\")")
    private AndroidElement propertyRules;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.TextView).textContains(\"Electronic\")")
    private AndroidElement electronicTOS;

    /**
     * Checks whether the title is displayed or not
     *
     * @return boolean: true if displayed, false if not
     * @author Felipe.Rivas
     */
    public boolean titleIsDisplayed(){
        return isElementAvailable(titleText);
    }

    /**
     * Checks whether the Privacy Policy option is displayed or not
     *
     * @return boolean: true if displayed, false if not
     * @author Felipe.Rivas
     */
    public boolean privacyPolicyIsDisplayed(){
        return isElementAvailable(privacyPolicy);
    }

    /**
     * Checks whether the Terms of Use option is displayed or not
     *
     * @return boolean: true if displayed, false if not
     * @author Felipe.Rivas
     */
    public boolean termsOfUseIsDisplayed(){
        return isElementAvailable(termsOfUse);
    }

    /**
     * Checks whether the Supplemental TOS option is displayed or not
     *
     * @return boolean: true if displayed, false if not
     * @author Felipe.Rivas
     */
    public boolean supplementalIsDisplayed(){
        return isElementAvailable(supplemental);
    }

    /**
     * Checks whether the Legal Notices option is displayed or not
     *
     * @return boolean: true if displayed, false if not
     * @author Felipe.Rivas
     */
    public boolean legalNoticesIsDisplayed(){
        return isElementAvailable(legalNotices);
    }

    /**
     * Checks whether the Property Rules option is displayed or not
     *
     * @return boolean: true if displayed, false if not
     * @author Felipe.Rivas
     */
    public boolean propertyRulesIsDisplayed(){
        return isElementAvailable(propertyRules);
    }

    /**
     * Checks whether the Electronic TOS option is displayed or not
     *
     * @return boolean: true if displayed, false if not
     * @author Felipe.Rivas
     */
    public boolean electronicTOSIsDisplayed(){
        return isElementAvailable(electronicTOS);
    }

    public boolean privacyAndLegalOptionsAreDisplayed(){
        return titleIsDisplayed() &&
                privacyPolicyIsDisplayed() &&
                termsOfUseIsDisplayed() &&
                supplementalIsDisplayed() &&
                legalNoticesIsDisplayed() &&
                propertyRulesIsDisplayed() &&
                electronicTOSIsDisplayed();
    }

}
