package com.habr;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FavoritesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(className = "post_preview")
    private List<WebElement> postItems;

    @FindBy(className = "jGrowl-close")
    private WebElement closeMessageButton;

    private By messageFavorite = By.className("jGrowl-message");

    private By postTitle = By.className("post__title_link");

    private By removeFromFavoritesButton = By.cssSelector("button[title='Удалить из закладок']");

    public void waitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementIsNotDisplayed(By locator) {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public String getPostTitle() {
        waitElement(postTitle);
        WebElement item = this.postItems.get(0);
        return item.findElement(postTitle).getText();
    }

    public void closeMessageClick() {
        closeMessageButton.click();
    }

    public void removePostFromFavorites() {
//        try {
//            Thread.sleep(4000);
//        }catch (InterruptedException e) {}
        waitElement(postTitle);
        WebElement item = this.postItems.get(0);
//        this.addedCheckAndRemovingFromFavorites();
        item.findElement(removeFromFavoritesButton).click();
        waitElement(messageFavorite);
        closeMessageClick();
    }
}
