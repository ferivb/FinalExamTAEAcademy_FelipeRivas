package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.screenobjects.DashBoardScreen;
import models.screenobjects.MapScreen;
import models.screenobjects.TutorialScreen;
import utils.Log;

import static com.google.common.truth.Truth.assertThat;

public class MapCategoryListStepDefinitions {
    @Given("An user navigated to the map tab")
    public void anUserNavigatedToTheMapTab() {
        Log.log.info("Navigating to the Dashboard Screen");
        TutorialScreen tutorial = new TutorialScreen();
        tutorial.startPermissionsProcess();
        DashBoardScreen dashboard = tutorial.shareLocationPermissions();

        Log.log.info("Navigating to the Map Screen");
        MapScreen map = dashboard.goToMapScreen();

        Log.log.info("Validating if Map Screen is correctly displayed");
        assertThat(map.mapScreenIsDisplayed()).isTrue();
    }
    @When("The user taps on the category list")
    public void theUserTapsOnTheCategoryList() {
        Log.log.info("Validating that all categories are different");
        MapScreen map = new MapScreen();
        map.tapOnCategories();
        assertThat(map.areCategoriesDifferent()).isTrue();
    }
    @Then("they should see the book a hotel option enabled")
    public void theyShouldSeeTheBookAHotelOptionEnabled() {
        Log.log.info("Validating that the Hotel Option is enabled");
        MapScreen map = new MapScreen();
        assertThat(map.hotelsIsDisplayed()).isTrue();
    }
}
