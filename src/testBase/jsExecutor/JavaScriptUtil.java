package testBase.jsExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
    public  static void flashWebElement(WebElement element, WebDriver driver){
        String bgColor = element.getCssValue("backgroundColor");
        for (int i=0;i<250;i++){
            changeColor("#000000",element,driver);
            changeColor(bgColor,element, driver);
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '"+ color + "'",element);
        try {
            Thread.sleep(10);
        }catch (InterruptedException ex){

        }
    }
    public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);
    }
    public static void clickOnElement(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);

    }
    public static void generateAlertMessage(WebDriver driver, String message){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('"+ message +"')");
    }

    public static void scrollByVisibleElement(WebElement element,WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }
    public static void scrollDownThePageTillEnd(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

}
