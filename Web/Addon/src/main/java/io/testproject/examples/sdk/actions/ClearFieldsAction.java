package io.testproject.examples.sdk.actions;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.sdk.v2.addons.WebAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Action(name = "Clear Fields")
public class ClearFieldsAction implements WebAction {

    public ExecutionResult execute(WebAddonHelper helper) throws FailureException {

        // Get Driver
        WebDriver driver = helper.getDriver();

        // Search for Form elements
        for (WebElement form : driver.findElements(By.tagName("form"))) {

            // Ignore invisible forms
            if (!form.isDisplayed()) {
                continue;
            }

            // Clear all inputs
            for (WebElement element : form.findElements(By.tagName("input"))) {
                element.clear();
            }
        }

        return ExecutionResult.PASSED;
    }
}
