package io.testproject.examples.sdk.actions;

import io.testproject.java.annotations.v2.ElementAction;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.addons.WebElementAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.WebElement;

@ElementAction(name = "Type Random Phone Number")
public class TypeRandomPhoneAction implements WebElementAction {

    @Parameter
    public String countryCode = "1";

    @Parameter
    public int maxDigits;

    @Parameter(direction = ParameterDirection.OUTPUT)
    public String phone;

    public ExecutionResult execute(WebAddonHelper helper, WebElement element) throws FailureException {
        long number = (long) (Math.random() * Math.pow(10, maxDigits));
        phone = String.format("+%s%s", countryCode, number);
        element.sendKeys(phone);
        return ExecutionResult.PASSED;
    }
}
