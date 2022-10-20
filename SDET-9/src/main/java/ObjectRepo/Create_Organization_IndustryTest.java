package ObjectRepo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Organization_IndustryTest {


	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		WebDriverUtility wdu=new WebDriverUtility(driver);
		
		wdu.maximize();
		wdu.implicitlyWait();
		
		PropertyFileUtility pfu=new PropertyFileUtility();
		String URL = pfu.readPropertiesFile("url");
		String UN = pfu.readPropertiesFile("username");
		String PW= pfu.readPropertiesFile("password");
		
		driver.get(URL);
		
		ExcelFileUtility eFu= new ExcelFileUtility();
		String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1)+JavaUtility.generateRamNum();
		String indType=eFu.readDataFromExcelFile("Sheet1", 4, 2);
		
		
//		String orgNameCreate = new String();
		
		driver.get(URL);
		LoginPageClass lpc = new LoginPageClass(driver);
		lpc.login(UN, PW);
		
		

		HomePageClass hpc= new HomePageClass(driver);
		hpc.getOrgButton().click();
		
		OrgPageClass opc= new OrgPageClass(driver);
		opc.getCreOrg().click();
		Thread.sleep(3000);
		
		
		NewOrgPageClass nop=new NewOrgPageClass(driver);
		nop.orgTF(orgName);
		nop.indt(indType);
		nop.getSaveButton().click();
	
		Organisation_infoClass oic=new Organisation_infoClass(driver);
		
		if(oic.hText1().contains(orgName)) {
			System.out.println("Validated sucessfully");
		}
		else {
			System.out.println("Not Validated");
		}
		
		Thread.sleep(3000);
		
		hpc.signOut(driver);
		driver.close();

		
	}

}
