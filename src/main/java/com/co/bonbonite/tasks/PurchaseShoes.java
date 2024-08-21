package com.co.bonbonite.tasks;

import com.co.bonbonite.userinterfaces.ShoesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.mockito.internal.matchers.Find;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchaseShoes implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        
        List<WebElement> shoeItems = actor.asksFor();
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }
}
