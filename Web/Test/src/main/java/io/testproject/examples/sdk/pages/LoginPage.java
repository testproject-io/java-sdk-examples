package io.testproject.examples.sdk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = "#name")
    private WebElement nameElement;

    @FindBy(css = "#password")
    private WebElement passwordElement;

    @FindBy(css = "#login")
    private WebElement loginElement;

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
