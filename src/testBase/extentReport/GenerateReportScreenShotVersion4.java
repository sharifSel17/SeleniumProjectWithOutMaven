package testBase.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateReportScreenShotVersion4 {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest test;
    WebDriver driver;

    @BeforeTest
    public void setExtentReports(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/reports/myReport.html");
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
