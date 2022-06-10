package tests;

import helpers.TehnomanijaHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;



public class Tehnomanija extends BaseTest
{
    @Before
    public void tehnomanijaInIt()
    {
        try {
            FillProps();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    TehnomanijaHelper tehnomanijaObj = new TehnomanijaHelper();

    public static void FillProps () throws IOException
    {
        Properties tehnomanijaProp = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Sindja\\IdeaProjects\\javaSelenium\\src\\main\\resources\\tehnomanija.properties");
        tehnomanijaProp.load(fis);
        validEmail = tehnomanijaProp.getProperty("validEmail");
        validPassword = tehnomanijaProp.getProperty("validPassword");
        wrongEmail = tehnomanijaProp.getProperty("wrongEmail");
        wrongPassword = tehnomanijaProp.getProperty("wrongPassword");
        searchTerm = tehnomanijaProp.getProperty("searchTerm");
    }

    private static String validEmail;
    private static String validPassword;
    private static String wrongEmail;
    private static String wrongPassword;
    private static String searchTerm;


    @Test
    public void positiveLogin ()
    {
        tehnomanijaObj.loginHelper(validEmail, validPassword, wdWait, driver);
        WebElement logged = driver.findElement(By.cssSelector("[class=\"welcome-txt-account desktop\"]"));
        System.out.println(logged.getText());
        Assert.assertTrue(logged.getText().contains("Dobro došli"));
    }

    @Test
    public void negativeLoginBoth ()
    {
        tehnomanijaObj.loginHelper(wrongEmail, wrongPassword, wdWait, driver);
        WebElement message = driver.findElement(By.className("message"));
        Assert.assertTrue(message.getText().contains("Pogrešan email ili lozinka!"));
    }

    @Test
    public void negativeLoginEmail ()
    {
        tehnomanijaObj.loginHelper(wrongEmail, validPassword, wdWait, driver);
        WebElement message = driver.findElement(By.className("message"));
        Assert.assertTrue(message.getText().contains("Pogrešan email ili lozinka!"));
    }

    @Test
    public void negativeLoginPassword ()
    {
        tehnomanijaObj.loginHelper(wrongEmail, wrongPassword, wdWait, driver);
        WebElement message = driver.findElement(By.className("message"));
        Assert.assertTrue(message.getText().contains("Pogrešan email ili lozinka!"));
    }

    @Test
    public void resultName ()
    {
        driver.get("https://www.tehnomanija.rs");
        tehnomanijaObj.searchboxHelper(searchTerm, driver);
        List<WebElement> results = driver.findElements(By.className("product-name-grid"));
        for(WebElement result:results)
        {
            System.out.println(result.getText().toLowerCase());
            Assert.assertTrue(result.getText().toLowerCase().contains("samsung"));
        }
    }

    @Test
    public void filter ()
    {
        driver.get("https://www.tehnomanija.rs");
        tehnomanijaObj.filterHelper(driver,wdWait,js);
        List<WebElement> searchResults = driver.findElements(By.className("products-wrap"));
        for (WebElement element:searchResults)
        {
            System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains("32\""));
        }

    }

    @Test
    public void priceIncreasing ()
    {
        driver.get("https://www.tehnomanija.rs");
        tehnomanijaObj.searchboxHelper(searchTerm, driver);
        tehnomanijaObj.priceIncreasingHelper(driver, wdWait);
        List<WebElement> searchResults = driver.findElements(By.className("price"));
        int startingPrice = 0;
        boolean ok = true;
        for (WebElement element:searchResults)
        {
            String text = element.getText().replace(".","").replace(" RSD","");
            int higherPrice = Integer.parseInt(text);
            System.out.println(higherPrice);
            ok = ok && (higherPrice >= startingPrice);
            if (!ok) break;
            startingPrice = higherPrice;
        }
        Assert.assertTrue(ok);
    }
}
