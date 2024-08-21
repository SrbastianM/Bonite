package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class WishListPage extends PageObject {
    public static final Target TBL_WISH = Target
            .the("see wish list").locatedBy("//span[@class='tinvwl-full'][contains(.,'Nombre de producto')]");
}
