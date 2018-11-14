package io.testproject;

import io.testproject.examples.sdk.tests.BasicTest;
import io.testproject.examples.sdk.tests.ExtendedTest;
import io.testproject.examples.sdk.tests.ProxyTest;
import io.testproject.java.sdk.v2.Runner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class Tests {

    private static Runner runner;

    @BeforeAll
    private static void setup() throws InstantiationException {
        runner = Runner.create("YOUR_DEV_TOKEN");
    }

    @AfterAll
    private static void tearDown() throws IOException {
        runner.close();
    }

    @Test
    public void runTest() throws Exception {

        // Create test
        BasicTest test = new BasicTest();

        // Run test
        runner.run(test);

    }

    @Test
    public void runExtendedTest() throws Exception {

        // Create test
        ExtendedTest test = new ExtendedTest();
        test.a = 1;
        test.b = 1;
        test.expectedResult = 2;

        // Run test
        runner.run(test);
    }

    @Test
    public void runProxyTest() throws Exception {

        // Create test
        ProxyTest test = new ProxyTest();
        test.a = 1;
        test.b = 1;
        test.expectedResult = 2;

        // Run test
        runner.run(test);
    }
}