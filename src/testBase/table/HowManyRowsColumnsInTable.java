package testBase.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowManyRowsColumnsInTable {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");

        driver.findElement(By.name("Submit")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("menu_admin_viewAdminModule")).click();

        //driver.close();

        int countRow = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr")).size();
        System.out.println(countRow);

        int colNums = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).size();
        System.out.println(colNums);

        for (int i=2;i<=countRow;i++){
            for (int j=2;j<=colNums;j++){
                System.out.print(driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]/td["+j+"]")).getText()+"  ");
                //break;
            }


        }
        System.out.println();
    }

}
