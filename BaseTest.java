package tests;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wdWait;

    @Before
    public void testInit() {
        driver = new ChromeDriver();
        wdWait  = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @After
    public void testTearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}