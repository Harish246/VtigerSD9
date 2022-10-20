package ObjectRepo;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_OrganisationTest {
	
	public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();	
	WebDriver driver=new ChromeDriver();
	
	WebDriverUtility wdu=new WebDriverUtility(driver);
	
	wdu.maximize();
	wdu.implicitlyWait();
	
	ExcelFileUtility eFu= new ExcelFileUtility();
	String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1)+JavaUtility.generateRamNum();
	
	PropertyFileUtility pfu=new PropertyFileUtility();
	String URL = pfu.readPropertiesFile("url");
	String UN = pfu.readPropertiesFile("username");
	String PW= pfu.readPropertiesFile("password");
	
	driver.get(URL);
	LoginPageClass lpc = new LoginPageClass(driver);
	lpc.login(UN, PW);
	
	

	HomePageClass hpc= new HomePageClass(driver);
	hpc.getOrgButton().click();
	
	OrgPageClass opc= new OrgPageClass(driver);
	opc.getCreOrg().click();
	
	NewOrgPageClass nop=new NewOrgPageClass(driver);
	nop.orgTF(orgName);
	nop.getSaveButton().click();
	Thread.sleep(3000);
	
	hpc.signOut(driver);
	driver.close();

	}	
	
}
