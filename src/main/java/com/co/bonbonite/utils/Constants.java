package com.co.bonbonite.utils;

import net.serenitybdd.screenplay.targets.Target;

public class Constants {

    public static final Target VALIDATE_USER_MESSAGE = Target
            .the("user is login on the web page").locatedBy("//p[contains(.,'Desde el escritorio de tu cuenta puedes ver tus pedidos recientes, gestionar tus direcciones de envío y facturación y editar tu contraseña y los detalles de tu cuenta.')]");
    public static final Target ALERT_USER_IS_REGISTER = Target.the("user is registered on the web page").locatedBy("//div[@class='woocommerce-notices-wrapper']");
    public static final String ALERT_REGISTER = "Error: Ya hay una cuenta registrada con tu dirección de correo electrónico";
}
