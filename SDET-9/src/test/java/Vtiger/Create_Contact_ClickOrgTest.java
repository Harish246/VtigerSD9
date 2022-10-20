package Vtiger;

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
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		PropertyFileUtility pfu=new PropertyFileUtility();
		String URL = pfu.readPropertiesFile("url");
		String UN = pfu.readPropertiesFile("username");
		String PW= pfu.readPropertiesFile("password");
		
		driver.get(URL);
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(UN);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PW);
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		
		ExcelFileUtility eFu= new ExcelFileUtility();
		String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1);
		String firstNameType=eFu.readDataFromExcelFile("Sheet1", 7, 1);
		String firstN=eFu.readDataFromExcelFile("Sheet1", 7, 2)+JavaUtility.generateRamNum();
		String lastN=eFu.readDataFromExcelFile("Sheet1", 7, 3)+JavaUtility.generateRamNum();
	
		
		
		
		 WebElement conBTN = driver.findElement(By.linkText("Contacts"));
		 conBTN.click();
		 
		WebElement CrecontBTN = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		CrecontBTN.click();
		
		WebElement fnameDD = driver.findElement(By.name("salutationtype"));
		wdu.selectByValue(fnameDD, firstNameType);
		
//		Select select=new Select(nameDD);
//		select.selectByValue(seleVal);
		
		
		WebElement firstNameTF=driver.findElement(By.name("firstname"));
		firstNameTF.sendKeys(firstN);
		
		WebElement lastNameTF=driver.findElement(By.name("lastname"));
		lastNameTF.sendKeys(lastN);
		
		WebElement selectOrg = driver.findElement(By.xpath("//img[@title='Select']"));
		selectOrg.click();
		
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
		
//		driver.switchTo().window(pHandle);
		
		
		WebElement saveBTN = driver.findElement(By.name("button"));
		saveBTN.click();
		Thread.sleep(3000);
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.mouseOverAction(ele);
//		Actions act= new Actions(driver);
//		act.moveToElement(ele).perform();
		 WebElement signOut = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		 signOut.click();
		 
		 driver.close();
	}

}
