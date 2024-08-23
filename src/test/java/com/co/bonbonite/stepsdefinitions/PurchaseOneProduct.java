package com.co.bonbonite.stepsdefinitions;

import com.co.bonbonite.questions.ValidateBelt;
import com.co.bonbonite.questions.ValidateCar;
import com.co.bonbonite.questions.ValidateShoe;
import com.co.bonbonite.questions.ValidateShopCar;
import com.co.bonbonite.tasks.AcceptCookie;
import com.co.bonbonite.tasks.ClickBeltOption;
import com.co.bonbonite.tasks.ClickHangbagOption;
import com.co.bonbonite.tasks.PurchaseOneBelt;
import com.co.bonbonite.userinterfaces.BeltPage;
import com.co.bonbonite.userinterfaces.ShopCarPage;
import com.co.bonbonite.userinterfaces.UserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class PurchaseOneProduct {
    @Given("the user clicks on belt option")
    public void theUserClicksOnBeltOption() {
        OnStage.theActorInTheSpotlight().attemptsTo(AcceptCookie.aceptCookie());
        OnStage.theActorInTheSpotlight().attemptsTo(ClickBeltOption.clickBeltOption());
    }

    @When("the user can see the option to select")
    public void theUserCanSeeTheOptionToSelect() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateBelt.beltsAreVisible(UserPage.LI_BAGS)));
    }

    @And("the user selects options to purchase and select purchase button")
    public void theUserSelectsOptionsToPurchaseAndSelectPurchaseButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(PurchaseOneBelt.addOneBeltToCarShop(BeltPage.PRODUCTS, BeltPage.BTN_SIZE));
    }

    @Then("the user can see the product on car page")
    public void theUserCanSeeTheProductOnCarPage() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateShopCar.tableOfProductsIsVisible(ShopCarPage.SHOP_CAR_PRODUCT)));
    }
}
