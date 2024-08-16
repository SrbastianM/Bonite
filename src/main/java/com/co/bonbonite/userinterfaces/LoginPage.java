package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;



public class LoginPage extends PageObject {
    public static final Target TXT_USERNAME = Target
            .the("enter username").locatedBy("");

    public static final Target TXT_PASSWORD = Target
            .the("enter password").locatedBy("");
}
