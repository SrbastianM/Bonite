package com.co.bonbonite.tasks;

import com.co.bonbonite.interactions.WaitElement;
import com.co.bonbonite.userinterfaces.ShoesPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Uninstrumented;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class PurchaseShoes implements Task {
    private final Target shoeItems;
    private final Target addToWishListButton;

    public PurchaseShoes(Target shoeItems, Target addToWishListButton) {
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
                actor.attemptsTo(Click.on(btnWishList));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static PurchaseShoes onAllShoes(Target shoeItems, Target addToWishListButton)  {
        return instrumented(PurchaseShoes.class, shoeItems, addToWishListButton);
    }
}
