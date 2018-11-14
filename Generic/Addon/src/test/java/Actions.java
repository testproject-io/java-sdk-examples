import io.testproject.examples.sdk.actions.AdditionAction;
import io.testproject.java.sdk.v2.Runner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class Actions {

    private static Runner runner;

    @BeforeAll
    public static void setup() throws InstantiationException {
        runner = Runner.create("YOUR_DEV_TOKEN");
    }

    @AfterAll
    public static void tearDown() throws IOException {
        runner.close();
    }

    @Test
    public void runAction() throws Exception {

        // Create Action
        AdditionAction action = new AdditionAction();
        action.a = 1;
        action.b = 1;

        // Run action
        runner.run(action);
    }
}