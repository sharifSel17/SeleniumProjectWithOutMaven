package testBase.mouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClick {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        Actions act = new Actions(driver);
        WebElement mouseRightClick = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
        act.contextClick(mouseRightClick).build().perform();//context-Click() will click to mouse right

        driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();
        driver.switchTo().alert().accept();



    }
}
