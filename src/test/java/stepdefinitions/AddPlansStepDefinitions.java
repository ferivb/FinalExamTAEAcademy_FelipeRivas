package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.screenobjects.DashBoardScreen;
import models.screenobjects.TutorialScreen;
import utils.Log;

import static com.google.common.truth.Truth.assertThat;

public class AddPlansStepDefinitions {
    @Given("An user is in the Dashboard")
    public void anUserIsInTheDashboard() {
        Log.log.info("Navigating to the Dashboard Screen");
        TutorialScreen tutorial = new TutorialScreen();
        tutorial.startPermissionsProcess();
        DashBoardScreen dashboard = tutorial.shareLocationPermissions();
        dashboard.skipWelcomeAndUpdates();
    }
    @When("The user taps on the plans button")
    public void theUserTapsOnThePlansButton() {
        Log.log.info("Validating the Add Plans option is present");
        DashBoardScreen dashboard = new DashBoardScreen();
        assertThat(dashboard.addPlansIsDisplayed()).isTrue();

        Log.log.info("Tapping on the Add Plans button");
        dashboard.clickAddPlansButton();
    }
    @Then("they should see the Check Dining Availability option")
    public void theyShouldSeeTheCheckDiningAvailabilityOption() {
        Log.log.info("Validating the Diner Reservation option is present");
        DashBoardScreen dashboard = new DashBoardScreen();
        assertThat(dashboard.dinnerReservationIsDisplayed()).isTrue();
    }
}
