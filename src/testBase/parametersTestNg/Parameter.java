package testBase.parametersTestNg;

import baseConfig.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter extends BaseClass {
    //WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void selectBrowser(String browser, String url) {
        if (browser.equals("chrome") || browser.equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
            System.setProperty("webdriver.chrome.silentOutput", "true");//it's prevent to showing unnecessary logs from the browser site in the console
            driver = new ChromeDriver();

        } else if (browser.equals("firefox") || browser.equals("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\drivers\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");//stop to showing unnecessary logs in the console
            driver = new FirefoxDriver();

        }
        driver.get(url);
    }

    @Test
    void login() {
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        Assert.assertTrue(logo.isDisplayed(), "logo not displayed");
    }

    @AfterClass
    void tearDown() {
        browserClose();
    }
}
