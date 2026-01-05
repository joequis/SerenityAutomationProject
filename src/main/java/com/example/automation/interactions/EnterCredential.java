package com.example.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterCredential implements Interaction {

    //Parámetros
    private final String value;
    private final Target element;

    //Constructor
    public EnterCredential(String value, Target element) {
        this.value = value;
        this.element = element;
    }

    //Metodo Here de EnterCredential con sus respectivos parámetros
    public static EnterCredential here(String value, Target element) {
    return instrumented(EnterCredential.class, value, element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(value).into(element));
    }
}
