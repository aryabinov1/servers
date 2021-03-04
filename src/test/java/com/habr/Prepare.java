package com.habr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.habr.Utils.CHROME_DRIVER_LOCATION;

public class Prepare {
    public static WebDriver driver;
    public WebDriverWait wait;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void prepareTests() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void cleanUp() {
        //TODO Проверить закладки и удалить все
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
