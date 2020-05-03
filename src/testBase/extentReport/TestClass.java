package testBase.extentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends GenerateReportScreenShotVersion4{

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Register.html");

    }
    @Test
    public void FramesWindowsLogoTest(){
        test = extentReports.createTest("FramesWindowsLogoTest");
        Boolean status = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/a/img")).isDisplayed();
        Assert.assertTrue(status);
    }
    @Test
    public void FramesWindowsLoginTest(){
        test = extentReports.createTest("FramesWindowsLoginTest");
        Assert.assertTrue(true);
    }
    @Test
    public void FramesWindowsTitleTest(){
        test = extentReports.createTest("FramesWindowsTitleTest");//we need to make an entry into the report by using this line

        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Frames &t windows");
    }
}
