package com.habr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static com.habr.CommonFunctions.*;

public class ProfileSettingsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProfileSettingsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(className = "h-form")
    private WebElement settingsSection;

    @FindBy(className = "tm-button_submit")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[3]")
    private WebElement locationSection;

    final private By messageSuccessfull = By.className("message_successfull");
    // TODO Переделать xpath
    final private By genderSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[1]/div/div/select");
    // TODO Переделать xpath
    final private By nameField = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/div/div/input");
    // TODO Переделать xpath
    final private By specializationField = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[1]/div[1]/div[3]/div/div/input");
    // TODO Переделать xpath
    final private By daySelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[1]/select");
    // TODO Переделать xpath
    final private By monthSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[2]/select");
    // TODO Переделать xpath
    final private By yearSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[3]/select");
    // TODO Переделать xpath
    final private By countrySelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[3]/div/div/div[1]/select");
    // TODO Переделать xpath
    final private By regionSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[3]/div/div/div[2]/select");
    // TODO Переделать xpath
    final private By citySelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[3]/div/div/div[3]/select");

    public void loadingCountryWait() {
        if (!settingsSection.findElement(countrySelector).isEnabled()) {
            this.loadingWait(countrySelector);
        }
    }

    public void loadingRegionWait() {
        if (!settingsSection.findElement(regionSelector).isEnabled()) {
            this.loadingWait(regionSelector);
        }
    }

    public void loadingCityWait() {
        if (!settingsSection.findElement(citySelector).isEnabled()) {
            this.loadingWait(citySelector);
        }
    }

    public void loadingWait(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getCountryFieldText() {
        return this.getElementText(countrySelector);
    }

    public String getRegionFieldText() {
        return this.getElementText(regionSelector);
    }

    public String getCityFieldText() {
        return this.getElementText(citySelector);
    }

    public String getYearFieldText() {
        return this.getElementText(yearSelector);
    }

    public String getMonthFieldText() {
        return this.getElementText(monthSelector);
    }

    public String getDayFieldText() {
        return this.getElementText(daySelector);
    }

    public String getNameFieldText() {
        return this.getElementText(nameField);
    }

    public String getSpecializationFieldText() {
        return this.getElementText(specializationField);
    }

    public String getGenderFieldText() {
        return this.getElementText(genderSelector);
    }

    public String getElementText(By locator) {
        return this.settingsSection.findElement(locator).getText();
    }

    public void messageSuccessfulWait() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccessfull));
    }

    public void NameFieldChangingAndSubmit() {
        settingsSection.findElement(nameField).clear();
        settingsSection.findElement(nameField).sendKeys(generateRandomString(10));
        this.submitButton.click();
    }

    public void submitButtonClickAndSuccessfulWait() {
        this.submitButton.click();
        this.messageSuccessfulWait();
    }

    public void SpecializationFieldChangingAndSubmit() {
        settingsSection.findElement(specializationField).clear();
        settingsSection.findElement(specializationField).sendKeys(generateRandomString(10));
        this.submitButton.click();
    }

    public void SelectRandomGenderItemAndSubmit() {
        Select dropdown = new Select(settingsSection.findElement(genderSelector));
        List<WebElement> dropDownItem = dropdown.getOptions();
        Random rand = new Random();
        int index = rand.nextInt(dropDownItem.size()-1);
        dropdown.selectByIndex(index);
        this.submitButton.click();
    }

    public void SelectRandomDaySelectorItem(Boolean selectedValue) {
        Select dropdown = new Select(settingsSection.findElement(daySelector));
        if (selectedValue) {
            List<WebElement> dropDownItem = dropdown.getOptions();
            do {
                Random rand = new Random();
                int index = rand.nextInt(dropDownItem.size() - 1);
                dropdown.selectByIndex(index);
            } while (settingsSection.findElement(daySelector).getText().equals("Число"));

        } else {
            dropdown.selectByIndex(0);
        }
    }

    public void SelectRandomMonthSelectorItem(Boolean selectedValue) {
        Select dropdown = new Select(settingsSection.findElement(monthSelector));
        if (selectedValue) {
            List<WebElement> dropDownItem = dropdown.getOptions();
            do {
                Random rand = new Random();
                int index = rand.nextInt(dropDownItem.size() - 1);
                dropdown.selectByIndex(index);
            } while (settingsSection.findElement(monthSelector).getText().equals("Месяц"));

        } else {
            dropdown.selectByIndex(0);
        }
    }

    public void SelectRandomYearSelectorItem(Boolean selectedValue) {
        Select dropdown = new Select(settingsSection.findElement(yearSelector));
        if (selectedValue) {
            List<WebElement> dropDownItem = dropdown.getOptions();
            do  {
                Random rand = new Random();
                int index = rand.nextInt(dropDownItem.size() - 1);
                dropdown.selectByIndex(index);
            } while (settingsSection.findElement(yearSelector).getText().equals("Год"));

        } else {
            dropdown.selectByIndex(0);
        }
    }

    public void SelectRandomBirthdayAndSubmit(Boolean day, Boolean month, Boolean year) {
        this.SelectRandomDaySelectorItem(day);
        this.SelectRandomMonthSelectorItem(month);
        this.SelectRandomYearSelectorItem(year);
        this.submitButtonClickAndSuccessfulWait();
    }

    public void SelectRandomCountrySelectorItem() {
        Select dropdown = new Select(settingsSection.findElement(countrySelector));
        Random rand = new Random();
        int index = rand.nextInt(9) + 1;
        dropdown.selectByIndex(index);
    }

    public void SelectRandomRegionSelectorItem() {
        Select dropdown = new Select(settingsSection.findElement(regionSelector));
        List<WebElement> dropDownItem = dropdown.getOptions();
        Random rand = new Random();
        int index = rand.nextInt(dropDownItem.size() - 2) + 1;
        dropdown.selectByIndex(index);
    }

    public void SelectRandomCitySelectorItem() {
        Select dropdown = new Select(settingsSection.findElement(citySelector));
        List<WebElement> dropDownItem = dropdown.getOptions();

        Random rand = new Random();
        int index = rand.nextInt(dropDownItem.size() - 2) + 1;
        dropdown.selectByIndex(index);
    }
}
