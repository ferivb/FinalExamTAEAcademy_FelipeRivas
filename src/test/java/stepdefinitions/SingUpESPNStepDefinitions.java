package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.pageobjects.HomePage;
import models.pageobjects.WatchPage;

import static com.google.common.truth.Truth.assertThat;

public class SingUpESPNStepDefinitions {

    @Given("An user just Singed up to the ESPN website")
    public void anUserJustSingedUpToWebsite() {
        HomePage home = new HomePage();
        home.clickOnLogin();
        assertThat(home.loginModalIsPresent()).isTrue();
        home.clickOnSignUp();
        assertThat(home.signUpModalIsPresent()).isTrue();
        home.fillSingUpForm();

    }
    @Given("navigated to the Watch page")
    public void navigated_to_the_page() {
        HomePage home = new HomePage();
        WatchPage watch = home.goToWatchPage();
        assertThat(watch.secondCarouselIsNotEmpty()).isTrue();
        watch.clickOnCardByIndex(1);
        assertThat(watch.carouselCardHasCloseButton()).isTrue();
    }
    @When("The user goes back to the Home Page and hover over the user Icon")
    public void theUserGoesBackToTheHomePageAndHoverOverTheUserIcon() {

    }
    @Then("they should see their name next to the Welcome text")
    public void theyShouldSeeTheirNameNextToTheWelcomeText() {

    }
    @And("After they log out they should no longer see their name there")
    public void afterTheyLogOutTheyShouldNoLongerSeeTheirNameThere() {

    }

}
