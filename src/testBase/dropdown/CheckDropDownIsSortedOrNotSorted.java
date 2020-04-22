package testBase.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckDropDownIsSortedOrNotSorted {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");//it's prevent to showing unnecessary logs from the browser site in the console
        WebDriver driver = new ChromeDriver();
        driver.get("http://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement elements = driver.findElement(By.id("animals"));
        Select se = new Select(elements);//we are  not able to read the options values until we creat a list object
        //System.out.println(se.getOptions());

        List originalList = new ArrayList();//List contain a multiple object
        List<WebElement> options = se.getOptions();
        for (WebElement e:options){
            originalList.add(e.getText());
        }
        System.out.println(originalList);

        //copying original values into tempList
        List tempList = new ArrayList();
        tempList = originalList;
        System.out.println(tempList);

        Collections.sort(tempList);

        System.out.println("after sorted tempList"+tempList);
        System.out.println("after sorted originalList"+originalList);

        if (originalList==tempList){
            System.out.println("DropDown is sorted");
        }else {
            System.out.println("DropDown is not sorted");
        }

    }

}
