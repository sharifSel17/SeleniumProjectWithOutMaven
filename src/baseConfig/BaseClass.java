package baseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {

    public Properties Repository = new Properties();
    public FileInputStream FI;
    public  static WebDriver driver;

    public void loadProperties() throws Exception {
        Repository =new Properties();
        FileInputStream FI = new FileInputStream(("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProject\\src\\configuration\\config.properties"));
        Repository.load(FI);
        //System.out.println(Repository.getProperty("browser"));
    }
    public void init() throws Exception {
        loadProperties();
        selectBrowser(Repository.getProperty("browser"));
        getUrl(Repository.getProperty("url"));
        browserClose();
    }
    public WebDriver  selectBrowser(String browser) {
        if (browser.equals("chrome")||browser.equals("CHROME")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            return driver;
        }else if (browser.equals("firefox")||browser.equals("FIREFOX")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\drivers\\geckodriver.exe");
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
