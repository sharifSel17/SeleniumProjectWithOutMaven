package testBase.excelFile;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class CalculateNumbersFromExcel {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");

        Thread.sleep(5000);
        //create an object to read data from excel for FileInputStream class
        FileInputStream file = new FileInputStream("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProjectWithOutMaven\\src\\T4.xlsx");

        //create an object for workBook into the excel file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //create an sheet into the workbook
        XSSFSheet sheet = workbook.getSheet("Sheet1");//we can get sheet by sheet name

        int rowCount = sheet.getLastRowNum();//return total row numbers

        for (int row=0;row<rowCount;row++){
            XSSFRow currentRow = sheet.getRow(row);

            //we can read cells value either directly like bellow code or
            //int countCell = sheet.getRow(0).getLastCellNum(); //return total column/cells

            //also we can read cells value creating object like bellow code
            XSSFCell principle = currentRow.getCell(0);
            int princ = (int)principle.getNumericCellValue();

            XSSFCell roi = currentRow.getCell(1);
            int rateOfInterest = (int)roi.getNumericCellValue();

            XSSFCell Frequency = currentRow.getCell(2);
            String freq = Frequency.getStringCellValue();

            XSSFCell maturity = currentRow.getCell(3);
            int mat = (int)maturity.getNumericCellValue();









        }






    }
}
