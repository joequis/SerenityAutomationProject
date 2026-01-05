package com.example.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickElement implements Interaction {

    //Parámetros
    private final Target element;

    //Constructor
    public ClickElement(Target element) {
        this.element = element;
    }

    /** Fábrica semántica: crea una instancia instrumentada pasando el Target */
    public static ClickElement on(Target element) {
        return instrumented(ClickElement.class, element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(element,isClickable()).forNoMoreThan(10).seconds(),Click.on(element));
    }
}
