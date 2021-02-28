package com.habr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static com.habr.Utils.LOGIN;
import static com.habr.Utils.PASSWORD;
import static com.habr.Prepare.getDriver;

public class CommonFunctions {
    public static WebDriver driver = getDriver();

    public static void loginCheckAndSignIn() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        if (mainPage.loginButtonIsDisplayed()) {
            mainPage.loginButtonClick();
            loginPage.LogInFieldsFillingAndSubmit(LOGIN, PASSWORD);
        }
    }

    // TODO class logoutIfLogged
}
