package com.crm.Vtiger.TestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Contact_ClickOrgTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		
		
		 WebElement conBTN = driver.findElement(By.linkText("Contacts"));
		 conBTN .click();
		 
		WebElement CrecontBTN = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		CrecontBTN.click();
		
		WebElement nameDD = driver.findElement(By.name("salutationtype"));
		Select select=new Select(nameDD);
		select.selectByValue("Mr.");
		
		
		WebElement firstNameTF=driver.findElement(By.name("firstname"));
		firstNameTF.sendKeys("Bhaballi23");
		
		WebElement lastNameTF=driver.findElement(By.name("lastname"));
		lastNameTF.sendKeys("Amarendra23");
		
		WebElement selectOrg = driver.findElement(By.xpath("//img[@title='Select']"));
		selectOrg.click();
		
		String parentWin = driver.getWindowHandle();
		System.out.println(parentWin);
		
		Set<String> allWinHan = driver.getWindowHandles();
		
		for(String aWinHandles:allWinHan) {
			driver.switchTo().window(aWinHandles);
			System.out.println(aWinHandles);	
		}
		
	
		WebElement orgsearchTF = driver.findElement(By.name("search_text"));
		orgsearchTF.sendKeys("ssd");
		
		WebElement searchBTN = driver.findElement(By.name("search"));
		searchBTN.click();
		WebElement selectssd = driver.findElement(By.linkText("ssd"));
		selectssd.click();
		
		driver.switchTo().window(parentWin);
		
		
		WebElement saveBTN = driver.findElement(By.name("button"));
		saveBTN.click();
		Thread.sleep(3000);
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
		

	}

}
