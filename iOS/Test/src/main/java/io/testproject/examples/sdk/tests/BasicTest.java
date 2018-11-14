package io.testproject.examples.sdk.tests;

import io.testproject.examples.sdk.pages.LoginPage;
import io.testproject.examples.sdk.pages.ProfilePage;
import io.testproject.java.sdk.v2.drivers.IOSDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.IOSTest;
import io.testproject.java.sdk.v2.tests.helpers.IOSTestHelper;

public class BasicTest implements IOSTest {

    public String name = "John Smith";
    public String password = "12345";
    public String country = "USA";
    public String address = "Street number and name";
    public String email = "john.smith@somewhere.tld";
    public String phone = "+1 555 555 55";

    public ExecutionResult execute(IOSTestHelper helper) throws FailureException {
        IOSDriver driver = helper.getDriver();

        driver.resetApp();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(name, password);

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.updateProfile(country, address, email, phone);

        return profilePage.isSaved() ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}

