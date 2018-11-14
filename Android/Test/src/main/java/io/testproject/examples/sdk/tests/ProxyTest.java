package io.testproject.examples.sdk.tests;

import io.testproject.examples.sdk.pages.LoginPage;
import io.testproject.examples.sdk.pages.ProfilePage;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.TakeScreenshotConditionType;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;
import io.testproject.proxy.addon.AndroidExampleAddon;
import io.testproject.proxy.addon.io.testproject.examples.sdk.actions.TypeRandomPhoneAction;


@Test(name = "Test with Addon proxy")
public class ProxyTest implements AndroidTest {

    @Parameter(defaultValue = "John Smith")
    public String name;

    @Parameter(defaultValue = "12345")
    public String password;

    @Parameter(defaultValue = "Earth")
    public String country;

    @Parameter(defaultValue = "Address")
    public String address;

    @Parameter(defaultValue = "someone@somewhere.tld")
    public String email;

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        AndroidDriver driver = helper.getDriver();
        TestReporter report = helper.getReporter();

        driver.resetApp();

        LoginPage loginPage = new LoginPage(driver);
        report.step("Launched TestProject Demo app", loginPage.isDisplayed());

        loginPage.login(name, password);
        ProfilePage profilePage = new ProfilePage(driver);
        report.step(String.format("Logged in with %s:%s", name, password), profilePage.isDisplayed());

        profilePage.hideKeyboardIfVisible();
        profilePage.typeCountry(country);
        profilePage.typeAddress(address);
        profilePage.typeEmail(email);

        // Type random phone number using Addon proxy
        TypeRandomPhoneAction actionProxy = AndroidExampleAddon.typeRandomPhoneAction("1", 7);
        ExecutionResult result = helper.executeProxy(actionProxy, profilePage.getPhoneElement());
        report.step("Type random phone number using Addon proxy", result.equals(ExecutionResult.PASSED));

        // Save profile
        profilePage.save();

        report.step("Profile information saved", profilePage.isSaved(), TakeScreenshotConditionType.Always);


        report.result("Test completed successfully");
        return ExecutionResult.PASSED;
    }
}

