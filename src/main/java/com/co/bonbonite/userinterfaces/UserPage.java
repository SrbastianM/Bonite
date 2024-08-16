package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;



public class UserPage extends PageObject {
    public static Target TXT_WELCOME_MESSAGE = Target
            .the("welcome message").locatedBy("//a[contains(.,'editar tu contraseña y los detalles de tu cuenta')]");
}
