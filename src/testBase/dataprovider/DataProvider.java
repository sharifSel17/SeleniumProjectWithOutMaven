package testBase.dataprovider;

import org.testng.annotations.Test;

public class DataProvider {

    @Test(dataProvider="abc", dataProviderClass = CustomDataProvider.class)
    public void setUp(String email, String pws){
        System.out.println(email+" "+pws);
    }
}
