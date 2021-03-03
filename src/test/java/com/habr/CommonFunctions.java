package com.habr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.Charset;
import java.util.Random;

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

    public static void loginCheckAndSignOut() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        if (mainPage.userButtonIsDisplayed()) {
            mainPage.userButtonClick();
            mainPage.signOutButtonClick();
            mainPage.loginButtonIsDisplayedWait();
        }
    }

    public static String generateRandomString(Integer countChar) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = countChar;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
