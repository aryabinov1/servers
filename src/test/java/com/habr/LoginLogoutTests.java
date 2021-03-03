package com.habr;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.habr.Utils.LOGIN;
import static com.habr.Utils.PASSWORD;
import static com.habr.CommonFunctions.*;

public class LoginLogoutTests extends Prepare {

//    @AfterTest
//    public void cleanUp() {
//        driver.manage().deleteAllCookies();
//        driver.close();
//    }

    @Test(testName = "Should log in the site")
    public void login () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        CommonFunctions commonFunctions = new CommonFunctions();
        mainPage.open();
        loginCheckAndSignOut();
//        try {
//            Thread.sleep(2000);
//        }catch (InterruptedException e) {}
//        commonFunctions.loginCheckAndSignIn();
        mainPage.loginButtonClick();
        loginPage.LogInFieldsFillingAndSubmit(LOGIN, PASSWORD);
        Assert.assertTrue(mainPage.userButtonIsDisplayed());
    }

    @Test(testName = "Should log out from the site")
    public void logout() {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

//        CommonFunctions commonFunctions = new CommonFunctions();
        mainPage.open();
//        try {
//            Thread.sleep(2000);
//        }catch (InterruptedException e) {}
        loginCheckAndSignIn();
//        mainPage.loginButtonClick();
//        loginPage.LogInFieldsFillingAndSubmit(LOGIN, PASSWORD);
        mainPage.userButtonClick();
        mainPage.signOutButtonClick();
        Assert.assertTrue(mainPage.loginButtonIsDisplayed());
    }
}
