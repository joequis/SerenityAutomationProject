package com.example.automation.interactions;

import com.example.automation.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EnterCredential implements Interaction {

    //Parámetros
    private final String value;
    private final Target element;

    //Constructor
    public EnterCredential(Target element, String value) {
        this.element = element;
        this.value = value;
    }

    public static EnterCredential here(Target element, String value) {
    return Tasks.instrumented(EnterCredential.class, element, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(value).into(element));
    }
}
