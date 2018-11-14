package io.testproject.tests.mobile;

import io.testproject.java.sdk.v2.Runner;
import io.testproject.tests.Actions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.testproject.tests.Configuration.ANDROID_DEVICE_UDID;
import static io.testproject.tests.Configuration.DEV_TOKEN;


public class MobileChromeActions {

    private static Runner runner;

    @BeforeAll
    public static void setup() throws InstantiationException {
        runner = Runner.createAndroidWeb(DEV_TOKEN, ANDROID_DEVICE_UDID);
    }

    @Test
    public void runAction() throws Exception {
        Actions.runAction(runner);
    }

    @Test
    public void runElementAction() throws Exception {
        Actions.runElementAction(runner);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        runner.close();
    }
}