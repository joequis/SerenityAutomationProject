package com.example.automation.questions;

import com.example.automation.ui.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class DashboardTitle implements Question<String> {

    public static Question<String> value() {
        return new DashboardTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(DashboardPage.TITLE).answeredBy(actor);
    }
}
