package com.co.bonbonite.tasks;

import com.co.bonbonite.models.Credentials;
import com.co.bonbonite.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {
    Credentials credentials;

    public Login(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credentials.getUsername()).into(LoginPage.TXT_USERNAME));
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PASSWORD));
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static Login enter(Credentials credentials) {
        return Tasks.instrumented(Login.class, credentials);
    }
}
