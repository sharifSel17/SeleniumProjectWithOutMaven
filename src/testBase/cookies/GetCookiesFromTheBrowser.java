package testBase.cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetCookiesFromTheBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.worldometers.info");
        Set <Cookie> cookiesLost = driver.manage().getCookies();//return cookies from the browser and dataType is Cookie, that's why we used Cookie
        System.out.println(cookiesLost.size());

        //use foreach loop to read and print cookies
        for(Cookie cookie:cookiesLost){
            System.out.println(cookie.getName()+ " - " +cookie.getValue());
        }








    }
}
