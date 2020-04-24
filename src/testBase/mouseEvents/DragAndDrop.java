package testBase.mouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //for drag and drop we need identify two things, source is the object we want to move and target is where we want to drop the object.
        //we need to hold the object, using clickAndHold(), we can perform this action
        WebElement source = driver.findElement(By.xpath("//*[@id=\"box3\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@id=\"box107\"]"));

        Actions act = new Actions(driver);


        Thread.sleep(2000);
        //act.clickAndHold(source).moveToElement(target).release().build().perform();
        act.dragAndDrop(source,target).build().perform();//same as above code

    }
}
