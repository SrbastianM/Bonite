package com.co.bonbonite.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateBelt implements Question<Boolean> {
    private final Target belt;

    public ValidateBelt(Target belt) {
        this.belt = belt;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
       return belt.resolveFor(actor).isVisible();
    }

    public static ValidateBelt beltsAreVisible(Target product) {
        return new ValidateBelt(product);
    }
}
