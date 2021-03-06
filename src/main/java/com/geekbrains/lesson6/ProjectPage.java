package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BaseViewCRM {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Мои проекты']")
    public WebElement buttonMyProject;

    @Step("Выбираем страницу 'Мои проекты'")
    public void setButtonMyProjectClick() {
        buttonMyProject.click();
    }
}
