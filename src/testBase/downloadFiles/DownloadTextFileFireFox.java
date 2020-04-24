package testBase.downloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadTextFileFireFox {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\drivers\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console

        //creating firefox profile
        FirefoxProfile profile = new FirefoxProfile();

        //set preference
        profile.setPreference("browser.helperApps.neverAsk","text/plain");
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        //initialize firefox driver
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://demo.automationtesting.in/FileDownload.html");
        driver.manage().window().maximize();
        //Thread.sleep(2000);

        //identifying web elements
        driver.findElement(By.id("textbox")).sendKeys("i am plain text");
        driver.findElement(By.id("createTxt")).click();
        driver.findElement(By.id("link-to-download")).click();
    }
}
