package Vtiger;

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
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		PropertyFileUtility pfu=new PropertyFileUtility();
		String URL = pfu.readPropertiesFile("url");
		String UN = pfu.readPropertiesFile("username");
		String PW= pfu.readPropertiesFile("password");
		
		driver.get(URL);
		
		ExcelFileUtility eFu= new ExcelFileUtility();
		String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1)+JavaUtility.generateRamNum();
		String indType=eFu.readDataFromExcelFile("Sheet1", 4, 2);
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(UN);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PW);
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		
		
		
		WebElement orgBTN = driver.findElement(By.linkText("Organizations"));
		orgBTN.click();
		

		WebElement newOrg = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		newOrg.click();
		WebElement orgNameTF = driver.findElement(By.name("accountname"));
		orgNameTF.sendKeys(orgName);
		
		WebElement indDD = driver.findElement(By.name("industry"));
		
//		Select select = new Select(indDD);
		
//		System.out.println(select.isMultiple());
//		select.selectByValue("Biotechnology");
		wdu.selectByValue(indDD, indType);
		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();
		Thread.sleep(3000);
		
		String orgNameCreate = driver.findElement(By.className("dvHeaderText")).getText();
		 
		System.out.println(orgNameCreate);
		if(orgNameCreate.contains(orgName)) {
			System.out.println("Validated sucessfully");
		}
		else {
			System.out.println("Not Validated");
		}
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.mouseOverAction(ele);
//		Actions act= new Actions(driver);
//		act.moveToElement(ele).perform();
		
		 WebElement signOutButton = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		 signOutButton.click();
		 
		 driver.close();
		
	}

}
