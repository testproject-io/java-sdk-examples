package io.testproject.tests.desktop;

import io.testproject.java.enums.AutomatedBrowserType;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.tests.Actions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.testproject.tests.Configuration.DEV_TOKEN;


public class InternetExplorerActions {

    private static Runner runner;

    @BeforeAll
    public static void setup() throws InstantiationException {
        runner = Runner.createWeb(DEV_TOKEN, AutomatedBrowserType.InternetExplorer);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        runner.close();
    }

    @Test
    public void runAction() throws Exception {
        Actions.runAction(runner);
    }

    @Test
    public void runElementAction() throws Exception {
        Actions.runElementAction(runner);
    }
}