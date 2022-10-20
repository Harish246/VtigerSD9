package DataDrive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertiesFileTest {

	public static void main(String[] args) throws Throwable {
		//step-1 Convert Property file into java object
		FileInputStream fis= new FileInputStream("./CommonData.properties");
		Properties p= new Properties();
		
		//step-2 load java object
		p.load(fis);
		
		//step-3 read the data
		String value =p.getProperty("url");
		System.out.println(value);
		String val1=p.getProperty("username");
		System.out.println(val1);
		String val2=p.getProperty("password");
		System.out.println(val2);
		
		
		
		
		
		
		
		
		
		
				
		
	
		

	}

}
