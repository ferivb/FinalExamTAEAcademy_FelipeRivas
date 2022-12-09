package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.pageobjects.HomePage;
import models.pageobjects.WatchPage;
import utils.Log;

import static com.google.common.truth.Truth.assertThat;

public class SingUpESPNStepDefinitions{

    @Given("An user just Singed up to the ESPN website")
    public void anUserJustSingedUpToWebsite() {
        Log.log.info("Validating if the Login Modal is complete");
        HomePage home = new HomePage();
        home.clickOnLogin();
        assertThat(home.loginModalIsPresent()).isTrue();

        Log.log.info("Validating if the sign up Modal is complete");
        home.clickOnSignUp();
        assertThat(home.signUpModalIsPresent()).isTrue();
        home.fillSingUpForm();
    }
    @Given("navigated to the Watch page")
    public void navigated_to_the_page() {
        Log.log.info("Navigating to the 'Watch' page");
        HomePage home = new HomePage();
        WatchPage watch = home.goToWatchPage();

        Log.log.info("Validating if the second carousel is complete");
        assertThat(watch.secondCarouselIsNotEmpty()).isTrue();

        Log.log.info("Validating if the second card from the first carousel works as designed");
        watch.clickOnCardByIndex(1);
        assertThat(watch.carouselCardHasCloseButton()).isTrue();
        watch.closeCard();
    }
    @When("The user goes back to the Home Page and hover over the user Icon")
    public void theUserGoesBackToTheHomePageAndHoverOverTheUserIcon() {
        Log.log.info("Navigating back Home");
        WatchPage watch = new WatchPage();
        HomePage home = watch.goBackHome();
    }
    @Then("they should see their name next to the Welcome text")
    public void theyShouldSeeTheirNameNextToTheWelcomeText() {
        Log.log.info("Validating if the user's Name is in the welcome Text");
        HomePage home = new HomePage();
        assertThat(home.retrieveWelcomeMessage()).contains("Test");
    }
    @And("After they log out they should no longer see their name there")
    public void afterTheyLogOutTheyShouldNoLongerSeeTheirNameThere() {
        Log.log.info("Validating the user's Name is no longer in the welcome Text");
        HomePage home = new HomePage();
        home.logOut();
        assertThat(home.retrieveWelcomeMessage()).endsWith("Welcome!");
    }
}
