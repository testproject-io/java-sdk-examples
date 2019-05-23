package io.testproject.examples.sdk.pages;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.testproject.java.sdk.v2.drivers.IOSDriver;
import io.testproject.java.sdk.v2.support.PageFactory;
import org.openqa.selenium.By;

import java.time.Duration;

public class ProfilePage {

    private IOSDriver driver;
    @iOSXCUITFindBy(id = "greetings")
    private IOSElement greetingsElement;
    @iOSXCUITFindBy(id = "logout")
    private IOSElement logoutElement;
    @iOSXCUITFindBy(id = "country")
    private IOSElement countryElement;
    @iOSXCUITFindBy(id = "address")
    private IOSElement addressElement;
    @iOSXCUITFindBy(id = "email")
    private IOSElement emailElement;
    @iOSXCUITFindBy(id = "phone")
    private IOSElement phoneElement;
    @iOSXCUITFindBy(id = "save")
    private IOSElement saveElement;
    @iOSXCUITFindBy(id = "saved")
    private IOSElement savedElement;

    public ProfilePage() {
    }

    public ProfilePage(IOSDriver driver) {
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

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void updateProfile(String country, String address, String email, String phone) {
        typeCountry(country);
        typeAddress(address);
        typeEmail(email);
        typePhone(phone);
        hideKeyboard();
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
