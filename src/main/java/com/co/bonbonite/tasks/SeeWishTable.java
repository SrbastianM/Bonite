package com.co.bonbonite.tasks;

import com.co.bonbonite.interactions.WaitElement;
import com.co.bonbonite.userinterfaces.ShopCarPage;
import com.co.bonbonite.userinterfaces.UserPage;
import com.co.bonbonite.userinterfaces.WishListPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeeWishTable implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ShopCarPage.BTN_USER_ACCOUNT));
        try {
            Thread.sleep(2000);
            actor.attemptsTo(Click.on(UserPage.LI_WISH_LIST));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(WaitElement.untilAppears(WishListPage.TBL_WISH));
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }
    public static SeeWishTable clickOn() {
        return new SeeWishTable();
    }
}
