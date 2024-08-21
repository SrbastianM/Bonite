package com.co.bonbonite.stepsdefinitions;

import com.co.bonbonite.exeptions.MessageException;
import com.co.bonbonite.models.Credentials;
import com.co.bonbonite.questions.ValidateRegister;
import com.co.bonbonite.tasks.CheckUserRegister;
import com.co.bonbonite.tasks.Home;
import com.co.bonbonite.tasks.Login;
import com.co.bonbonite.tasks.Register;
import com.co.bonbonite.userinterfaces.UserPage;
import com.co.bonbonite.utils.Constants;
import com.co.bonbonite.utils.Url;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class LoginStepDefinition {
    @Managed(driver = "firefox")
    WebDriver browser;
    Credentials credentials;


    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Sebastian");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();
    }

    @Given("the user can see home page")
    public void theUserCanSeeHomePage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(Url.URL));
    }

    @And("the user selects the person icon")
    public void theUserSelectsThePersoneIcon() {
        OnStage.theActorInTheSpotlight().attemptsTo(Home.click());
    }

    @When("the user enter de credentials on the register form")
    public void theUserEnterDeCredentialsOnTheRegisterForm(DataTable dataTable) {
        List<Map<String, String>> credentialsList = dataTable.asMaps(String.class, String.class);
            credentials = new Credentials(
                    credentialsList.getFirst().get("username"),
                    credentialsList.getFirst().get("email"),
                    credentialsList.getFirst().get("password")
            );
            OnStage.theActorInTheSpotlight().attemptsTo(Register.enter(credentials));
            OnStage.theActorInTheSpotlight().attemptsTo(CheckUserRegister.check(Constants.ALERT_USER_IS_REGISTER));
            Boolean isRegistered = OnStage.theActorInTheSpotlight().recall("isRegistered");
            if(isRegistered != null) {
                OnStage.theActorInTheSpotlight().attemptsTo(Login.enter(credentials));
            }
    }

    @Then("the user can see the welcome message")
    public void theUserCanSeeTheWelcomeMessage() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateRegister.compare()));
    }
}
