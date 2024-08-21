package com.co.bonbonite.tasks;

import com.co.bonbonite.interactions.WaitElement;
import com.co.bonbonite.utils.Constants;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CheckUserRegister implements Task {
    private final Target successMessage;

    public CheckUserRegister(Target successMessage) {
        this.successMessage = successMessage;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitElement.untilAppears(successMessage).performAs(actor);
        WebElementFacade element = successMessage.resolveFor(actor);
        String messageText = element.getText();
        boolean isRegistered = Constants.ALERT_REGISTER.equals(messageText);
        actor.remember("isRegistered", isRegistered);
    }

    public static CheckUserRegister check(Target succesMessage) {
        return instrumented(CheckUserRegister.class, succesMessage);
    }
}
