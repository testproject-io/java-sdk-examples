package io.testproject.examples.sdk.actions;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.addons.GenericAction;
import io.testproject.java.sdk.v2.addons.helpers.AddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;

@Action(name = "Addition", description = "Add {{a}} to {{b}}")
public class AdditionAction implements GenericAction {

    @Parameter
    public int a;

    @Parameter
    public int b;

    @Parameter(description = "Addition result", direction = ParameterDirection.OUTPUT)
    public int result;

    public ExecutionResult execute(AddonHelper helper) throws FailureException {

        result = a + b;
        helper.getReporter().result("Addition result is: " + result);

        return ExecutionResult.PASSED;
    }
}
