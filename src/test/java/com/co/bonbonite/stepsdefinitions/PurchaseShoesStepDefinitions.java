package com.co.bonbonite.stepsdefinitions;

import com.co.bonbonite.questions.ValidateCar;
import com.co.bonbonite.questions.ValidateShoe;
import com.co.bonbonite.tasks.PurchaseShoes;
import com.co.bonbonite.tasks.Shoes;
import com.co.bonbonite.tasks.ShopCar;
import com.co.bonbonite.userinterfaces.ShoesPage;
import com.co.bonbonite.userinterfaces.ShopCarPage;
import com.co.bonbonite.userinterfaces.UserPage;
import com.co.bonbonite.userinterfaces.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

public class PurchaseShoesStepDefinitions {
    @Given("the user clicks on the shoes option")
    public void theUserClicksOnTheShoesOption() {
        OnStage.theActorInTheSpotlight().attemptsTo(Shoes.clickOnShoeOption());
    }
    @And("the user can see the options to select")
    public void theUserCanSeeTheOptionsToSelect() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateShoe.shoeIsVisible(UserPage.LI_SHOES)));
    }

    @When("the user selects add to shop car button")
    public void theUserSelectsAddToShopCarButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(PurchaseShoes.onAllShoes(ShoesPage.LI_SHOE, ShoesPage.BTN_WHISH_LIST));
    }

    @Then("the user can see the products on the shop car page")
    public void theUserCanSeeTheProductsOnTheShopCarPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(ShopCar.clickOn());
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCar.productsAreVisible(WishListPage.TBL_WISH)));
    }
}
