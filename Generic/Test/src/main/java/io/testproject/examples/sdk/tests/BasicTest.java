package io.testproject.examples.sdk.tests;

import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.GenericTest;
import io.testproject.java.sdk.v2.tests.helpers.TestHelper;

public class BasicTest implements GenericTest {

    public ExecutionResult execute(TestHelper helper) throws FailureException {

        int a = 1, b = 1;

        if (a + b == 2) {
            return ExecutionResult.PASSED;
        } else {
            return ExecutionResult.FAILED;
        }
    }
}

