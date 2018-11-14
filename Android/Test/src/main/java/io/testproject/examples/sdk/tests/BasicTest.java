package io.testproject.examples.sdk.tests;

import io.testproject.examples.sdk.pages.LoginPage;
import io.testproject.examples.sdk.pages.ProfilePage;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.AndroidTest;
import io.testproject.java.sdk.v2.tests.helpers.AndroidTestHelper;

public class BasicTest implements AndroidTest {

    public String name = "John Smith";
    public String password = "12345";
    public String country = "USA";
    public String address = "Street number and name";
    public String email = "john.smith@somewhere.tld";
    public String phone = "+1 555 555 55";

    public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
        // Get driver initialized by TestProject Agent
        AndroidDriver driver = helper.getDriver();

        driver.resetApp();

        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(name, password);

        // Complete profile form
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.updateProfile(country, address, email, phone);

        return profilePage.isSaved() ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}

