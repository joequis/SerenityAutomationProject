package com.example.automation.tasks;

import com.example.automation.interactions.EnterCredential;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import com.example.automation.interactions.ClickElement;
import static com.example.automation.ui.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterCredential.here(username, USERNAME_FIELD),
                EnterCredential.here(password, PASSWORD_FIELD),
                ClickElement.on(LOGIN_BUTTON)
        );
    }
}
