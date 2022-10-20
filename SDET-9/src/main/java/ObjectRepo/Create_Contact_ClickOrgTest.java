package ObjectRepo;

import java.time.Duration;
import java.util.Set;
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

public class Create_Contact_ClickOrgTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver();
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
	
		
		ExcelFileUtility eFu= new ExcelFileUtility();
		String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1);
		String firstNameType=eFu.readDataFromExcelFile("Sheet1", 7, 1);
		String firstN=eFu.readDataFromExcelFile("Sheet1", 7, 2);
		String lastN=eFu.readDataFromExcelFile("Sheet1", 7, 3);
	
		
		HomePageClass hpc= new HomePageClass(driver);
		hpc.getConButton().click();
		 
		
		ConPageClass cpc=new ConPageClass(driver);
		cpc.getCrecon().click();
	
		NewConPage ncp=new NewConPage(driver);
		ncp.fNtype(firstNameType);
		ncp.firstName(firstN);
		ncp.lastName(lastN);
		ncp.getSelectOrg().click();
		
	
		
		String pHandle=wdu.getParentHandle();
		wdu.allHandles(pHandle);

		WebElement orgsearchTF = driver.findElement(By.name("search_text"));
		orgsearchTF.sendKeys(orgName);
		
		WebElement searchBTN = driver.findElement(By.name("search"));
		searchBTN.click();
		Thread.sleep(3000);
		
		WebElement select = driver.findElement(By.id("1"));
		select.click();
		Thread.sleep(3000);
		
		wdu.allHandles(pHandle);
		driver.switchTo().window(pHandle);
		
		ncp.getSaveBTN().click();
		 
		hpc.signOut(driver);
		driver.close();
	}

}
