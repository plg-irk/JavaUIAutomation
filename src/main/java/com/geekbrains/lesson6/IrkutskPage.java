package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IrkutskPage extends BaseViewAccuweather {

    public IrkutskPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".header-loc")
    WebElement cityName;

    public String setCityName() {
        return cityName.getText();
    }


}
