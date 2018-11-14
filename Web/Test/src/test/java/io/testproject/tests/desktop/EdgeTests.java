package io.testproject.tests.desktop;

import io.testproject.java.enums.AutomatedBrowserType;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.tests.Tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.testproject.tests.Configuration.DEV_TOKEN;

public class EdgeTests {

    private static Runner runner;

    @BeforeAll
    private static void setup() throws InstantiationException {
        runner = Runner.createWeb(DEV_TOKEN, AutomatedBrowserType.Edge);
    }

    @AfterAll
    private static void tearDown() throws IOException {
        runner.close();
    }

    @Test
    public void runTest() throws Exception {
        Tests.runTest(runner);
    }

    @Test
    public void runExtendedTest() throws Exception {
        Tests.runExtendedTest(runner);
    }

    @Test
    public void runProxyTest() throws Exception {
        Tests.runProxyTest(runner);
    }
}