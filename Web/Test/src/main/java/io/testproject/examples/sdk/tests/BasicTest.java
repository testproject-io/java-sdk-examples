package io.testproject.examples.sdk.tests;

import io.testproject.examples.sdk.pages.LoginPage;
import io.testproject.examples.sdk.pages.ProfilePage;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;

public class BasicTest implements WebTest {

    public String name = "John Smith";
    public String password = "12345";
    public String country = "United States";
    public String address = "Street number and name";
    public String email = "john.smith@somewhere.tld";
    public String phone = "+1 555 555 55";

    public ExecutionResult execute(WebTestHelper helper) throws FailureException {

        // Get driver initialized by TestProject Agent
        // No need to specify browser type, it can be done later via UI
        WebDriver driver = helper.getDriver();

        // Navigate to TestProject Demo website
        driver.navigate().to("https://example.testproject.io/web/");

        // Login using provided credentials
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(name, password);

        // Complete profile forms and save it
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        profilePage.updateProfile(country, address, email, phone);

        return profilePage.isSaved() ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}

