package com.co.bonbonite.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BeltPage extends PageObject {

    public static final Target BTN_SIZE = Target
            .the("select belt size").locatedBy("//div[@class='sizes_options']//div[contains(@class,'size')]//div[@class='size_select']");

    public static final Target SELECT_SIZE = Target.the("select size").locatedBy("//select[contains(@name,'talla')]");

    public static final Target BTN_PURCHASE = Target
            .the("click purchase button").locatedBy("//a[contains(@class,'buy_now_link')]");

    public static final Target PRODUCTS = Target.the("select the product carsd").locatedBy("//div[@class='product_list']/ul//li");
}
