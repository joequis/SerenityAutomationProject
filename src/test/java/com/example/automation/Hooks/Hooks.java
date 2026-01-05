package com.example.automation.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDown() {
        OnStage.drawTheCurtain(); // ejecuta wrapUp() y tearDown() de habilidades
    }

}
