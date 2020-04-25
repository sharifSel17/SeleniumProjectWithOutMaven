package testBase.jsExecutor;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutor {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

       // WebElement joinFree =driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a"));

        WebElement clickOnLogin = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a/span"));

        //Flashing web element for certain time
        //JavaScriptUtil.flashWebElement(joinFree,driver);

        //draw a border and take screenshot
        //JavaScriptUtil.drawBorder(joinFree,driver);

       /* File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//OutputType: to contain screenshot in a temporary file
        File trg = new File("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProjectWithOutMaven\\ScreenShot\\twoplus.png");
        //FileUtils.copyFile(file,src);
        FileUtils.copyFile(src,trg);*/

        //click on link
        //JavaScriptUtil.clickOnElement(clickOnLogin,driver);

        //generate alert message
        /*JavaScriptUtil.generateAlertMessage(driver,"You clicked in login button");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();*/

        //scroll down the page by visible element
        /*WebElement val = driver.findElement(By.xpath("//*[@id=\"rslides3_s0\"]/div[1]/img"));
        JavaScriptUtil.scrollByVisibleElement(val,driver);*/

        //scroll down till the end
        JavaScriptUtil.scrollDownThePageTillEnd(driver);


    }
}
