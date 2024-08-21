package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ShopCarPage extends PageObject {
    public static final Target SHOP_CAR_PRODUCT = Target
            .the("Products are visible").locatedBy("//th[@class='product-name'][contains(.,'Producto')]");

    public static final Target BTN_SHOP_CAR = Target
            .the("click on car icon").locatedBy("//div[@class='cart']");

    public static final Target  BTN_USER_ACCOUNT = Target.the("click on user icon").locatedBy("//div[@class='myaccount']");

}
