package io.testproject.examples.sdk.pages;


import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.testproject.java.sdk.v2.drivers.AndroidDriver;
import io.testproject.java.sdk.v2.support.PageFactory;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProfilePage {

    private AndroidDriver driver;
    @AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;
    @AndroidFindBy(id = "greetings")
    private AndroidElement greetingsElement;
    @AndroidFindBy(id = "logout")
    private AndroidElement logoutElement;
    @AndroidFindBy(id = "country")
    private AndroidElement countryElement;
    @AndroidFindBy(id = "address")
    private AndroidElement addressElement;
    @AndroidFindBy(id = "email")
    private AndroidElement emailElement;
    @AndroidFindBy(id = "phone")
    private AndroidElement phoneElement;
    @AndroidFindBy(id = "save")
    private AndroidElement saveElement;
    @AndroidFindBy(id = "saved")
    private AndroidElement savedElement;

    public ProfilePage() {
    }

    public ProfilePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
    }

    public boolean isDisplayed() {
        return greetingsElement.isDisplayed();
    }

    public void typeCountry(String country) {
        countryElement.sendKeys(country);
    }

    public void typeAddress(String address) {
        addressElement.sendKeys(address);
    }

    public void typeEmail(String email) {
        emailElement.sendKeys(email);
    }

    public void typePhone(String phone) {
        phoneElement.sendKeys(phone);
    }

    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
            driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
        }
    }

    public void updateProfile(String country, String address, String email, String phone) {
        typeCountry(country);
        typeAddress(address);
        hideKeyboardIfVisible();
        typeEmail(email);
        typePhone(phone);
        save();
    }

    public void save() {
        saveElement.click();
    }

    public boolean isSaved() {
        return savedElement.isDisplayed();
    }

    public By getPhoneElement() {
        return By.id("phone");
    }

}
