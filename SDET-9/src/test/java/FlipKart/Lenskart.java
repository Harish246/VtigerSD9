package FlipKart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.lenskart.com/");
		driver.findElement(By.xpath("//button[@class='No thanks']")).click();
		
		driver.findElement(By.name("q")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li/a"));
		for(int i=0;i<ele.size();i++) {
			String allNames = ele.get(i).getText();
			System.out.println(allNames);
		}
		
		
//		for(WebElement ele1:ele) {
//			String allNames = ele1.getText();
//			System.out.println(allNames);
//		}
		
		
//		String hover = driver.findElement(By.xpath("//*[name()='a'and@class='getGaData']")).getAttribute("title");
//		System.out.println(hover);
		

	}

}
