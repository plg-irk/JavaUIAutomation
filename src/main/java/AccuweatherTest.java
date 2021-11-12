import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AccuweatherTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.accuweather.com/");

        driver.findElement(By.cssSelector("[name='query']")).sendKeys("Иркутск");
        driver.findElement(By.cssSelector("div[data-link='/web-api/three-day-redirect?key=292712']")).click();

        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript(" var elem = document.getElementById('top');\n" +
                "  elem.remove();");


        Thread.sleep(10000);
        driver.quit();
    }
}
