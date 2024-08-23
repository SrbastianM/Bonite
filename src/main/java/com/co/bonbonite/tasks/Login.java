package com.co.bonbonite.tasks;

import com.co.bonbonite.interactions.WaitElement;
import com.co.bonbonite.models.Credentials;
import com.co.bonbonite.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login implements Task {
    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    Credentials credentials;

    public Login(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credentials.getUsername()).into(LoginPage.TXT_USERNAME_LOGIN));
        actor.attemptsTo(WaitElement.untilAppears(LoginPage.TXT_PASSWORD_LOGIN));
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PASSWORD_LOGIN));
        actor.attemptsTo(WaitElement.untilBeEnable(LoginPage.BTN_LOGIN));
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static Login enter(Credentials credentials) {
        return Tasks.instrumented(Login.class, credentials);
    }
}
