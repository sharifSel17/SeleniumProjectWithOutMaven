package testBase.calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderDateValidation {

    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://fs2.formsite.com/R1Tuim/form1/index.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"q6\"]/span")).click();
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select")));
        select.selectByVisibleText("2020");

        //if we want to see future month from the calender
        /*for (int i=8;i>=1;i--){
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
            //get the month
            String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
            if (month.equals("October")){
                //in case dynamic date, we need to take link element
                driver.findElement(By.linkText("20")).click();
                break;//once we found expected month, we dont need to for further month
            }
        }*/

        //if we want to see past month from the calender
        for (int i=4;i>1;i--){
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
            //get the month
            String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
            if (month.equals("February")){
                //in case dynamic date, we need to take link element
                driver.findElement(By.linkText("20")).click();
                break;//once we found expected month, we dont need to for further month
            }
        }

        //driver.close();
    }
}
