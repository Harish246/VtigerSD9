package DataDrive;


import org.testng.annotations.Test;

public class ReadDataFromCmdTest {
	@Test
	public void readDataTest() {
		String URL = System.getProperty("url");
		String UN = System.getProperty("un");
		System.out.println(URL);
		System.out.println(UN);
	}

}
