package testBase.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WritePageObjectModelFormat02 {

    WebDriver driver;

   //we can write syntax for identification in two ways
    @FindBy(how = How.LINK_TEXT, using = "REGISTER")//syntax 1
    WebElement register;

    @FindBy(name = "firstName")//syntax 2
    WebElement fName;
    @FindBy(name = "lastName")//syntax 2
    WebElement lName;
    @FindBy(name = "phone")//syntax 2
    WebElement ph;
    @FindBy(name = "userName")//syntax 2
    WebElement uName;
    @FindBy(name = "address1")//syntax 2
    WebElement add1;
    @FindBy(name = "address2")//syntax 2
     WebElement add2;
    @FindBy(name = "city")//syntax 2
    WebElement cit;
    @FindBy(name = "state")//syntax 2
    WebElement sta;
    @FindBy(name = "postalCode")//syntax 2
    WebElement pCode;
    @FindBy(name = "country")//syntax 2
    WebElement cou;
    @FindBy(name = "email")//syntax 2
    WebElement em;
    @FindBy(name = "password")//syntax 2
    WebElement pass;
    @FindBy(name = "confirmPassword")//syntax 2
    WebElement conPass;
    @FindBy(name = "register")//syntax 2
    WebElement sub;

    WritePageObjectModelFormat02(WebDriver dr){
        driver = dr;
        PageFactory.initElements(dr, this);// add additional method
    }

    public void registerForm(){
        register.click();
    }
    public void setFirstName(String firstName){
        fName.sendKeys(firstName);
    }
    public void setLastName(String lastName){
        lName.sendKeys(lastName);
    }
    public void setPhone(String phone){
        ph.sendKeys(phone);
    }
    public void setUserName(String userName){
        uName.sendKeys(userName);
    }
    public void setAddress1(String address1){
        add1.sendKeys(address1);
    }
    public void setAddress2(String address2){
        add2.sendKeys(address2);
    }
    public void setCity(String city){
        cit.sendKeys(city);
    }
    public void setState(String state){
        sta.sendKeys(state);
    }
    public void setZipCode(String postal){
        pCode.sendKeys(postal);
    }
    public void setCountry(String country){
        cou.sendKeys(country);
    }
    public void setUserEmail(String email){
        em.sendKeys(email);
    }
    public void setPassword(String password){
        pass.sendKeys(password);
    }
    public void setConfirmPassword(String conPassword){
        conPass.sendKeys(conPassword);
    }

    public void submitReg(){
        sub.submit();
    }
}
