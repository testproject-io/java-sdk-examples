package io.testproject.examples.sdk.actions;

import io.appium.java_client.android.AndroidElement;
import io.testproject.java.annotations.v2.Action;
import io.testproject.java.sdk.v2.addons.AndroidAction;
import io.testproject.java.sdk.v2.addons.helpers.AndroidAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;

@Action(name = "Clear Fields")
public class ClearFieldsAction implements AndroidAction {

    public ExecutionResult execute(AndroidAddonHelper helper) throws FailureException {
        for (AndroidElement element : helper.getDriver().findElements(By.className("android.widget.EditText"))) {
            element.clear();
        }

        return ExecutionResult.PASSED;
    }
}
