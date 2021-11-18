package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MyProjectPage extends BaseViewCRM {
    public MyProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(), 'Создан в')]")
    public WebElement createElement;

    @Step("Выбираем поле 'Создан в'")
    public void setCreateElementClick() {
        createElement.click();
    }

    @FindBy(css = "[name='createdAt']")
    public WebElement selectAtElement;

    public MyProjectPage selectAtElement(String option) {
        new Select(selectAtElement).selectByVisibleText(option);
        return this;
    }

    @FindBy(css = ".filter-start-date input[data-toggle='dropdown']")
    public WebElement inputData;

    @Step("Вводим дату")
    public MyProjectPage setInputData(String option) {
        inputData.sendKeys(option);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Обновить')]")
    public WebElement buttonReload;

    @Step("Нажимаем на кнопку 'Обновить'")
    public void buttonReloadClick() {
        buttonReload.click();
    }

}
