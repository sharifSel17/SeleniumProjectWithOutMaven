package testBase.popUpWindowAndAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertOkButton {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demo.automationtesting.in/Alerts.html");

        //click on alert menu
        Thread.sleep(2000);
        //alert with ok link
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
        //alert with ok button
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/button")).click();

        //accept() will work as ok button to close the popup window
        driver.switchTo().alert().accept();




    }
}
