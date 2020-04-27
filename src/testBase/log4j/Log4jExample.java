package testBase.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Log4jExample {
    public static void main(String[] args) throws FileNotFoundException {

        Logger logger = Logger.getLogger("Log4jExample");
        FileInputStream log4jConfPath = new FileInputStream("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProjectWithOutMaven\\log4j.properties");
        PropertyConfigurator.configure(log4jConfPath);

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");


        logger.info("This is userName");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        logger.info("This is Password");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");

        logger.info("Clicked on login button");
        driver.findElement(By.name("Submit")).click();
    }
}
