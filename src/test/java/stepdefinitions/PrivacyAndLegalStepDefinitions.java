package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.screenobjects.DashBoardScreen;
import models.screenobjects.MoreOptionsScreen;
import models.screenobjects.PrivacyAndLegalScreen;
import models.screenobjects.TutorialScreen;
import utils.Log;

import static com.google.common.truth.Truth.assertThat;

public class PrivacyAndLegalStepDefinitions {

    /**
     * Skips the tutorial and goes directly to the dashboard screen
     * asserts the presence of the more options button
     * clicks on the more options button
     *
     * @author Felipe.Rivas
     */
    @Given("An user navigated to the more options tab")
    public void an_user_navigated_to_the_more_options_tab() {
        Log.log.info("Navigating to the Dashboard Screen");
        TutorialScreen tutorial = new TutorialScreen();
        tutorial.startPermissionsProcess();
        DashBoardScreen dashboard = tutorial.shareLocationPermissions();

        Log.log.info("Navigating to the More Options Screen");
        MoreOptionsScreen more = dashboard.goToMoreOptionsScreen();
        assertThat(more.moreOptionsScreenIsDisplayed()).isTrue();
    }

    /**
     * Scrolls down to the bottom of the screen
     * asserts that all categories are unique
     *
     * @author Felipe.Rivas
     */
    @When("The user swipes down to the bottom")
    public void the_user_swipes_down_to_the_bottom() {
        Log.log.info("Scrolling to the Privacy & Legal button");
        MoreOptionsScreen more = new MoreOptionsScreen();
        more.swipeToPrivacyAndLegal();

        Log.log.info("Validating that all categories are unique");
        assertThat(more.areCategoriesDifferent()).isTrue();
    }

    /**
     * Navigates to the privacy and legal screen
     *
     * @author Felipe.Rivas
     */
    @And("tap on the Privacy & Legal button")
    public void tapOnThePrivacyLegalButton() {
        Log.log.info("Navigating to the Privacy & Legal Screen");
        MoreOptionsScreen more = new MoreOptionsScreen();
        more.goToPrivacyAndLegalScreen();
    }

    /**
     * Asserts that all options from legal are present.
     *
     * @author Felipe.Rivas
     */
    @Then("they should see all the privacy and legal options displayed")
    public void they_should_see_all_the_privacy_and_legal_options_displayed() {
        Log.log.info("Validating that all Privacy & Legal options are present");
        PrivacyAndLegalScreen privacy = new PrivacyAndLegalScreen();
        assertThat(privacy.privacyAndLegalOptionsAreDisplayed()).isTrue();
    }
}
