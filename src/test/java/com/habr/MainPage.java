package com.habr;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.habr.Utils.BASE_URL;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(className = "main-navbar")
    private WebElement mainNavbar;

    @FindBy(className = "n-dropdown-menu_profile")
    private WebElement userDropDownMenu;

    private By loginButton = By.id("login");

    private By dropdownUserButton = By.className("dropdown_user");

    private By signOutButton = By.xpath("//a[descendant::*[name()=\"use\" and contains(@*, 'logout')]]");

    public void loginButtonClick() {
        mainNavbar.findElement(loginButton).click();
    }

    public void userButtonIsDisplayedWait() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownUserButton));
    }

    public void loginButtonIsDisplayedWait() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    public boolean loginButtonIsDisplayed() {
        try {
            this.loginButtonIsDisplayedWait();
        } catch (TimeoutException e) {
            return false;
        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownUserButton));
        return mainNavbar.findElement(loginButton).isDisplayed();
    }

    public void signOutButtonIsDisplayedWait() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
    }

    public boolean userButtonIsDisplayed() {
        this.userButtonIsDisplayedWait();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownUserButton));
        return mainNavbar.findElement(dropdownUserButton).isDisplayed();
    }

    public void userButtonClick() {
        this.userButtonIsDisplayedWait();
        mainNavbar.findElement(dropdownUserButton).click();
    }

    public void signOutButtonClick() {
        this.signOutButtonIsDisplayedWait();
        userDropDownMenu.findElement(signOutButton).click();
    }

    public void open() {
        if (driver.getCurrentUrl().contains(BASE_URL))
            return;

        driver.get(BASE_URL);
        // TODO Иногда возникает ошибка, нужно разобраться
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {}
    }
}


//try {
//        driver.wait(2000);
//        }catch (InterruptedException e) {}