package com.co.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;



public class UserPage extends PageObject {
    public static Target TXT_WELCOME_MESSAGE = Target
            .the("welcome message")
            .locatedBy("//p[contains(.,'Desde el escritorio de tu cuenta puedes ver tus pedidos recientes, gestionar tus direcciones de envío y facturación y editar tu contraseña y los detalles de tu cuenta.')]");

    public static final Target LI_SHOES = Target
            .the("click the shoes option").locatedBy("//li[@id='menu-item-10']");
    public static final Target LI_BAGS = Target
            .the("click the bag option").locatedBy("//li[@id='menu-item-8']");
    public static final Target LI_BELT = Target
            .the("click the belt option").locatedBy("//li[@id='menu-item-9']//a[contains(text(),'Cinturones')]");
    public static final Target LI_ACCESSORIES = Target
            .the("click the accessories option").locatedBy("//li[@id='menu-item-7']//a[contains(text(),'Accesorios')]");

    public static final Target LI_WISH_LIST = Target
            .the("Select wish list option").locatedBy("//a[contains(.,'Lista de deseos')]");
}
