package com.co.bonbonite.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static javax.accessibility.AccessibleState.VISIBLE;

public class WaitElementz implements Interaction {
    private Target target;
    private WaitCondition state;
    private Long timeout;

    public WaitElementz(Target target, WaitCondition state, Long timeout) {
        this.target = target;
        this.state = state;
        this.timeout = timeout;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        By locator =  convertToBy(target.getCssOrXPathSelector());

        switch (state) {
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case INVISIBLE:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                break;
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case PRESENT:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            case NOT_PRESENT:
                wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
                break;
        }

    }

    // Method who convert String to By
    private By convertToBy(String selector) {
        if (selector.startsWith("/")) {
            // if the selector starts with "/"
            return By.xpath(selector);
        } else {
            // if not we assume the element is a css
            return By.cssSelector(selector);
        }
    }


    @Override
    public Performable then(Performable nextPerformable) {
        return Interaction.super.then(nextPerformable);
    }

    public static WaitElementz until(Target target, WaitCondition condition, long timeout) {
        return new WaitElementz(target, condition, timeout);
    }

    public enum WaitCondition {
        VISIBLE,
        INVISIBLE,
        CLICKABLE,
        PRESENT,
        NOT_PRESENT
    }
}
