package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadTest {
	public static void main(String[] args) throws Throwable {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	
	WebDriverUtility wdu=new WebDriverUtility(driver);
	
	wdu.maximize();
	wdu.implicitlyWait();
	
	PropertyFileUtility pfu=new PropertyFileUtility();
	String URL = pfu.readPropertiesFile("url");
	String UN = pfu.readPropertiesFile("username");
	String PW= pfu.readPropertiesFile("password");
	
	driver.get(URL);
	
	LoginPageClass lpc = new LoginPageClass(driver);
	lpc.login(UN, PW);

	HomePageClass hpc= new HomePageClass(driver);
	hpc.getLedButton().click();
	
	NewLeadsPage nlp=new NewLeadsPage (driver);
	nlp.getCreNewLed().click();
	

//	ExcelFileUtility eFu= new ExcelFileUtility();
//	String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1);

	}

}
