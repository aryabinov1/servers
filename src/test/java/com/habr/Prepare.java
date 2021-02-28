package com.habr;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.habr.Utils.BASE_URL;
import static com.habr.Utils.CHROME_DRIVER_LOCATION;

public class Prepare {
    public static WebDriver driver;
    public MainPage mainPage;
    public WebDriverWait wait;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void prepareTests() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterSuite
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
