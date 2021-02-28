package com.habr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "email_field")
    private WebElement emailField;

    @FindBy(id = "password_field")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login_form\"]/fieldset/div[4]/button")
    private WebElement submitButton;

    public void LogInFieldsFillingAndSubmit(String email, String pass) {
        this.emailField.sendKeys(email);
        this.passwordField.sendKeys(pass);
        this.submitButton.click();
    }
}
