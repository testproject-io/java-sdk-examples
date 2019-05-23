import io.testproject.examples.sdk.actions.ClearFieldsAction;
import io.testproject.examples.sdk.actions.TypeRandomPhoneAction;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.java.sdk.v2.drivers.IOSDriver;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class Actions {

    private static final String DEV_TOKEN = "YOUR_DEV_TOKEN";
    private static final String DEVICE_UDID = "IOS_DEVICE_UDID";
    private static final String DEVICE_NAME = "IOS_DEVICE_NAME";
    private static final String BUNDLE_ID = "io.testproject.Demo";

    private static Runner runner;
    private static IOSDriver driver;

    @BeforeAll
    public static void setup() throws InstantiationException {
        runner = Runner.createIOS(DEV_TOKEN, DEVICE_UDID, DEVICE_NAME, BUNDLE_ID);
        driver = runner.getDriver();
    }

    @AfterAll
    public static void tearDown() throws IOException {
        runner.close();
    }

    @Before
    public void prepareApp() {
        driver.resetApp();
    }

    @Test
    public void runAction() throws Exception {

        // Create Action
        ClearFieldsAction action = new ClearFieldsAction();

        // Prepare state
        driver.findElement(By.id("name")).sendKeys("John Smith");
        driver.findElement(By.id("password")).sendKeys("12345");

        // Run action
        runner.run(action);
    }

    @Test
    public void runElementAction() throws Exception {

        // Create Action
        TypeRandomPhoneAction action = new TypeRandomPhoneAction();

        // Prepare state
        driver.findElement(By.id("name")).sendKeys("John Smith");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.hideKeyboard();
        driver.findElement(By.id("login")).click();

        // Set action parameters
        action.countryCode = "1";
        action.maxDigits = 8;

        // Run action
        runner.run(action, By.id("phone"));
    }
}