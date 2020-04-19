package testBase.listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//to associate ITestListener class with the test methods we need to add a parameter in test class in class level and specify the package and class name
//@Listeners(CustomListener.class)//when we run test from xml file we dont need to use @Listeners
public class ListenerMethod {

    @Test
    public void method01(){
        System.out.println("this is test 01");
        Assert.assertEquals("A","A");
    }
    @Test
    public void method02(){
        System.out.println("this is test 02");
        Assert.assertEquals("A","B");
    }
    @Test
    public void method03(){
        System.out.println("this is test 03");
        throw new SkipException("this method will be skipped");
    }
}
