package com.crm.Vtiger.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Organization_IndustryTest {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		
		String orgName="TestYantra 8";
		
		WebElement orgBTN = driver.findElement(By.linkText("Organizations"));
		orgBTN.click();
		

		WebElement newOrg = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		newOrg.click();
		WebElement orgNameTF = driver.findElement(By.name("accountname"));
		orgNameTF.sendKeys(orgName);
		
		WebElement indDD = driver.findElement(By.name("industry"));
		Select select = new Select(indDD);
		System.out.println(select.isMultiple());
		select.selectByValue("Biotechnology");
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
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		
		 WebElement signOutButton = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		 signOutButton.click();
		 
		 driver.close();
		
	}

}
