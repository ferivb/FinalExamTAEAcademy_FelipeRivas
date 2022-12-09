package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.screenobjects.DashBoardScreen;
import models.screenobjects.TutorialScreen;

public class MapCategoryListStepDefinitions {
    @Given("An user navigated to the map tab")
    public void anUserNavigatedToTheMapTab() {
        TutorialScreen tutorial = new TutorialScreen();
        tutorial.startPermissionsProcess();
        DashBoardScreen dashboard = tutorial.shareLocationPermissions();
    }
    @When("The user taps on the category list")
    public void theUserTapsOnTheCategoryList() {

    }
    @Then("they should see the book a hotel option enabled")
    public void theyShouldSeeTheBookAHotelOptionEnabled() {

    }
}
