package testBase.dataprovider;

public class CustomDataProvider {
    //object[][] method name getData or ant data type like String[][]
    @org.testng.annotations.DataProvider(name = "abc")
    public Object[][] getData() {

        Object[][] ob = {{"abc@gmail.com", "abc123"}, {"xyz@gmail.com", "xyz123"}};
        return ob;
    }
}
