package generic_Utilites;

import java.io.FileInputStream;
import java.util.Properties;

public class External_LocatorsUtility {
	
	public String getLocators(String key) throws Throwable 
	{
	FileInputStream fs = new FileInputStream ("./src/test/resources/locators.properties");
	Properties pro = new Properties();
    pro.load(fs);
    String keyvalue = pro.getProperty(key);
    return keyvalue;
    }
	

}
