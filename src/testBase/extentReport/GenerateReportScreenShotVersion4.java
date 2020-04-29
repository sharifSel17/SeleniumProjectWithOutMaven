package testBase.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class GenerateReportScreenShotVersion4 {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest test;
    WebDriver driver;

    @BeforeTest
    public void setExtentReports(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");//title of the report
        htmlReporter.config().setReportName("Functional Report");//name of the report
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentReports.setSystemInfo("Host Name","LocalHost");
        extentReports.setSystemInfo("OS","WINDOWS 10");
        extentReports.setSystemInfo("Tester Name", "Sharif");
        extentReports.setSystemInfo("Browser", "Chrome");

    }
    @AfterTest
    public void endReport(){
        extentReports.flush();
    }

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Register.html");

    }
    @Test
    public void FramesWindowsTitleTest(){
        test = extentReports.createTest("FramesWindowsTitleTest");//we need to make an entry into the report by using this line

        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Frames &t windows");
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

    //in this test i will verify every method will pass, fail or skip and based on the status i will update the result into the report
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE){
            test.log(Status.FAIL,"Test is failed"+result.getName());//to add name in the extent report
            test.log(Status.FAIL,"Test is failed"+result.getThrowable());//to add error/exception to the report

            //if the status is failed, we need to take screenshot

            String screenShot = GenerateReportScreenShotVersion4.getScreenShot(driver,result.getName());
            test.addScreenCaptureFromPath(screenShot);//adding screen shot
        }else if(result.getStatus()==ITestResult.SKIP){
            test.log(Status.SKIP,"TTest is skipped"+result.getName());
        }else if (result.getStatus()==ITestResult.SUCCESS){
            test.log(Status.PASS,"Test is passed"+result.getName());
        }
        driver.quit();
    }

    public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException {
        String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        //after execution you could see a folder under src directory
        String destination = System.getProperty("user.dir")+"/ScreenShotReport/"+ screenShotName + dataName + ".png";
        File fileDestination = new File(destination);
        FileUtils.copyFile(source,fileDestination);
        return destination;
    }

}
