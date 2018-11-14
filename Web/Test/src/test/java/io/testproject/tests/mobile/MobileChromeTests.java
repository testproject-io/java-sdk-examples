package io.testproject.tests.mobile;

import io.testproject.java.sdk.v2.Runner;
import io.testproject.tests.Tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.testproject.tests.Configuration.ANDROID_DEVICE_UDID;
import static io.testproject.tests.Configuration.DEV_TOKEN;

public class MobileChromeTests {

    private static Runner runner;

    @BeforeAll
    private static void setup() throws InstantiationException {
        runner = Runner.createAndroidWeb(DEV_TOKEN, ANDROID_DEVICE_UDID);
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