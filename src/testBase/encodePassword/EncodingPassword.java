package testBase.encodePassword;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EncodingPassword {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys(decodingString("YWRtaW4xMjM="));//Y[WRtaW4xMjM=] this is encode value but when we submit we need to convert into decode otherwise user won't understand
        driver.findElement(By.name("Submit")).click();
    }

    public  static String decodingString(String password){
        byte[] decodePassword = Base64.decodeBase64(password);
        return (new String(decodePassword));

    }
}
