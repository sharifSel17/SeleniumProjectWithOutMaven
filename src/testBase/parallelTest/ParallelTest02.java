package testBase.parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTest02 {
    WebDriver driver;

    @Test(priority = 1)
    void login() throws Exception{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");//it's prevent to showing unnecessary logs from the browser site in the console
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        Assert.assertTrue(logo.isDisplayed(), "logo not displayed");
        Thread.sleep(5000);
        driver.quit();
    }
    @Test(priority = 2)
    void homeTitle() throws Exception{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");//it's prevent to showing unnecessary logs from the browser site in the console
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
        String title = driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM","title is not matched");
        Thread.sleep(5000);
        driver.quit();
    }
}
