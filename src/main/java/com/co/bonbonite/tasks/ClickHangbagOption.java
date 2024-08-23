package com.co.bonbonite.tasks;

import com.co.bonbonite.interactions.WaitElement;
import com.co.bonbonite.userinterfaces.HomePage;
import com.co.bonbonite.userinterfaces.UserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ClickHangbagOption implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElement.untilBeEnable(UserPage.LI_BAGS));
        try {
            Thread.sleep(2000);
            actor.attemptsTo(Click.on(UserPage.LI_BAGS));
            actor.attemptsTo(WaitElement.untilAppears(UserPage.LI_BAGS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static ClickHangbagOption clickMenuOption() {
        return new ClickHangbagOption();
    }
}
