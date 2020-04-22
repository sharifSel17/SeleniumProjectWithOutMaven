package testBase.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class ValidateColumnValueFromTable {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        Thread.sleep(3000);



        int countRow = driver.findElements(By.xpath("//*[@id=\"main\"]/div[3]/div/table/tbody/tr")).size();
        System.out.println(countRow);

        //initial status
        int countryAvailable = 0;

        for (int i=2;i<=countRow;i++){

            System.out.println(i);

            String status = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/table/tbody/tr["+i+"]/td[3]")).getText();
            //System.out.println(status);
            if (status.equals("Germany")){
                countryAvailable = countryAvailable+1;
                break;

            }
        }
        //System.out.println("Country doesn't matched");
        //System.out.println("no employees is enabled"+statusCount);
        driver.close();





    }
}
