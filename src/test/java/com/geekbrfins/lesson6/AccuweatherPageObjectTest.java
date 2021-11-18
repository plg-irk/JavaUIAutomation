package com.geekbrfins.lesson6;

import com.geekbrains.lesson6.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AccuweatherPageObjectTest {

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
        driver.get("https://www.accuweather.com/");
    }

    @Test
    void testAccuweather() {

        new MainPageAccuweather(driver).setOptionLocation("Иркутск");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "div[data-link='/web-api/three-day-redirect?key=292712']")));
        new MainPageAccuweather(driver).setSelectOptionClick();

        ((JavascriptExecutor) driver).executeScript(
                " var elem = document.getElementById('top');\n" +
                        "  elem.remove();");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                ".header-loc")));
        Assertions.assertEquals("Иркутск, Иркутск",
                new IrkutskPage(driver).setCityName());

    }

    @AfterEach
    void tearDown() { driver.quit();}

}
