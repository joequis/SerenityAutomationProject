package com.example.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {
    public static final Target TITLE = Target.the("dashboard title")
            .located(By.className("title"));
}
