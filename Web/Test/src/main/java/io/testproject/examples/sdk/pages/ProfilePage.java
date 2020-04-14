package io.testproject.examples.sdk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage {

    @FindBy(css = "#logout")
    private WebElement logoutElement;

    @FindBy(css = "#country")
    private WebElement countryElement;

    @FindBy(css = "#address")
    private WebElement addressElement;

    @FindBy(css = "#email")
    private WebElement emailElement;

    @FindBy(css = "#phone")
    private WebElement phoneElement;

    @FindBy(css = "#save")
    private WebElement saveElement;

    @FindBy(css = "#saved")
    private WebElement savedElement;

    public boolean isDisplayed() {
        return logoutElement.isDisplayed();
    }

    public void selectCountry(String country) {
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(country);
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

    public void updateProfile(String country, String address, String email, String phone) {
        selectCountry(country);
        typeAddress(address);
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
