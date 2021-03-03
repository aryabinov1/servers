package com.habr;

import com.beust.jcommander.internal.Console;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private JavascriptExecutor js;

    public ProfileSettingsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(className = "h-form")
    private WebElement settingsSection;

    @FindBy(className = "tm-button_submit")
    private WebElement submitButton;

//    @FindBy(className = "message_successfull")
//    private WebElement messageSuccessfull;

    private By messageSuccessfull = By.className("message_successfull");
    // TODO Переделать xpath
    private By genderSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[1]/div/div/select");
    // TODO Переделать xpath
    private By nameField = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/div/div/input");
    // TODO Переделать xpath
    private By specializationField = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[1]/div[1]/div[3]/div/div/input");
    // TODO Переделать xpath
    private By daySelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[1]/select");
    // TODO Переделать xpath
    private By monthSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[2]/select");
    // TODO Переделать xpath
    private By yearSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[3]/select");
    // TODO Переделать xpath
    private By countrySelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[3]/div/div/div[1]/select");
    // TODO Переделать xpath
    private By regionSelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[3]/div/div/div[2]/select");
    // TODO Переделать xpath
    private By citySelector = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/form/div[3]/div/div/div[3]/select");

    public void messageSuccessfullWait () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccessfull));
    }

    // h-form-select h-form-controls__item h-form-select_large h-form-select_is-loading h-form-select_is-disabled
    public void loadingCountryWait() {
        this.loadingWait(countrySelector);
    }

    public void loadingRegionWait() {
        this.loadingWait(regionSelector);
    }

    public void loadingCityWait() {
        this.loadingWait(citySelector);
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

    public boolean messageSuccessfullIsDisplayed() {
        this.messageSuccessfullWait();
        return settingsSection.findElement(messageSuccessfull).isDisplayed();
    }

//    public void optionNotEmpty(By locator) {
//        List<WebElement> dropDownItem;
//        do {
//        Select dropdown = new Select(settingsSection.findElement(locator));
//        dropDownItem = dropdown.getOptions();
//        } while (dropDownItem.size() != 0);
//    }

    public void NameFieldChangingAndSubmit() {
        settingsSection.findElement(nameField).clear();
        settingsSection.findElement(nameField).sendKeys(generateRandomString(10));
        this.submitButton.click();
    }

    public void submitButtonClickAndSuccessfullWait() {
        this.submitButton.click();
        this.messageSuccessfullWait();
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
        if (selectedValue) {
            Select dropdown = new Select(settingsSection.findElement(daySelector));
            List<WebElement> dropDownItem = dropdown.getOptions();
            do {
                Random rand = new Random();
                int index = rand.nextInt(dropDownItem.size() - 1);
                dropdown.selectByIndex(index);
            } while (settingsSection.findElement(daySelector).getText().equals("Число"));

        } else {
            Select dropdown = new Select(settingsSection.findElement(daySelector));
            List<WebElement> dropDownItem = dropdown.getOptions();
//            Random rand = new Random();
//            int index = rand.nextInt(dropDownItem.size() - 1);
            dropdown.selectByIndex(0);
        }
    }

    public void SelectRandomMonthSelectorItem(Boolean selectedValue) {
        if (selectedValue) {
            Select dropdown = new Select(settingsSection.findElement(monthSelector));
            List<WebElement> dropDownItem = dropdown.getOptions();
            do {
                Random rand = new Random();
                int index = rand.nextInt(dropDownItem.size() - 1);
                dropdown.selectByIndex(index);
            } while (settingsSection.findElement(monthSelector).getText().equals("Месяц"));

        } else {
            Select dropdown = new Select(settingsSection.findElement(monthSelector));
            List<WebElement> dropDownItem = dropdown.getOptions();
//            Random rand = new Random();
//            int index = rand.nextInt(dropDownItem.size() - 1);
            dropdown.selectByIndex(0);
        }
    }

    public void SelectRandomYearSelectorItem(Boolean selectedValue) {
        if (selectedValue) {
            Select dropdown = new Select(settingsSection.findElement(yearSelector));
            List<WebElement> dropDownItem = dropdown.getOptions();
            do  {
                Random rand = new Random();
                int index = rand.nextInt(dropDownItem.size() - 1);
                dropdown.selectByIndex(index);
            } while (settingsSection.findElement(yearSelector).getText().equals("Год"));

        } else {
            Select dropdown = new Select(settingsSection.findElement(yearSelector));
            List<WebElement> dropDownItem = dropdown.getOptions();
//            Random rand = new Random();
//            int index = rand.nextInt(dropDownItem.size() - 1);
            dropdown.selectByIndex(0);
        }
    }

    public void SelectRandomCountrySelectorItem() {
        Select dropdown = new Select(settingsSection.findElement(countrySelector));
        List<WebElement> dropDownItem = dropdown.getOptions();
        do  {
            Random rand = new Random();
            int index = rand.nextInt(9);
//            js.executeScript("arguments[0].scrollIntoView(true);", this.settingsSection.findElement(countrySelector));
            dropdown.selectByIndex(index);
//            dropdown.selectByVisibleText("Австрия");
        } while (settingsSection.findElement(countrySelector).getText().equals("Страна"));
    }

    public void SelectRandomRegionSelectorItem() {
        Select dropdown = new Select(settingsSection.findElement(regionSelector));
        List<WebElement> dropDownItem = dropdown.getOptions();
        do  {
            Random rand = new Random();
            int index = rand.nextInt(dropDownItem.size() - 1);
            dropdown.selectByIndex(index);
        } while (settingsSection.findElement(regionSelector).getText().equals("Регион"));
    }

    public void SelectRandomCitySelectorItem() {
        Select dropdown = new Select(settingsSection.findElement(citySelector));
        List<WebElement> dropDownItem = dropdown.getOptions();
        do  {
            Random rand = new Random();
            int index = rand.nextInt(dropDownItem.size() - 1);
            dropdown.selectByIndex(index);
        } while (settingsSection.findElement(citySelector).getText().equals("Город"));
    }
}
