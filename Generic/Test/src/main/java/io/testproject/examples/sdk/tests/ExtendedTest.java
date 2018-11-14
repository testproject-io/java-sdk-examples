package io.testproject.examples.sdk.tests;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.GenericTest;
import io.testproject.java.sdk.v2.tests.helpers.TestHelper;

@Test(name = "Extended Test")
public class ExtendedTest implements GenericTest {

    @Parameter(defaultValue = "1")
    public int a;

    @Parameter(defaultValue = "1")
    public int b;

    @Parameter(description = "Calculation expected result")
    public int expectedResult;

    @Parameter(description = "Calculation actual result", direction = ParameterDirection.OUTPUT)
    public int actualResult;

    public ExecutionResult execute(TestHelper helper) throws FailureException {

        this.actualResult = a + b;
        helper.getReporter().step(String.format("%d + %d == %d?", this.a, this.b, this.expectedResult), this.actualResult == this.expectedResult);

        helper.getReporter().result("Addition result is: " + this.actualResult);

        return this.actualResult == this.expectedResult ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}

