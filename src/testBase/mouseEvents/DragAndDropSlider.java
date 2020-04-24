package testBase.mouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropSlider {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));

        Actions act = new Actions(driver);
        //act.clickAndHold(source).build().perform();
        act.moveToElement(source).dragAndDropBy(source,300,0).build().perform();


    }
}
