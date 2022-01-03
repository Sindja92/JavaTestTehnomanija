package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TehnomanijaHelper
{

    public void loginHelper (String email, String password, WebDriverWait wdWait, WebDriver driver)
    {
        driver.get("https://www.tehnomanija.rs");
        WebElement profile = driver.findElement(By.className("thm-user-outline"));
        profile.click();
        WebElement tehemail = driver.findElement(By.name("email"));
        tehemail.sendKeys(email);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
        WebElement tehpassword = driver.findElement(By.name("password"));
        tehpassword.sendKeys(password);
        WebElement submit = driver.findElement(By.name("Submit"));
        submit.click();
    }

    public void searchboxHelper (String title, WebDriver driver)
    {
        WebElement searchbox = driver.findElement(By.id("fnc-search_field"));
        searchbox.sendKeys(title);
        WebElement searchButton = driver.findElement(By.id("search_btn"));
        searchButton.click();
    }

    public void filterHelper (WebDriver driver)
    {
        driver.get("https://www.tehnomanija.rs");
        WebElement scroll = driver.findElement(By.xpath("/html/body/header/div[3]/div/div[2]/div/div[1]"));
        Actions scrolling = new Actions(driver);
        scrolling.moveToElement(scroll).perform();
        WebElement scrolldown = driver.findElement(By.xpath("/html/body/header/div[3]/div/div[2]/div/div[2]/div/div[6]/a"));
        scrolling.moveToElement(scrolldown).perform();
        WebElement filter = driver.findElement(By.xpath("/html/body/header/div[3]/div/div[2]/div/div[2]/div/div[6]/ul/span[2]/li[1]/a"));
        filter.click();
        WebElement filter32 = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[3]/span[2]/span[2]/a/i"));
        scrolling.moveToElement(filter32).perform();
    }

    public void priceIncreasingHelper (WebDriver driver, WebDriverWait wdWait)
    {
        WebElement button = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]"));
        button.click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/div/div[4]")));
        WebElement priceIncreasing = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/div/div[4]"));
        priceIncreasing.click();
    }
}
