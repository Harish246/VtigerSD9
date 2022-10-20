package FlipKart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IccCrick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		WebDriverUtility wdu= new WebDriverUtility(driver);
		wdu.maximize();
		wdu.implicitlyWait();
		driver.get("https://www.icc-cricket.com");
		driver.findElement(By.xpath("//button[normalize-space()='Rankings'and@class='linked-list__dropdown-label js-dropdown-btn']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Team Rankings']")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		for (int i = 1; i <=rows.size(); i++) {
			for (int j = 1; j <=1; j++) {
				String data = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td[2]")).getText();
					System.out.print(data+" ");
			}
			System.out.println();
		}
	}

}
