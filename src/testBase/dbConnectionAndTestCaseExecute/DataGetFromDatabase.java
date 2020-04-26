package testBase.dbConnectionAndTestCaseExecute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class DataGetFromDatabase {
    public static void main(String[] args) throws SQLException,InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        //1. connection
        Connection dbCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","hr");
        //where jdbc is the API, oracle is the database, thin is the driver, localhost is the server name on which oracle is running

        //2. query statement
        Statement query = dbCon.createStatement();

        //3. Execute query statement
        //String st = "insert into userInfo values(20,'Sharif','Uddin')";

        //return all the rows
        //String getValue = "select userName, userPassword from userInfo";//select data from database, this action is two direction, so we need a class ResultSet which will provide a method to store data into a variable
        //return by id
        String getValue = "select userName, userPassword from userInfo where userID=10";
        ResultSet result= query.executeQuery(getValue);

        //we need to verify is data available in the table, using while loop
        while (result.next()){
            String userName = result.getString("userName");
            String userPassword = result.getString("userPassword");

            driver.findElement(By.id("txtUsername")).sendKeys(userName);
            driver.findElement(By.id("txtPassword")).sendKeys(userPassword);
            driver.findElement(By.name("Submit")).click();
            //verification by title
            if (driver.getTitle().equals("OrangeHRM")){
                System.out.println("test is passed");
            }else{
                System.out.println("test is failed");
            }
            driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
            /*System.out.print(userName+"  ");
            System.out.print(userPassword);
            System.out.println();*/
        }

        //4. close the connection
        dbCon.close();


        System.out.println("program is executed");



    }
}
