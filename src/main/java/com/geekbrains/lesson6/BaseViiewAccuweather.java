package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class BaseViewAccuweather {

    WebDriver driver;

    public BaseViewAccuweather(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}