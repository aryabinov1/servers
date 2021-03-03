package com.habr;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.habr.CommonFunctions.loginCheckAndSignIn;

public class ProfileSettingsTests extends Prepare{
    @Test(testName = "Should change name")
    public void changeNameField () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
//        mainPage.loginButtonClick();
//        loginPage.LogInFieldsFillingAndSubmit(LOGIN, PASSWORD);
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.NameFieldChangingAndSubmit();
        String previousValue = profileSettingsPage.getNameFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getNameFieldText());
    }

    @Test(testName = "Should change specialization")
    public void changeSpecializationField () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SpecializationFieldChangingAndSubmit();
        String previousValue = profileSettingsPage.getSpecializationFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getSpecializationFieldText());
    }

    @Test(testName = "Should change gender selector")
    public void changeGenderSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        String previousValue = profileSettingsPage.getGenderFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getGenderFieldText());
    }

    @Test(testName = "Should not change day field if day and year are not selected")
    public void notChangeDaySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomDaySelectorItem(true);
        profileSettingsPage.SelectRandomMonthSelectorItem(false);
        profileSettingsPage.SelectRandomYearSelectorItem(false);
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getDayFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertNotEquals(previousValue, "Число");
    }

    @Test(testName = "Should not change month field if day and year are not selected")
    public void notChangeMonthSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomDaySelectorItem(false);
        profileSettingsPage.SelectRandomMonthSelectorItem(true);
        profileSettingsPage.SelectRandomYearSelectorItem(false);
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getMonthFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertNotEquals(previousValue, "Месяц");
    }

    @Test(testName = "Should not change year field if month and day are not selected")
    public void notChangeYearSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomDaySelectorItem(false);
        profileSettingsPage.SelectRandomMonthSelectorItem(false);
        profileSettingsPage.SelectRandomYearSelectorItem(true);
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getYearFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertNotEquals(previousValue, "Год");
    }

    @Test(testName = "Should change day field if month and year are selected")
    public void changeDaySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomDaySelectorItem(true);
        profileSettingsPage.SelectRandomMonthSelectorItem(true);
        profileSettingsPage.SelectRandomYearSelectorItem(true);
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getDayFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getDayFieldText());
    }

    @Test(testName = "Should change month field if day and year are selected")
    public void changeMonthSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomDaySelectorItem(true);
        profileSettingsPage.SelectRandomMonthSelectorItem(true);
        profileSettingsPage.SelectRandomYearSelectorItem(true);
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getMonthFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getMonthFieldText());
    }

    @Test(testName = "Should change year field if month and day are selected")
    public void changeYearSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomDaySelectorItem(true);
        profileSettingsPage.SelectRandomMonthSelectorItem(true);
        profileSettingsPage.SelectRandomYearSelectorItem(true);
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getYearFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getYearFieldText());
    }

    @Test(testName = "Should change country")
    public void changeCountrySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomCountrySelectorItem();
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getCountryFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getCountryFieldText());
    }

    @Test(testName = "Should change region")
    public void changeRegionSelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomCountrySelectorItem();
        profileSettingsPage.loadingWait();
        profileSettingsPage.SelectRandomRegionSelectorItem();
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getRegionFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getRegionFieldText());
    }

    @Test(testName = "Should change city")
    public void changeCitySelector () {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProfileSettingsPage profileSettingsPage = PageFactory.initElements(driver, ProfileSettingsPage.class);
        mainPage.open();
        loginCheckAndSignIn();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
        profileSettingsPage.SelectRandomCountrySelectorItem();
        profileSettingsPage.loadingWait();
        profileSettingsPage.SelectRandomRegionSelectorItem();
        profileSettingsPage.loadingWait();
        profileSettingsPage.SelectRandomCitySelectorItem();
        profileSettingsPage.submitButtonClickAndSuccessfullWait();
        String previousValue = profileSettingsPage.getCityFieldText();
        mainPage.open();
        mainPage.userButtonClick();
        mainPage.settingsButtonClick();
//        profileSettingsPage.SelectRandomGenderItemAndSubmit();
        Assert.assertEquals(previousValue, profileSettingsPage.getCityFieldText());
    }

//    @Test(testName = "Should log out from the site")
//    public void logout() {
//
//        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        mainPage.open();
//        loginCheckAndSignIn();
//        mainPage.userButtonClick();
//        mainPage.signOutButtonClick();
//        Assert.assertTrue(mainPage.loginButtonIsDisplayed());
//    }
}
