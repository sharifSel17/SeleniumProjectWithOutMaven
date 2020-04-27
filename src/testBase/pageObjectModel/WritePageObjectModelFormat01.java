package testBase.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WritePageObjectModelFormat01 {
    WebDriver driver; //define driver

    //variable initialize identification
    //after locating element, storing the elements in a variable
    //based on the type of elements, we need to perform set of operation/action
    By Registration = By.linkText("REGISTER");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By phone = By.name("phone");
    By email = By.name("userName");
    By address1 = By.name("address1");
    By address2 = By.name("address2");
    By city = By.name("city");
    By state = By.name("state");
    By zipCode = By.name("postalCode");
    By country = By.name("country");
    By userName = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");

    By submit = By.name("register");

    //created a constructor
    //this constructor will be executed, whenever we create an object for this particular class
    //in this constructor, we have initiated the driver, we can get the driver from the outside of the class and assign the driver with the driver element
    //we need to create a method for every single element, which we have initialized

    WritePageObjectModelFormat01(WebDriver dr){
        driver = dr;
    }
    public void registerForm(){
        driver.findElement(Registration).click();
    }
    public void setFirstName(String fName){
        driver.findElement(firstName).sendKeys(fName);
    }
    public void setLastName(String lName){
        driver.findElement(lastName).sendKeys(lName);
    }
    public void setPhone(String ph){
        driver.findElement(phone).sendKeys(ph);
    }
    public void setUserName(String uName){
        driver.findElement(email).sendKeys(uName);
    }
    public void setAddress1(String add1){
        driver.findElement(address1).sendKeys(add1);
    }
    public void setAddress2(String add2){
        driver.findElement(address2).sendKeys(add2);
    }
    public void setCity(String cit){
        driver.findElement(city).sendKeys(cit);
    }
    public void setState(String st){
        driver.findElement(state).sendKeys(st);
    }
    public void setZipCode(String zip){
        driver.findElement(zipCode).sendKeys(zip);
    }
    public void setCountry(String cou){
        driver.findElement(country).sendKeys(cou);
    }

    public void setUserEmail(String uEm){
        driver.findElement(userName).sendKeys(uEm);
    }
    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void setConfirmPassword(String conPassword){
        driver.findElement(confirmPassword).sendKeys(conPassword);
    }
    public void submit(){
        driver.findElement(submit).click();
    }
}
