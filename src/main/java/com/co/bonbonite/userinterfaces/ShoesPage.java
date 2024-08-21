package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ShoesPage extends PageObject {
    //Select shoe show in screen
    public static final Target LI_SHOE = Target
            .the("click shoe option").locatedBy("//div[@class='product_list']/ul//li");

}
