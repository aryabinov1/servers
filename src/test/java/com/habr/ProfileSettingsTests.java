package com.habr;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.habr.CommonFunctions.loginCheckAndSignIn;

public class ProfileSettingsTests extends Prepare {
    @Test(testName = "Should change name")
    public void changeNameField () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.NameFieldChangingAndSubmit();
        String previousValue = profileSettingsPage.getNameFieldText();
        driver.navigate().refresh();
        Assert.assertEquals(previousValue, profileSettingsPage.getNameFieldText());
    }

    @Test(testName = "Should change specialization")
    public void changeSpecializationField () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SpecializationFieldChangingAndSubmit();
        String previousValue = profileSettingsPage.getSpecializationFieldText();
        driver.navigate().refresh();
        Assert.assertEquals(previousValue, profileSettingsPage.getSpecializationFieldText());
    }

    @Test(testName = "Should change gender selector")
    public void changeGenderSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        String previousValue = profileSettingsPage.getGenderFieldText();
        driver.navigate().refresh();
        Assert.assertEquals(previousValue, profileSettingsPage.getGenderFieldText());
    }

    @Test(testName = "Should not change day field if day and year are not selected")
    public void notChangeDaySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomBirthdayAndSubmit(true, false, false);
        String previousValue = profileSettingsPage.getDayFieldText();
        driver.navigate().refresh();
        Assert.assertNotEquals(previousValue, "Число");
    }

    @Test(testName = "Should not change month field if day and year are not selected")
    public void notChangeMonthSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomBirthdayAndSubmit(false, true, false);
        String previousValue = profileSettingsPage.getMonthFieldText();
        driver.navigate().refresh();
        Assert.assertNotEquals(previousValue, "Месяц");
    }

    @Test(testName = "Should not change year field if month and day are not selected")
    public void notChangeYearSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomBirthdayAndSubmit(false, false, true);
        String previousValue = profileSettingsPage.getYearFieldText();
        driver.navigate().refresh();
        Assert.assertNotEquals(previousValue, "Год");
    }

    @Test(testName = "Should change day field if month and year are selected")
    public void changeDaySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomBirthdayAndSubmit(true, true, true);
        String previousValue = profileSettingsPage.getDayFieldText();
        driver.navigate().refresh();
        Assert.assertEquals(previousValue, profileSettingsPage.getDayFieldText());
    }

    @Test(testName = "Should change month field if day and year are selected")
    public void changeMonthSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomBirthdayAndSubmit(true, true, true);
        String previousValue = profileSettingsPage.getMonthFieldText();
        driver.navigate().refresh();
        Assert.assertEquals(previousValue, profileSettingsPage.getMonthFieldText());
    }

    @Test(testName = "Should change year field if month and day are selected")
    public void changeYearSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomBirthdayAndSubmit(true, true, true);
        String previousValue = profileSettingsPage.getYearFieldText();
        driver.navigate().refresh();
        Assert.assertEquals(previousValue, profileSettingsPage.getYearFieldText());
    }

    @Test(testName = "Should change country")
    public void changeCountrySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.loadingCountryWait();
        profileSettingsPage.SelectRandomCountrySelectorItem();
        profileSettingsPage.submitButtonClickAndSuccessfulWait();
        String previousValue = profileSettingsPage.getCountryFieldText();
        driver.navigate().refresh();
        profileSettingsPage.loadingCountryWait();
        Assert.assertEquals(previousValue, profileSettingsPage.getCountryFieldText());
    }

    @Test(testName = "Should change region")
    public void changeRegionSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.loadingCountryWait();
        profileSettingsPage.SelectRandomCountrySelectorItem();
        profileSettingsPage.loadingRegionWait();
        profileSettingsPage.SelectRandomRegionSelectorItem();
        profileSettingsPage.submitButtonClickAndSuccessfulWait();
        String previousValue = profileSettingsPage.getRegionFieldText();
        driver.navigate().refresh();
        profileSettingsPage.loadingRegionWait();
        Assert.assertEquals(previousValue, profileSettingsPage.getRegionFieldText());
    }

    @Test(testName = "Should change city")
    public void changeCitySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.loadingCountryWait();
        profileSettingsPage.SelectRandomCountrySelectorItem();
        profileSettingsPage.loadingRegionWait();
        profileSettingsPage.SelectRandomRegionSelectorItem();
        profileSettingsPage.loadingCityWait();
        profileSettingsPage.SelectRandomCitySelectorItem();
        profileSettingsPage.submitButtonClickAndSuccessfulWait();
        String previousValue = profileSettingsPage.getCityFieldText();
        driver.navigate().refresh();
        profileSettingsPage.loadingCityWait();
        Assert.assertEquals(previousValue, profileSettingsPage.getCityFieldText());
    }
}
