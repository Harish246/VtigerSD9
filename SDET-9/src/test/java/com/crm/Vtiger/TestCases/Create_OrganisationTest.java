package com.crm.Vtiger.TestCases;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_OrganisationTest {
	
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("DY");
	driver.findElement(By.name("button")).click();
	String data=driver.findElement(By.className("dvHeaderText")).getText();
	String data1="hari";
	System.out.println(data.contains(data1));
	
	
	WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act= new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
	
	}
		
		
		
		
		

}
