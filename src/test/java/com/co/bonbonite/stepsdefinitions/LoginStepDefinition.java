package com.co.bonbonite.stepsdefinitions;

import com.co.bonbonite.models.Credentials;
import com.co.bonbonite.questions.ValidateRegister;
import com.co.bonbonite.tasks.Home;
import com.co.bonbonite.tasks.Login;
import com.co.bonbonite.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginStepDefinition {
    @Managed(driver = "firefox")
    WebDriver browser;


    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Sebastian");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();
    }

    @Given("the user can see home page")
    public void theUserCanSeeHomePage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.bon-bonite.com"));
    }

    @And("the user selects the person icon")
    public void theUserSelectsThePersoneIcon() {
        OnStage.theActorInTheSpotlight().attemptsTo(Home.click());
    }

    @When("the user enter de credentials on the register form")
    public void theUserEnterDeCredentialsOnTheRegisterForm(List<Credentials> credentialsList) {
        Credentials credentials;
        credentials = credentialsList.getFirst();
        OnStage.theActorInTheSpotlight().attemptsTo(Login.enter(credentials));
    }

    @Then("the user can see the welcome message")
    public void theUserCanSee() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateRegister.compare(),
                Matchers.is(Constants.VALIDATE_USER_MESSAGE)
                ));
    }
}
