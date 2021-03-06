package com.habr;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.habr.CommonFunctions.loginCheckAndSignIn;

public class FavoriteTests extends Prepare{
    @Test(testName = "Should add post to the favorites list")
    public void favoritesAdding () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        FavoritesPage favoritesPage = PageFactory.initElements(driver, FavoritesPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.addPostToFavorites();
        String previousValue = mainPage.getPostTitle();

        mainPage.userButtonClick();
        mainPage.favoritesButtonClick();
        String addedPostTitle = favoritesPage.getPostTitle();
        favoritesPage.removePostFromFavorites();
        Assert.assertEquals(previousValue, addedPostTitle);
    }
}
