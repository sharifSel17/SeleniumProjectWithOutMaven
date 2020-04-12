package testBase;

import baseConfig.BaseClass;
import org.openqa.selenium.WebDriver;


public class TestBase extends BaseClass{
    WebDriver driver;
    public  TestBase(WebDriver driver){
        this.driver = driver;
    }
    public static void main(String[] args)throws Exception{

        BaseClass ob = new BaseClass();
            ob.init();
    }
}
