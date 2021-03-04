package com.habr;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.habr.Utils.LOGIN;
import static com.habr.Utils.PASSWORD;
import static com.habr.CommonFunctions.*;

public class LoginLogoutTests extends Prepare {

    @Test(testName = "Should log in the site")
    public void login () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage.open();
        loginCheckAndSignOut();
        mainPage.loginButtonClick();
        loginPage.LogInFieldsFillingAndSubmit(LOGIN, PASSWORD);
        Assert.assertTrue(mainPage.userButtonIsDisplayed());
    }

    @Test(testName = "Should log out from the site")
    public void logout() {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.signOutButtonClick();
        Assert.assertTrue(mainPage.loginButtonIsDisplayed());
    }
}
