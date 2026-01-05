package com.example.automation.stepdefinitions;

import com.example.automation.questions.DashboardTitle;
import com.example.automation.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    @Given("that {string} is on the login page")
    public void thatUserIsOnTheLoginPage(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }

    @When("he logs in with credentials {string} and {string}")
    public void heLogsInWithCredentials(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @Then("he should see the dashboard with title {string}")
    public void heShouldSeeTheDashboardWithTitle(String title) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(DashboardTitle.value(), equalTo(title))
        );
    }
}
