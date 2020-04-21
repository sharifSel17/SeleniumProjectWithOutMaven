package testBase.excelFile;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;

public class CalculateNumbersFromExcel {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/yes-bank/fixed-deposit-calculator-YB-BYB001.html?classic=true");

        Thread.sleep(2000);
        //create an object to read data from excel for FileInputStream class
        FileInputStream file = new FileInputStream("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProjectWithOutMaven\\src\\T4.xlsx");

        //create an object for workBook into the excel file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //create an sheet into the workbook
        XSSFSheet sheet = workbook.getSheet("Sheet1");//we can get sheet by sheet name

        int rowCount = sheet.getLastRowNum();//return total row numbers

        for (int row=1;row<rowCount;row++){
            XSSFRow currentRow = sheet.getRow(row);

            //we can read cells value either directly like bellow code or
            //int countCell = sheet.getRow(0).getLastCellNum(); //return total column/cells

            //also we can read cells value creating object like bellow code
            XSSFCell principle = currentRow.getCell(0);
            int princ = (int)principle.getNumericCellValue();


            XSSFCell roi = currentRow.getCell(1);
            int rateOfInterest = (int)roi.getNumericCellValue();

            XSSFCell period = currentRow.getCell(2);
            int per = (int)period.getNumericCellValue();


            XSSFCell Frequency = currentRow.getCell(3);
            String freq = Frequency.getStringCellValue();

            XSSFCell maturity = currentRow.getCell(4);
            int ExpectMat = (int)maturity.getNumericCellValue();

            driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
            driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateOfInterest));
            driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));

            Select select = new Select(driver.findElement(By.id("tenurePeriod")));
            select.selectByVisibleText("year(s)");

            Select select1 = new Select(driver.findElement(By.id("frequency")));
            select1.selectByVisibleText(freq);

            driver.findElement(By.xpath(".//*[@id='fdMatVal']/div[2]/a[1]/img")).click();

            String actualVal = driver.findElement((By.xpath(".//*[@id='resp_matval']/strong"))).getText();

            if ((Double.parseDouble(actualVal))==ExpectMat){
                System.out.println("TEST PASSED");

            }else {
                System.out.println("Test Failed");
            }
            driver.findElement(By.xpath(".//*[@id='fdMatVal']/div[2]/a[2]/img")).click();

        }
        driver.close();

    }
}
