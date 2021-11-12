package com.geekbrfins.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestHomeWork5 {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        login(driver);
    }

    @Test
    void crmGbTest() throws InterruptedException {

        driver.get("https://crm.geekbrains.space/");

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));

        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Проекты']")).click();

        driver.findElement(By.xpath("//a[.='Мои проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[contains(text(), 'Создан в')]")));
        driver.findElement(By.xpath("//div[contains(text(), 'Создан в')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "[name=\"createdAt\"]")));
        Select selectDataPeriod = new Select(driver.findElement(By.cssSelector(
                "[name=\"createdAt\"]")));
        selectDataPeriod.selectByVisibleText("больше чем");

        driver.findElement(By.cssSelector(
                ".filter-start-date input[data-toggle=\"dropdown\"] ")).sendKeys("01.10.2021");

        driver.findElement(By.xpath("//button[contains(text(), 'Обновить')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//span[contains(text(), 'Наименование')]")));

        String st = "более чем 01.10.2021";
        String st1 = driver.findElement(By.xpath("//strong[contains(text(), 'более чем 01.10.2021')]")).getText();
        Assertions.assertEquals(st, st1);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login");
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

}




