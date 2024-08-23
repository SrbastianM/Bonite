package com.co.bonbonite.tasks;

import com.co.bonbonite.userinterfaces.ShoesPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Collections;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AddShoesToWishList implements Task {
    private final Target shoeItems;
    private final Target addToWishListButton;

    public AddShoesToWishList(Target shoeItems, Target addToWishListButton) {
        this.shoeItems = shoeItems;
        this.addToWishListButton = addToWishListButton;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        ListOfWebElementFacades shoes = shoeItems.resolveAllFor(actor);

        Collections.shuffle(shoes);
        List<WebElementFacade> randomItems = shoes.subList(0, Math.min(3, shoes.size()));

        for (WebElementFacade shoe : randomItems) {
            actor.attemptsTo(Scroll.to(shoe));
            actor.attemptsTo(MoveMouse.to(shoe));
            Target btnWishList = ShoesPage.BTN_WHISH_LIST;
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

    public static AddShoesToWishList onAllShoes(Target shoeItems, Target addToWishListButton)  {
        return instrumented(AddShoesToWishList.class, shoeItems, addToWishListButton);
    }
}
