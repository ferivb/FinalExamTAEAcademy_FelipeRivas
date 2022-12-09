package models.screenobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;

import java.util.ArrayList;
import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

// TODO: Auto-generated Javadoc

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen() {}

//    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/categoryTitle\")")
    private AndroidElement categoryList;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\").descriptionMatches(\".*button\")")
    private List<AndroidElement> categories;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.LinearLayout).descriptionStartsWith(\"Hotels\")")
    private AndroidElement hotelsCategory;


    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * @author Hans.Marquez
     * return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * @author Hans.Marquez
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * Taps on the categories button
     *
     * @author Felipe.Rivas
     */
    public void tapOnCategories(){
        click(categoryList);
    }

    /**
     * Checks all the categories to see if every one is unique
     *
     * @return true if all categories are unique or false if there is duplicates
     * @author Felipe.Rivas
     */
    public boolean areCategoriesDifferent(){
        List<String> trimmedCategories = new ArrayList<>();
        for (AndroidElement i: categories) {
            String category = i.getAttribute("content-desc").split(",")[0];
            trimmedCategories.add(category);
        }
        return trimmedCategories.stream().distinct().count() == trimmedCategories.size();
    }

    /**
     * Checks if the button for Hotels is present
     *
     * @return boolean
     * @author Felipe.Rivas
     */
    public boolean hotelsIsDisplayed() {
        return isElementAvailable(hotelsCategory);
    }

        /**
     * Retrieves the name of the category by default
     *
     * @return String: the text with the default category
     * @author Felipe.Rivas
     */
    public String getDefaultCategoryText(){
        return categoryList.getText();
    }

}
