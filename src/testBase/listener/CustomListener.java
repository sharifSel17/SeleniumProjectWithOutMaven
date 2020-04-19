package testBase.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class CustomListener implements ITestListener {

    public void OnStart(ITestContext arg){
        System.out.println("OnStart method is called when any Test starts.."+arg.getName());
    }
    public void onFinish(ITestContext arg){
        System.out.println("onFinish method is called after all Tests are executed."+arg.getName());
    }
    public void onTestStart(ITestContext arg){
        System.out.println("This method is invoked before any tests method is invoked. This can be used to indicate that the particular test method has been started."+arg.getName());
    }
    public void onTestSkipped(ITestContext arg){
        System.out.println("onTestSkipped method is called on skipped of any Test."+arg.getName());
    }
    public void onTestSuccess(ITestResult arg){
        System.out.println("onTestSuccess method is called on the success of any Test."+arg.getName());
    }
    public void onTestFailure(ITestContext arg){
        System.out.println("onTestFailure method is called on the failure of any Test."+arg.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestContext arg){
        System.out.println("method is called each time Test fails but is within success percentage."+arg.getName());
    }

}
