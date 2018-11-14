package io.testproject.tests;

import io.testproject.examples.sdk.actions.ClearFieldsAction;
import io.testproject.examples.sdk.actions.TypeRandomPhoneAction;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import org.openqa.selenium.By;

public class Actions {

    public static void runAction(Runner runner) throws Exception {
        // Create Action
        ClearFieldsAction action = new ClearFieldsAction();

        // Prepare state
        WebDriver driver = runner.getDriver();
        driver.navigate().to("https://example.testproject.io/web/");
        driver.findElement(By.id("name")).sendKeys("John Smith");
        driver.findElement(By.id("password")).sendKeys("12345");

        // Run action
        runner.run(action);
    }


    public static void runElementAction(Runner runner) throws Exception {
        // Create Action
        TypeRandomPhoneAction action = new TypeRandomPhoneAction();

        // Prepare state
        WebDriver driver = runner.getDriver();
        driver.navigate().to("https://example.testproject.io/web/");

        driver.findElement(By.id("name")).sendKeys("John Smith");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("login")).click();

        // Set action parameters
        action.countryCode = "1";
        action.maxDigits = 8;

        // Run action
        runner.run(action, By.id("phone"));
    }

}