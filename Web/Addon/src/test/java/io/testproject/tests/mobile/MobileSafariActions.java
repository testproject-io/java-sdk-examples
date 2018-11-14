package io.testproject.tests.mobile;

import io.testproject.java.sdk.v2.Runner;
import io.testproject.tests.Actions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.testproject.tests.Configuration.*;


public class MobileSafariActions {

    private static Runner runner;

    @BeforeAll
    public static void setup() throws InstantiationException {
        runner = Runner.createIOSWeb(DEV_TOKEN, IOS_DEVICE_UDID, IOS_DEVICE_NAME);
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