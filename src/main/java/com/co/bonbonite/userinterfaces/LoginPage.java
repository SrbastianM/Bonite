package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;



public class LoginPage extends PageObject {
    // Login Section
    public static final Target TXT_USERNAME_LOGIN = Target
            .the("enter username into login field").locatedBy("//input[contains(@id,'username')]");
    public static final Target TXT_PASSWORD_LOGIN = Target
            .the("enter password into login field").locatedBy("//input[@id='password']");
    public static final Target BTN_LOGIN = Target
            .the("select button login").locatedBy("//button[@type='submit'][contains(.,'Acceso')]");

    // Register Section
    public static final Target TXT_USERNAME = Target
            .the("enter username").locatedBy("//input[contains(@id,'reg_username')]");

    public static final Target TXT_PASSWORD = Target
            .the("enter password").locatedBy("//input[contains(@autocomplete,'new-password')]");

    public static final Target TXT_EMAIL = Target
            .the("enter email").locatedBy("//input[@type='email'][contains(@id,'email')]");

    public static final Target BTN_REGISTER = Target
            .the("select register").locatedBy("//button[@type='submit'][contains(.,'Registrarse')]");

    public static final Target BTN_CHECK = Target
            .the("click button policies").locatedBy("//input[@type='checkbox'][contains(@id,'reg')]");
}
