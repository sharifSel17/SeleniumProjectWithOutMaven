package testBase.browserHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();

        Set<String> elements = driver.getWindowHandles();

        for (String key:elements){
            String st = driver.switchTo().window(key).getTitle();
            //now i want to close child window
            if(st.equals("Sakinalium | Home"))
                driver.close();
                System.out.println(st);
        }
    }
}
