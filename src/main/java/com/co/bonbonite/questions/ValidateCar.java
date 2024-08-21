package com.co.bonbonite.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateCar implements Question<Boolean> {
    private final Target product;

    public ValidateCar(Target product) {
        this.product = product;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return product.resolveFor(actor).isVisible();
    }

    public static ValidateCar productsAreVisible(Target product) {
        return new ValidateCar(product);
    }
}
