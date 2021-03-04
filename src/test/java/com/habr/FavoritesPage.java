package com.habr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FavoritesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(className = "post_preview")
    private List<WebElement> postItems;

    @FindBy(className = "jGrowl-close")
    private WebElement closeMessageButton;

    final private By messageFavorite = By.className("jGrowl-message");

    final private By postTitle = By.className("post__title_link");

    final private By removeFromFavoritesButton = By.cssSelector("button[title='Удалить из закладок']");

    public void waitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
        waitElement(postTitle);
        WebElement item = this.postItems.get(0);
        item.findElement(removeFromFavoritesButton).click();
        waitElement(messageFavorite);
        closeMessageClick();
    }
}
