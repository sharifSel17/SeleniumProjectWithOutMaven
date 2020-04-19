package baseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {

    public Properties Repository = new Properties();
    public FileInputStream FI;
    public static  WebDriver driver;

    public void loadProperties() throws Exception {
        Repository =new Properties();
        FileInputStream FI = new FileInputStream(("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProject\\src\\configuration\\config.properties"));
        Repository.load(FI);
    }
    public void init() throws Exception {
        loadProperties();
        selectBrowser(Repository.getProperty("browser"));
        getUrl(Repository.getProperty("url"));

    }
    public WebDriver  selectBrowser(String browser) {
        if (browser.equals("chrome")||browser.equals("CHROME")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
            System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
            driver = new ChromeDriver();
            return driver;
        }else if (browser.equals("firefox")||browser.equals("FIREFOX")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\drivers\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");//stop to showing unnecessary logs in the console
            driver = new FirefoxDriver();
            return driver;
        }
        return null;
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public void browserClose(){
        driver.quit();
    }
}
