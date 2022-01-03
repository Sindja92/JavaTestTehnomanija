package tests;


import helpers.TehnomanijaHelper;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;



public class Tehnomanija extends BaseTest
{
    TehnomanijaHelper obj = new TehnomanijaHelper();

    @Test
    public void positiveLogin ()
    {
        obj.loginHelper("milos.sindjelic1992@gmail.com", "Milos.992", wdWait, driver);
        WebElement logged = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]"));
        Assert.assertTrue(logged.getText().contains("Dobro došli"));
    }

    @Test
    public void negativeLoginBoth ()
    {
        obj.loginHelper("milos.aasindjelic1992@gmail.com", "Milos.992aa", wdWait, driver);
        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        Assert.assertTrue(message.getText().contains("Pogrešan email ili lozinka!"));
    }

    @Test
    public void negativeLoginEmail ()
    {
        obj.loginHelper("milos.aasindjelic1992@gmail.com", "Milos.992", wdWait, driver);
        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        Assert.assertTrue(message.getText().contains("Pogrešan email ili lozinka!"));
    }

    @Test
    public void negativeLoginPassword ()
    {
        obj.loginHelper("milos.sindjelic1992@gmail.com", "Milos.992aa", wdWait, driver);
        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        Assert.assertTrue(message.getText().contains("Pogrešan email ili lozinka!"));
    }

    @Test
    public void resultName ()
    {
        obj.loginHelper("milos.sindjelic1992@gmail.com", "Milos.992", wdWait, driver);
        obj.searchboxHelper("SAMSUNG", driver);
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
        obj.filterHelper(driver);
        List<WebElement> tvs = driver.findElements(By.className("products-wrap"));
        for (WebElement tv:tvs)
        {
            System.out.println(tv.getText());
            Assert.assertTrue(tv.getText().contains("32"));
        }
    }

    @Test
    public void priceIncreasing ()
    {
        driver.get("https://www.tehnomanija.rs");
        obj.searchboxHelper("SAMSUNG", driver);
        obj.priceIncreasingHelper(driver, wdWait);
        List<WebElement> increasing = driver.findElements(By.className("price"));
        int startingPrice = 0;
        boolean ok = true;
        for (WebElement element:increasing)
        {
            String text = element.getText().replace(".","").replace(" RSD","");
            int higher = Integer.parseInt(text);
            System.out.println(higher);
            ok = ok && (higher >= startingPrice);
            if (!ok) break;
            startingPrice = higher;
        }
        Assert.assertTrue(ok);
    }
}
