package com.co.bonbonite.stepsdefinitions;

import com.co.bonbonite.questions.ValidateCar;
import com.co.bonbonite.questions.ValidateShoe;
import com.co.bonbonite.questions.ValidateShopCar;
import com.co.bonbonite.tasks.*;
import com.co.bonbonite.userinterfaces.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class PurchaseProductsStepDefinitions {
    @Given("the user clicks on handbag option")
    public void theUserClicksOnHandbagOption() {
        OnStage.theActorInTheSpotlight().attemptsTo(AcceptCookie.aceptCookie());
        OnStage.theActorInTheSpotlight().attemptsTo(ClickHangbagOption.clickMenuOption());
    }

    @When("the can see the option to select")
    public void theCanSeeTheOptionToSelect() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateShoe.shoeIsVisible(UserPage.LI_BAGS)));
    }

    @And("the user selects purchase button")
    public void theUserSelectsPurchaseButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddHandbagToShopCar.addFiveHandbags(HangbagPage.HANDBAG_PRODUCT, HangbagPage.BTN_PURCHASE));
    }

    @Then("the user can see the products on the shop car page")
    public void theUserCanSeeTheProductsOnTheShopCarPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeeShopCar.clickOn());
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateShopCar.tableOfProductsIsVisible(ShopCarPage.SHOP_CAR_PRODUCT)));
    }
}
