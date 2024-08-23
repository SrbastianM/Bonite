package com.co.bonbonite.tasks;

import com.co.bonbonite.interactions.WaitElement;
import com.co.bonbonite.userinterfaces.BeltPage;
import com.co.bonbonite.userinterfaces.HangbagPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PurchaseOneBelt implements Task {
    private final Target belt;
    private final Target size;

    public PurchaseOneBelt(Target belt, Target size) {
        this.belt = belt;
        this.size = size;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ListOfWebElementFacades beltList = belt.resolveAllFor(actor);
        ListOfWebElementFacades sizeList = size.resolveAllFor(actor);


        Collections.shuffle(beltList);
        Collections.shuffle(sizeList);

        Optional<WebElementFacade> randomSize = beltList.stream().findFirst();
        Optional<WebElementFacade> randomBelt = beltList.stream().findFirst();

        if (randomBelt.isPresent()) {
            WebElementFacade beltProduct = randomBelt.get();

            actor.attemptsTo(
                    Scroll.to(beltProduct),
                    MoveMouse.to(beltProduct)
            );
            try {
                Thread.sleep(2000);
                WebElementFacade beltSize = randomSize.get();
                actor.attemptsTo(Click.on(beltSize));
                Thread.sleep(2000);
                actor.attemptsTo(SelectFromOptions.byIndex(2).from(BeltPage.SELECT_SIZE));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            actor.attemptsTo(
                    Click.on(BeltPage.BTN_PURCHASE)
            );
        }
    }


    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static PurchaseOneBelt addOneBeltToCarShop(Target belt, Target size) {
        return instrumented(PurchaseOneBelt.class, belt, size);
    }

}
