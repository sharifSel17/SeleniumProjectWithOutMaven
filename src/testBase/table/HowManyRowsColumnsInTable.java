package testBase.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowManyRowsColumnsInTable {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();

        int countRow = driver.findElements(By.xpath("//*[@id=\"main\"]/div[3]/div/table/tbody/tr")).size();
        System.out.println(countRow);

        int colNums = driver.findElements(By.xpath("//*[@id=\"main\"]/div[3]/div/table/tbody/tr/td")).size();
        System.out.println(colNums);

        for (int i=2;i<=countRow;i++){
            for (int j=1;j<=colNums;j++) {
                System.out.println(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[" +i+ "]/td[" +j+ "]")).getText()+"  ");
                //System.out.print(driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/table/tbody/tr["+i+"]/td["+j+"]")).getText());
                break;

            }
        }
        //System.out.println();
        driver.close();
    }



}
