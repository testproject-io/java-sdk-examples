package io.testproject.examples.sdk.pages;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.testproject.java.sdk.v2.drivers.IOSDriver;
import io.testproject.java.sdk.v2.support.PageFactory;

public class LoginPage {

    private IOSDriver driver;
    @iOSXCUITFindBy(id = "name")
    private IOSElement nameElement;
    @iOSXCUITFindBy(id = "password")
    private IOSElement passwordElement;
    @iOSXCUITFindBy(id = "login")
    private IOSElement loginElement;

    public LoginPage() {
    }

    public LoginPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isDisplayed() {
        return loginElement.isDisplayed();
    }

    public void typeName(String name) {
        nameElement.sendKeys(name);
    }

    public void typePassword(String password) {
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        loginElement.click();
    }

    public void login(String name, String password) {
        typeName(name);
        typePassword(password);
        clickLogin();
    }
}
