package testBase;

import baseConfig.BaseClass;
import org.testng.annotations.Test;


public class TestBase extends BaseClass {
    //WebDriver driver;

    /*public TestBase(WebDriver driver) {
        this.driver = driver;
    }*/

    @Test
    void setUp()throws Exception {
        init();
    }

   /* public static void main(String[] args)throws Exception{

        BaseClass ob = new BaseClass();
            ob.init();
    }*/
}
