package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageAccuweather extends BaseViewAccuweather {

    public MainPageAccuweather(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='query']")
    WebElement optionLocation;

    @Step("Вводим местоположение")
    public void setOptionLocation(String option) {
        optionLocation.sendKeys(option);
    }

    @FindBy(css = "div[data-link='/web-api/three-day-redirect?key=292712']")
    WebElement selectOptionClick;

    @Step("Выбираем местоположение")
    public void setSelectOptionClick() {
        selectOptionClick.click();
    }


}
