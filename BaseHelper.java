package helpers;

import org.openqa.selenium.WebElement;

public class BaseHelper {
    public static String getModel(WebElement element){
        String text = element.getText();
        String[] parts = text.split(" ");
        return parts[1].toUpperCase();
    }
}
