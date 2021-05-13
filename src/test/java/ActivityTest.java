import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ActivityTest {
    static WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D://Program//selenium-java//drivers//chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DisplayName("Google Search Test")
    @Test
    public void script1(){
        Activity1 googlePage = Activity1.get(driver);
        googlePage.acceptCookies();
        googlePage.searchFor("Software Testing");
        googlePage.close();
    }

    @DisplayName("Actitime Try Free Test")
    @Test
    public void script2(){
        Activity2 actitimePage = Activity2.get(driver);
        actitimePage.pressButton();
        actitimePage.enterInfo("John", "Doe", "JohnDoe@hotmail.com", "Test av IT AB");
        actitimePage.close();
    }

    @DisplayName("Adlibris Book Order Test")
    @Test
    public void script3(){
        Activity3 adlibrisPage = Activity3.get(driver);
        adlibrisPage.searchForBook("praktisk mjukvarutestning");
        adlibrisPage.clickOnBook();
        adlibrisPage.addToCart();
        adlibrisPage.checkOut();
        adlibrisPage.close();

    }
}
