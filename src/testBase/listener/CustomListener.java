package testBase.listener;


import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {

    public void onTestStart(ITestResult tr){
        System.out.println("Test Is Started");
    }
    public void onTestSuccess(ITestResult tr){
        System.out.println("Test Is Success");
    }
    public void onTestFailure(ITestResult tr){
        System.out.println("Test Is Failed");
    }
    public void onTestSkipped(ITestResult tr){
        System.out.println("Test is Skipped");
    }
}
