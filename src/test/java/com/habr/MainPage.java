package com.habr;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

import java.util.List;

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

    @FindBy(className = "jGrowl-close")
    private WebElement closeMessageButton;

    @FindBy(className = "post_preview")
    private List<WebElement> postItems;

    private By messageFavorite = By.className("jGrowl-message");

    private By loginButton = By.id("login");

    private By dropdownUserButton = By.className("dropdown_user");

    private By signOutButton = By.xpath("//a[descendant::*[name()=\"use\" and contains(@*, 'logout')]]");

    private By settingsButton = By.xpath("//a[descendant::*[name()=\"use\" and contains(@*, 'settings')]]");

    private By favoritesButton = By.linkText("Закладки");

    private By postTitle = By.className("post__title");

    private By postBody = By.className("post__body");

    private By addToFavoritesButton = By.cssSelector("button[title='Добавить в закладки']");

    private By removeFromFavoritesButton = By.cssSelector("button[title='Удалить из закладок']");

//    private By closeMessageButton = By.className("jGrowl-close");

    public void loginButtonClick() {
        mainNavbar.findElement(loginButton).click();
    }

    public void waitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void closeMessageClick() {
        closeMessageButton.click();
    }

//    public void clickElement(By locator) {
//        driver.findElement(locator).click();
//    }

//    public void userButtonIsDisplayedWait() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownUserButton));
//    }

    public void loginButtonIsDisplayedWait() {
        this.waitElement(loginButton);
    }

    public String getPostTitle() {
        WebElement item = this.postItems.get(0);
        return item.findElement(postTitle).getText();
    }

    public void favoritesButtonClick() {
        this.waitElement(favoritesButton);
//        this.settingsButtonIsDisplayedWait();
        userDropDownMenu.findElement(favoritesButton).click();
    }

    public void addPostToFavorites() {
//        try {
//            Thread.sleep(10000);
//        }catch (InterruptedException e) {}
//        if (!driver.findElement(postTitle).isDisplayed()) {
//        waitElement(postTitle);
//        }
        waitElement(postBody);
        WebElement item = this.postItems.get(0);
//        this.addedCheckAndRemovingFromFavorites();
        item.findElement(addToFavoritesButton).click();
        waitElement(messageFavorite);
        closeMessageClick();
    }

    public void addedCheckAndRemovingFromFavorites() {
        WebElement item = this.postItems.get(0);
        if (item.findElement(removeFromFavoritesButton).isDisplayed()) {
            item.findElement(removeFromFavoritesButton).click();
            waitElement(messageFavorite);
        }
    }

    public boolean loginButtonIsDisplayed() {
        try {
//            this.loginButtonIsDisplayedWait();
            this.waitElement(loginButton);
        } catch (TimeoutException e) {
            return false;
        }
        return mainNavbar.findElement(loginButton).isDisplayed();
    }

//    public void signOutButtonIsDisplayedWait() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
//    }

//    public void settingsButtonIsDisplayedWait() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsButton));
//    }

    public void settingsButtonClick() {
        this.waitElement(settingsButton);
//        this.settingsButtonIsDisplayedWait();
        userDropDownMenu.findElement(settingsButton).click();
    }

    public boolean userButtonIsDisplayed() {
        try {
            this.waitElement(dropdownUserButton);
//        this.userButtonIsDisplayedWait();
        } catch (TimeoutException e) {
            return false;
        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownUserButton));
        return mainNavbar.findElement(dropdownUserButton).isDisplayed();
    }

    public void userButtonClick() {
//        this.userButtonIsDisplayedWait();
        this.waitElement(dropdownUserButton);
        mainNavbar.findElement(dropdownUserButton).click();
    }

    public void signOutButtonClick() {
        this.waitElement(signOutButton);
//        this.signOutButtonIsDisplayedWait();
        userDropDownMenu.findElement(signOutButton).click();
    }

    public void open() {
//        if (driver.getCurrentUrl().contains(BASE_URL))
//            return;

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