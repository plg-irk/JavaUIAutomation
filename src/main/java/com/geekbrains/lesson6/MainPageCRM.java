package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;

public class MainPageCRM extends BaseViewCRM {
    public NavigationBar navigationBar;

    public MainPageCRM(WebDriver driver) {
        super(driver);
        navigationBar = new NavigationBar(driver);
    }
}
