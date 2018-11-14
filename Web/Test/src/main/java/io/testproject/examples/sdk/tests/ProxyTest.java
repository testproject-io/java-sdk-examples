package io.testproject.examples.sdk.tests;

import io.testproject.examples.sdk.pages.LoginPage;
import io.testproject.examples.sdk.pages.ProfilePage;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.TakeScreenshotConditionType;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import io.testproject.proxy.addon.WebExampleAddon;
import io.testproject.proxy.addon.io.testproject.examples.sdk.actions.TypeRandomPhoneAction;

@Test(name = "Test with Addon proxy")
public class ProxyTest implements WebTest {

    @Parameter(defaultValue = "John Smith")
    public String name;

    @Parameter(defaultValue = "12345")
    public String password;

    @Parameter(defaultValue = "United States")
    public String country;

    @Parameter(defaultValue = "Address")
    public String address;

    @Parameter(defaultValue = "someone@somewhere.tld")
    public String email;

    public ExecutionResult execute(WebTestHelper helper) throws FailureException {

        // Get driver initialized by TestProject Agent
        // No need to specify browser type, it can be done later via UI
        WebDriver driver = helper.getDriver();
        TestReporter report = helper.getReporter();

        // Navigate to TestProject Demo website
        driver.navigate().to("https://example.testproject.io/web/");

        // Login using provided credentials
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        report.step("Navigated to TestProject Demo", loginPage.isDisplayed());

        loginPage.login(name, password);

        // Complete profile forms and save it
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        report.step(String.format("Logged in with %s:%s", name, password), profilePage.isDisplayed());

        profilePage.selectCountry(country);
        profilePage.typeAddress(address);
        profilePage.typeEmail(email);

        // Type random phone number using Addon proxy
        TypeRandomPhoneAction actionProxy = WebExampleAddon.typeRandomPhoneAction("1", 7);
        ExecutionResult result = helper.executeProxy(actionProxy, profilePage.getPhoneElement());
        report.step("Type random phone number using Addon proxy", result.equals(ExecutionResult.PASSED));

        // Save profile
        profilePage.save();
        report.step("Profile information saved", profilePage.isSaved(), TakeScreenshotConditionType.Always);

        report.result("Test completed successfully");
        return profilePage.isSaved() ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}

