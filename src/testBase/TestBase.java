package testBase;

import baseConfig.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestBase extends BaseClass {


    @BeforeClass
    void setUp()throws Exception {
        init();
    }

    @Test(priority = 1)
    void logoTest(){
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        //Assert.assertTrue(logo.isDisplayed(),"logo not displayed");
        Assert.assertFalse(logo.isDisplayed(),"logo is displayed");
    }

    @Test(priority = 2)
    void homeTitle(){
        String titlePar = driver.getTitle();
        //Assert.assertEquals("OrangeHRM1",titlePar,"title is not matched");
        Assert.assertEquals(titlePar,"OrangeHRM1","title is not matched");
    }

    @AfterClass
    void beforeClass2(){
        browserClose();
    }
}
