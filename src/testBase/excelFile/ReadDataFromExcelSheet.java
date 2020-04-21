package testBase.excelFile;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcelSheet {
    public static void main(String[] args) throws IOException {
        //create an object to read data from excel for FileInputStream class
        FileInputStream file = new FileInputStream("C:\\Users\\sharif.ny\\IdeaProjects\\SeleniumProjectWithOutMaven\\src\\T3.xlsx");

        //create an object for workBook into the excel file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //create an sheet into the workbook
        XSSFSheet sheet = workbook.getSheet("Sheet1");//we can get sheet by sheet name
        //XSSFSheet sheet = workbook.getSheetAt(0);//we can get sheet by index
        //System.out.println(sheet);

        int rowCount = sheet.getLastRowNum();//return total row numbers
        //System.out.println(rowCount);

        int countCell = sheet.getRow(0).getLastCellNum(); //return total column/cells
        //System.out.println(countCell);

        //get current row
        for (int i=0;i<=rowCount;i++){
           XSSFRow storeCurrentRow = sheet.getRow(i);
            //System.out.println(sheet.getRow(i));

            for (int j=0;j<countCell;j++){
                //read the value from the cell
                String value = storeCurrentRow.getCell(j).toString();//read data from the cell, even if the data type is int it will converted to string
                System.out.print("       "+      value);
            }

            System.out.println();
        }






    }
}
