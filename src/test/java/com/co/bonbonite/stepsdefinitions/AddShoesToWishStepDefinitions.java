package com.co.bonbonite.stepsdefinitions;

import com.co.bonbonite.questions.ValidateCar;
import com.co.bonbonite.questions.ValidateShoe;
import com.co.bonbonite.tasks.AcceptCookie;
import com.co.bonbonite.tasks.AddShoesToWishList;
import com.co.bonbonite.tasks.ClickShoesOption;
import com.co.bonbonite.tasks.SeeWishTable;
import com.co.bonbonite.userinterfaces.ShoesPage;
import com.co.bonbonite.userinterfaces.UserPage;
import com.co.bonbonite.userinterfaces.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class AddShoesToWishStepDefinitions {
    @Given("the user clicks on the shoes option")
    public void theUserClicksOnTheShoesOption() {
        OnStage.theActorInTheSpotlight().attemptsTo(AcceptCookie.aceptCookie());
        OnStage.theActorInTheSpotlight().attemptsTo(ClickShoesOption.clickOnShoeOption());
    }
    @And("the user can see the options to select")
    public void theUserCanSeeTheOptionsToSelect() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateShoe.shoeIsVisible(UserPage.LI_SHOES)));
    }

    @When("the user selects add to shop car button")
    public void theUserSelectsAddToShopCarButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddShoesToWishList.onAllShoes(ShoesPage.LI_PRODUCT, ShoesPage.BTN_WHISH_LIST));
    }

    @Then("the user can see the products on the whish list page")
    public void theUserCanSeeTheProductsOnTheWhishListPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeeWishTable.clickOn());
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCar.productsAreVisible(WishListPage.TBL_WISH)));
    }
}
