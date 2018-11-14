package io.testproject.examples.sdk.tests;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.GenericTest;
import io.testproject.java.sdk.v2.tests.helpers.TestHelper;
import io.testproject.proxy.addon.GenericExampleAddon;
import io.testproject.proxy.addon.io.testproject.examples.sdk.actions.AdditionAction;

@Test(name = "Test with Addon proxy")
public class ProxyTest implements GenericTest {

    @Parameter(defaultValue = "1")
    public int a;

    @Parameter(defaultValue = "1")
    public int b;

    @Parameter(description = "Calculation expected result")
    public int expectedResult;

    @Parameter(description = "Calculation actual result", direction = ParameterDirection.OUTPUT)
    public int actualResult;

    @Override
    public ExecutionResult execute(TestHelper helper) throws FailureException {
        AdditionAction actionProxy = GenericExampleAddon.additionAction(a, b);
        ExecutionResult result = helper.executeProxy(actionProxy);

        this.actualResult = actionProxy.result;

        boolean passed = result.equals(ExecutionResult.PASSED) && this.actualResult == this.expectedResult;

        helper.getReporter().step(String.format("%d + %d == %d?", this.a, this.b, this.expectedResult),
                passed);

        helper.getReporter().result("Addition result is: " + this.actualResult);

        return passed ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}

