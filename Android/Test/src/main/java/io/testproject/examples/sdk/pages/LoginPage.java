package io.testproject.examples.sdk.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private AndroidDriver driver;
    @AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;
    @AndroidFindBy(id = "name")
    private AndroidElement nameElement;
    @AndroidFindBy(id = "password")
    private AndroidElement passwordElement;
    @AndroidFindBy(id = "login")
    private AndroidElement loginElement;

    public LoginPage() {
    }

    public LoginPage(AndroidDriver driver) {
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

    public void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // Nothing to do here...
        }
    }

    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
            driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
        }
    }

    public void login(String name, String password) {
        hideKeyboardIfVisible();
        typeName(name);
        typePassword(password);
        clickLogin();
    }
}
