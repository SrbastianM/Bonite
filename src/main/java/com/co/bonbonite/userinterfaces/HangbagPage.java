package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HangbagPage extends PageObject {
    public static final Target HANDBAG_PRODUCT = Target.the("select handbag product").locatedBy("//div[@class='product_list']/ul//li");
    public static final Target BTN_PURCHASE = Target
            .the("click purchase button").locatedBy("//div[@class='actions_bar']//div[@class='buy_button']//a[@class='button simple_product add_to_cart_button ajax_add_to_cart'][contains(text(),'Comprar')]");
}
