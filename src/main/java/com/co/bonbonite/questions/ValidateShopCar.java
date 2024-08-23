package com.co.bonbonite.questions;

import com.co.bonbonite.interactions.WaitElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateShopCar implements Question<Boolean> {
    private Target shopProducts;

    public ValidateShopCar(Target shopProducts) {
        this.shopProducts = shopProducts;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitElement.untilBeEnable(shopProducts));
        return shopProducts.resolveFor(actor).isVisible();
    }

    public static ValidateShopCar tableOfProductsIsVisible(Target shoe) {
        return new ValidateShopCar(shoe);
    }
}
