package io.testproject.examples.sdk.actions;

import io.appium.java_client.ios.IOSElement;
import io.testproject.java.annotations.v2.Action;
import io.testproject.java.sdk.v2.addons.IOSAction;
import io.testproject.java.sdk.v2.addons.helpers.IOSAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;

@Action(name = "Clear Fields")
public class ClearFieldsAction implements IOSAction {

    public ExecutionResult execute(IOSAddonHelper helper) throws FailureException {
        for (IOSElement element : helper.getDriver().findElements(By.className("XCUIElementTypeTextField"))) {
            element.clear();
        }

        for (IOSElement element : helper.getDriver().findElements(By.className("XCUIElementTypeSecureTextField"))) {
            element.clear();
        }

        return ExecutionResult.PASSED;
    }
}
