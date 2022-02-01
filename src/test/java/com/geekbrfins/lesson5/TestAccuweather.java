package com.geekbrfins.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAccuweather {

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
    }

    @Test
    void accuWeatherTest() throws InterruptedException {

        driver.get("https://www.accuweather.com/");

        driver.findElement(By.cssSelector("[name='query']")).sendKeys("Иркутск");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "div[data-link='/web-api/three-day-redirect?key=292712']")));
        driver.findElement(By.cssSelector(
                "div[data-link='/web-api/three-day-redirect?key=292712']")).click();

        ((JavascriptExecutor) driver).executeScript(" var elem = document.getElementById('top');\n" +
                "  elem.remove();");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                ".header-loc")));

        Assertions.assertEquals("Иркутск, Иркутск",
                driver.findElement(By.cssSelector(".header-loc")).getText());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}


