package generic_Utilites;

import java.io.FileInputStream;
import java.util.Properties;

public class CommonData_Utility {

	public String commondata(String key) throws Throwable 
	{
	FileInputStream fs = new FileInputStream ("./src/test/resources/commonData.properties");
	Properties pro = new Properties();
    pro.load(fs);
    String keyvalue = pro.getProperty(key);
    return keyvalue;
    }
	
	
}
