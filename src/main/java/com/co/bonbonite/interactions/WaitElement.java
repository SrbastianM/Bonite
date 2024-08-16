package com.co.bonbonite.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

public class WaitElement implements Interaction {
    private Target target;
    private String state;

    public WaitElement(Target target, String state) {
        this.target = target;
        this.state = state;
    }

    @Override
    public <T extends Actor> void performAs(T t) {

    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Interaction.super.then(nextPerformable);
    }
}
