package com.co.bonbonite.tasks;

import com.co.bonbonite.interactions.WaitElement;
import com.co.bonbonite.userinterfaces.UserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickShoesOption implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElement.untilAppears(UserPage.LI_SHOES));
        actor.attemptsTo(Click.on(UserPage.LI_SHOES));
        actor.attemptsTo(WaitElement.untilAppears(UserPage.LI_SHOES));
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static ClickShoesOption clickOnShoeOption() {
        return Tasks.instrumented(ClickShoesOption.class);
    }
}
