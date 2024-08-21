package com.co.bonbonite.questions;

import com.co.bonbonite.userinterfaces.UserPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateRegister implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(UserPage.TXT_WELCOME_MESSAGE).answeredBy(actor);
    }

    public static ValidateRegister compare() {
        return new ValidateRegister();
    }
}
