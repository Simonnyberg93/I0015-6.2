import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActivityTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","D://Program//selenium-java//drivers//chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void script1(){
        driver.get("https://www.google.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("L2AGLb")).click();
        // driver.findElement(By.id("zV9nZe")).click();
        driver.findElement(By.name("q")).sendKeys("Software Testing");
        driver.findElement(By.name("q")).submit();
    }

    @Test
    public void script2(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1900, 1000));

        driver.get("https://www.actitime.com/");
        driver.findElement(By.linkText("Try Free")).click();

        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("email")).sendKeys("JohnDoe@hotmail.com");
        driver.findElement(By.id("company")).sendKeys("Test av IT AB");
    }

    @Test
    public void script3(){
        driver.get("https://Adlibris.Com/se/");
        driver.findElement(By.id("q")).sendKeys("praktisk mjukvarutestning");
        driver.findElement(By.id("q")).submit();
        driver.findElement(By.linkText("Praktisk mjukvarutestning")).click();
        driver.findElement(By.cssSelector(".product__add-to-cart:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Till kassan")));
        driver.findElement(By.cssSelector(".notifications-bar__added-to-cart__to-checkout")).click();
    }
}
