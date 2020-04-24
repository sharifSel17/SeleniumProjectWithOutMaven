package testBase.findHowManyLinksInWebPageValidOrNot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HowManyLinksWebApplication {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.newtours.demoaut.com/");

        Thread.sleep(2000);
        //capture links and store in a list
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //count size
        System.out.println(links.size());

        //verify the links
        for (int i=0;i<links.size();i++){
            //by using href attribute we can get required url
            WebElement elements = links.get(i);
            String url = elements.getAttribute("href");
            //till the above code we got total links from web page
            //System.out.println(url);

            URL link = new URL(url);
            //creating connection using url object 'link'
            HttpURLConnection httpGetCon = (HttpURLConnection) link.openConnection();

            Thread.sleep(2000);
            httpGetCon.connect();//established connection

            //get response code, if the response is 404 or not
            int responseCode = httpGetCon.getResponseCode();
            if(responseCode>=400){
                System.out.println(url +" - "+ "is broken link");
            }else{
                System.out.println(url+" - "+ "is valid link");
            }
        }
    }
}
