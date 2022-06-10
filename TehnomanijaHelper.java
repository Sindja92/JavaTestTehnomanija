package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TehnomanijaHelper
{

    public void loginHelper (String email, String password, WebDriverWait wdWait, WebDriver driver)
    {
        driver.get("https://www.tehnomanija.rs");
        WebElement signUpButton = driver.findElement(By.className("thm-user-outline"));
        signUpButton.click();
        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.sendKeys(email);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
    }

    public void searchboxHelper (String term, WebDriver driver)
    {
        WebElement searchField = driver.findElement(By.id("fnc-search_field"));
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.ENTER);
    }

    public void filterHelper (WebDriver driver, WebDriverWait wdWait, JavascriptExecutor js)
    {
        WebElement cookieCheckBox1 = driver.findElement(By.id("permanent_cookies"));
        cookieCheckBox1.click();
        WebElement cookieCheckBox2 = driver.findElement(By.id("statistics_cookies"));
        cookieCheckBox2.click();
        WebElement cookieCheckBox3 = driver.findElement(By.id("marketing_cookies"));
        cookieCheckBox3.click();
        WebElement cookieAgreementButton = driver.findElement(By.className("fnc-accept-cookies"));
        cookieAgreementButton.click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class=\"thm-menu-hamburger\"]")));
        WebElement hamburgerMenu = driver.findElement(By.cssSelector("[class=\"thm-menu-hamburger\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hamburgerMenu).perform();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[href=\"https://www.tehnomanija.rs/tv-i-video\"]")));
        WebElement TvAndVideo = driver.findElement(By.cssSelector("[href=\"https://www.tehnomanija.rs/tv-i-video\"]"));
        actions.moveToElement(TvAndVideo).perform();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[3]/div/div[2]/div/div[2]/div/div[5]/ul/span[4]/li[2]/a")));
        WebElement filter32 = driver.findElement(By.xpath("/html/body/header/div[3]/div/div[2]/div/div[2]/div/div[5]/ul/span[4]/li[2]/a"));
        filter32.click();
        WebElement filterClear24 = driver.findElement(By.className("dijagonala-ekrana24-inca"));
        js.executeScript("arguments[0].scrollIntoView({block: \"center\", inline: \"nearest\"});", filterClear24);
        filterClear24.click();
    }

    public void priceIncreasingHelper (WebDriver driver, WebDriverWait wdWait)
    {
        WebElement sortingButton = driver.findElement(By.className("sort-products"));
        sortingButton.click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-value=\"price_asc\"]")));
        WebElement priceIncreasing = driver.findElement(By.cssSelector("[data-value=\"price_asc\"]"));
        priceIncreasing.click();
    }
}
