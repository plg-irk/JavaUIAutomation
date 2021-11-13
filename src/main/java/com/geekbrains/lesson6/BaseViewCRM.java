package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseViewCRM {

    WebDriver driver;

    public BaseViewCRM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
