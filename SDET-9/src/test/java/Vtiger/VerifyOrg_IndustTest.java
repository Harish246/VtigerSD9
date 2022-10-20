package Vtiger;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyOrg_IndustTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Kram");
		driver.findElements(By.name("industry"));
		driver.findElement(By.xpath("//option [@value='Banking']")).click();
		driver.findElement(By.name("button")).click();
		List<WebElement> ele = driver.findElements(By.className("dvHeaderText"));
		List<WebElement> i=driver.findElements(By.id("dtlview_Organization Name"));
		for(WebElement ele1:ele) {
			System.out.println(i);
		}
		

	}

}
