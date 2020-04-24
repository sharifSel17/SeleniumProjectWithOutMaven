package testBase.mouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();

        Actions ac = new Actions(driver);

        WebElement admin = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
        WebElement userManage = driver.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]"));
        WebElement user = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));

        /*Thread.sleep(2000);
        ac.moveToElement(admin).build().perform();//Build(). perform() is used to compile and execute the actions class
        Thread.sleep(2000);
        ac.moveToElement(userManage).build().perform();
        Thread.sleep(2000);
        ac.moveToElement(user).click().build().perform();*/

        Thread.sleep(3000);
        ac.moveToElement(admin).moveToElement(userManage).moveToElement(user).click().build().perform();








    }
}
