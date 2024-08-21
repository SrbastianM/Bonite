package com.co.bonbonite.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateShoe implements Question<Boolean> {
    private Target shoe;

    public ValidateShoe(Target shoe) {
        this.shoe = shoe;
    }

    @Override

    public Boolean answeredBy(Actor actor) {
        return shoe.resolveFor(actor).isVisible();
    }
    public static ValidateShoe shoeIsVisible(Target shoe) {
        return new ValidateShoe(shoe);
    }
}
