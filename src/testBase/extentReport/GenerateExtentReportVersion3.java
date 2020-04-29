package testBase.extentReport;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.security.PublicKey;

public class GenerateExtentReportVersion3 {
    ExtentReports extents;//specify the location of report
    ExtentTest test;//what details should be populated in the report

    @BeforeTest //we want to execute this method before executed all other method
    public void configReport(){
        extents = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\MyOwnReport.html",true);
        extents.addSystemInfo("Host Name","Local Host");
        extents.addSystemInfo("Environment", "QA");
        extents.addSystemInfo("User Name","Sharif");
        extents.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }
    @Test
    public void testPassReport(){
        test = extents.startTest("TestPassReport");
        Assert.assertTrue(true);
        test.log(LogStatus.PASS,"Assert passed if condition is true");
    }
    @Test
    public void testFailedReport(){
        test = extents.startTest("testFailedReport");
        Assert.assertTrue(false);
        test.log(LogStatus.FAIL,"Assert failed if condition is false");
    }
    @AfterMethod//the reason we have created this method, once the test is failure, we want to get the failure message as a log file
    public void getResult(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            test.log(LogStatus.FAIL,result.getThrowable());
        }
        extents.endTest(test);
    }
    @AfterTest
    public void flash(){
        extents.flush();//to use this method just clear the memory
    }
}
