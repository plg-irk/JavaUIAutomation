package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpensesSubMenu extends BaseViewCRM {

    public ExpensesSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Проекты']")
    public WebElement expensesSubMenuItem;

    @Step("Активируем подменю меню 'Проекты'")
    public void setExpensesSubMenuItemClick(){
        expensesSubMenuItem.click();
    }

}
