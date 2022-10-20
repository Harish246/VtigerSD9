package DataDrive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws Throwable {
		
		//step-1 convert json file into json object
		FileReader fr= new FileReader("./CommonValues.json");
		
		//step-2 Covert Json Object into JAVA object
		JSONParser jp =new JSONParser();
		Object jobj = jp.parse(fr);
		
		//step-3 UseHashmap to read data
		HashMap hp=(HashMap)jobj;
		String value= (String)hp.get("url");
		System.out.println(value);
		

	}

}
