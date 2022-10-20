package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	public String readPropertiesFile(String key) throws Throwable{
		FileInputStream fis= new FileInputStream("./CommonData/CommonData.properities");
		Properties p=new Properties();
		p.load(fis);
		
		String value=p.getProperty(key);
		return value;
	}

}
