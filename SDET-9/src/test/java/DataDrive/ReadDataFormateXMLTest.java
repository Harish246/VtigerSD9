package DataDrive;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFormateXMLTest {
	
	@Test
	public void readDataFormTest(XmlTest xml) {
		String URL= xml.getParameter("url");
		System.out.println(URL);
		String UN=xml.getParameter("un");
		System.out.println(UN);
		String PWD=xml.getParameter("pwd");
		System.out.println(PWD);

	}

}
