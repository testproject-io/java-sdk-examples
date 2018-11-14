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

@Test(name = "Extended Test")
public class ExtendedTest implements WebTest {

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

    @Parameter(defaultValue = "+1 555 555 555")
    public String phone;

    public ExecutionResult execute(WebTestHelper helper) throws FailureException {
        WebDriver driver = helper.getDriver();
        TestReporter report = helper.getReporter();

        driver.navigate().to("https://example.testproject.io/web/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        report.step("Navigated to TestProject Demo", loginPage.isDisplayed());

        loginPage.login(name, password);
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        report.step(String.format("Logged in with %s:%s", name, password), profilePage.isDisplayed());

        profilePage.updateProfile(country, address, email, phone);
        report.step("Profile information saved", profilePage.isSaved(), TakeScreenshotConditionType.Always);

        report.result("Test completed successfully");
        return ExecutionResult.PASSED;
    }
}

