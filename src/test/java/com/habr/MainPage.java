package com.habr;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    final private By messageFavorite = By.className("jGrowl-message");

    final private By loginButton = By.id("login");

    final private By dropdownUserButton = By.className("dropdown_user");

    final private By signOutButton = By.xpath("//a[descendant::*[name()=\"use\" and contains(@*, 'logout')]]");

    final private By settingsButton = By.xpath("//a[descendant::*[name()=\"use\" and contains(@*, 'settings')]]");

    final private By favoritesButton = By.linkText("Закладки");

    final private By postTitle = By.className("post__title");

    final private By postBody = By.className("post__body");

    final private By addToFavoritesButton = By.cssSelector("button[title='Добавить в закладки']");

    public void loginButtonClick() {
        mainNavbar.findElement(loginButton).click();
    }

    public void waitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void closeMessageClick() {
        closeMessageButton.click();
    }

    public void loginButtonIsDisplayedWait() {
        this.waitElement(loginButton);
    }

    public String getPostTitle() {
        WebElement item = this.postItems.get(0);
        return item.findElement(postTitle).getText();
    }

    public void favoritesButtonClick() {
        this.waitElement(favoritesButton);
        userDropDownMenu.findElement(favoritesButton).click();
    }

    public void addPostToFavorites() {
        waitElement(postBody);
        WebElement item = this.postItems.get(0);
        item.findElement(addToFavoritesButton).click();
        waitElement(messageFavorite);
        closeMessageClick();
    }

    public boolean loginButtonIsDisplayed() {
        try {
            this.waitElement(loginButton);
        } catch (TimeoutException e) {
            return false;
        }
        return mainNavbar.findElement(loginButton).isDisplayed();
    }

    public void settingsButtonClick() {
        this.waitElement(settingsButton);
        userDropDownMenu.findElement(settingsButton).click();
    }

    public boolean userButtonIsDisplayed() {
        try {
            this.waitElement(dropdownUserButton);
        } catch (TimeoutException e) {
            return false;
        }
        return mainNavbar.findElement(dropdownUserButton).isDisplayed();
    }

    public void userButtonClick() {
        this.waitElement(dropdownUserButton);
        mainNavbar.findElement(dropdownUserButton).click();
    }

    public void signOutButtonClick() {
        this.waitElement(signOutButton);
        userDropDownMenu.findElement(signOutButton).click();
    }

    public void open() {
        driver.get(BASE_URL);
        // TODO Иногда возникает ошибка, нужно разобраться
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {}
    }
}