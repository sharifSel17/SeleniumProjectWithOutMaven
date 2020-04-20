package testBase.excelFile;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;


public class PassingDataToTheApplicationFromExcelSheet {
    public static void main(String[] args) throws IOException,InterruptedException {

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");

        Thread.sleep(5000);
        //create an object to read data from excel for FileInputStream class
        FileInputStream file = new FileInputStream("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProjectWithOutMaven\\src\\T3.xlsx");

        //create an object for workBook into the excel file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //create an sheet into the workbook
        XSSFSheet sheet = workbook.getSheet("Sheet1");//we can get sheet by sheet name


        int rowCount = sheet.getLastRowNum();//return total row numbers

        for (int row=1;row<rowCount;row++){

            XSSFRow currentRow = sheet.getRow(row);

            String getFName = currentRow.getCell(0).getStringCellValue();
            String getLName = currentRow.getCell(1).getStringCellValue();
            String getPhone = currentRow.getCell(2).toString();
            String getLEmail = currentRow.getCell(3).getStringCellValue();
            String getAddress = currentRow.getCell(4).getStringCellValue();
            String getCity = currentRow.getCell(5).getStringCellValue();
            String getState = currentRow.getCell(6).getStringCellValue();
            String getZipCode = currentRow.getCell(7).toString();
            String getCountry = currentRow.getCell(8).getStringCellValue();
            String getUserName = currentRow.getCell(9).getStringCellValue();
            String getPassWord = currentRow.getCell(10).getStringCellValue();

            //Registration Process
            driver.findElement(By.linkText("REGISTER")).click();

            //Entering contact data into the form
            driver.findElement(By.name("firstName")).sendKeys(getFName);
            driver.findElement(By.name("lastName")).sendKeys(getLName);
            driver.findElement(By.name("phone")).sendKeys(getPhone);
            driver.findElement(By.name("userName")).sendKeys(getLEmail);

            //Entering address
            driver.findElement(By.name("address1")).sendKeys(getAddress);
            driver.findElement(By.name("address2")).sendKeys(getAddress);
            driver.findElement(By.name("city")).sendKeys(getCity);
            driver.findElement(By.name("state")).sendKeys(getState);
            driver.findElement(By.name("postalCode")).sendKeys(getZipCode);

            //country selection
            Select selectCountry = new Select(driver.findElement(By.name("country")));
            selectCountry.selectByVisibleText(getCountry);

            //Entering user information
            driver.findElement(By.name("email")).sendKeys(getUserName);
            driver.findElement(By.name("password")).sendKeys(getPassWord);
            driver.findElement(By.name("confirmPassword")).sendKeys(getPassWord);

            //submitting form
            driver.findElement(By.name("register")).click();

            if (driver.getPageSource().contains("Thank you for registering")){
                System.out.println("Registration Completed for " + row + " record");
            }else {
                System.out.println("Registration Failed for "+ row + " record");
            }
        }
        System.out.println("Data Driven Test Is Completed");
        driver.close();
        file.close();
    }
}
