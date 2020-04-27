package testBase.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass {
    @Test
    public void flightVerification() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();

        //WritePageObjectModelFormat01 regPage = new WritePageObjectModelFormat01(driver);
        WritePageObjectModelFormat02 regPage = new WritePageObjectModelFormat02(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
        Thread.sleep(10);

        regPage.registerForm();
        regPage.setFirstName("Sharif");
        regPage.setLastName("Uddin");
        regPage.setPhone("3478874845");
        regPage.setUserName("abc@gmail.com");
        regPage.setAddress1("340 lakse shore");
        regPage.setAddress2("240 husr li");
        regPage.setCity("BK");
        regPage.setState("NY");
        regPage.setZipCode("12345");
        regPage.setCountry("USA");
        regPage.setUserEmail("sharifu");
        regPage.setPassword("admin123");
        regPage.setConfirmPassword("admin123");
        regPage.submitReg();

        //validation
        if (driver.getPageSource().contains("Thank you for registering.")){
            System.out.println("test is passed");
        }else{
            System.out.println("test is failed");
        }
        //driver.close();
    }

}
