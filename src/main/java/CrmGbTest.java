import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrmGbTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));

        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Проекты']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Мои проекты']")).click();

        driver.findElement(By.xpath("//div[contains(text(), 'Создан в')]")).click();

        Select selectDataPeriod = new Select(driver.findElement(By.cssSelector("[name=\"createdAt\"]")));
        selectDataPeriod.selectByVisibleText("больше чем");

        driver.findElement(By.cssSelector(
                ".filter-start-date input[data-toggle=\"dropdown\"] ")).sendKeys("01.10.2021");

        driver.findElement(By.xpath("//button[contains(text(), 'Обновить')]")).click();

        List<WebElement> nameProject = driver.findElements(By.cssSelector(
                ".string-cell.grid-cell.grid-body-cell.grid-body-cell-name"));
        System.out.println("На странице" + nameProject.size() + "проектов");

        Thread.sleep(5000);
        driver.quit();
    }

    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
