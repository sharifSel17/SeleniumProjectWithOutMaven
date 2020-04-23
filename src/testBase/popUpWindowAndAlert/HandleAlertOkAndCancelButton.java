package testBase.popUpWindowAndAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertOkAndCancelButton {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demo.automationtesting.in/Alerts.html");
        //click on alert menu
        Thread.sleep(2000);

        //alert with ok link
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();

        //alert with ok button
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/button")).click();

        //for validation ok button
        String expectedTextOk = "You pressed Ok";
        driver.switchTo().alert().accept();

        String actualTextCancel = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/p")).getText();
        if (expectedTextOk.equals(actualTextCancel)==true){
            System.out.println("test is passed");
        }


        String expectedTextCancel = "You Pressed Cancel";
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        actualTextCancel = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/p")).getText();
        if (expectedTextCancel.equals(actualTextCancel)==true){
            System.out.println("test is passed");
        }





        //accept() will work as ok button to close the popup window

    }
}
