package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class BaseHelper
{
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public JavascriptExecutor js = (JavascriptExecutor) driver;
}
