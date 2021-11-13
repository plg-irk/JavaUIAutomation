package com.geekbrfins.lesson6;

import com.geekbrains.lesson6.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObjectTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
    }

    @Test
    void loginTest() throws InterruptedException {
        new LoginPage(driver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();

        new MainPage(driver).navigationBar.openNavBarItem("Проекты");
        new ExpensesSubMenu(driver).setExpensesSubMenuItemClick();

        new ProjectPage(driver).setButtonMyProjectClick();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[contains(text(), 'Создан в')]")));
        new MyProjectPage(driver).setCreateElementClick();

        new MyProjectPage(driver)
                .selectAtElement("больше чем")
                .setInputData("01.10.2021")
                .buttonReloadClick();

        Assertions.assertEquals("более чем 01.10.2021", driver.findElement(
                By.xpath("//strong[contains(text(), 'более чем 01.10.2021')]")).getText());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
