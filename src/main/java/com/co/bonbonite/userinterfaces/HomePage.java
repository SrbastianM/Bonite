package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
    public static final Target BTN_USER = Target
            .the("click the icon").locatedBy("//div[@class='myaccount']");
    public static final Target COOKIE_ALERT  = Target
            .the("accept cookies").locatedBy("//div[@data-cs-i18n-text='{\"es\":\"Aceptar todo\"}']");
}
