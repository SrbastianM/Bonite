package com.co.bonbonite.tasks;

import com.co.bonbonite.userinterfaces.HangbagPage;
import com.co.bonbonite.userinterfaces.ShoesPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Collections;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddHandbagToShopCar implements Task {
    private final Target handbag;
    private final Target addToShopCar;

    public AddHandbagToShopCar(Target handbag, Target addToShopCar) {
        this.handbag = handbag;
        this.addToShopCar = addToShopCar;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ListOfWebElementFacades shoes = handbag.resolveAllFor(actor);

        Collections.shuffle(shoes);
        List<WebElementFacade> randomItems = shoes.subList(0, Math.min(5, shoes.size()));

        for (WebElementFacade shoe : randomItems) {
            actor.attemptsTo(Scroll.to(shoe));
            actor.attemptsTo(MoveMouse.to(shoe));
            Target btnWishList = HangbagPage.BTN_PURCHASE;
            try {
                Thread.sleep(2000);
                actor.wasAbleTo(Click.on(btnWishList));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static AddHandbagToShopCar addFiveHandbags(Target shoeItems, Target addToWishListButton)  {
        return instrumented(AddHandbagToShopCar.class, shoeItems, addToWishListButton);
    }
}
