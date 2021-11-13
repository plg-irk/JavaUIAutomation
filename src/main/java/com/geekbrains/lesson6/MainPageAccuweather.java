package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageAccuweather extends BaseViewAccuweather {

    public MainPageAccuweather(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='query']")
    WebElement optionLocation;

    public void setOptionLocation(String option) {
        optionLocation.sendKeys(option);
    }

    @FindBy(css = "div[data-link='/web-api/three-day-redirect?key=292712']")
    WebElement selectOptionClick;

    public void setSelectOptionClick() {
        selectOptionClick.click();
    }


}
