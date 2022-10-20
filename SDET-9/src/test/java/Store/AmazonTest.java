package Store;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		WebElement mob = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		Actions act= new Actions(driver);
		act.contextClick(mob).perform();
		
		Thread.sleep(3000);
		Robot r= new Robot();		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement book = driver.findElement(By.xpath("//a[text()='Books']"));
		Actions act1= new Actions(driver);
		act1.contextClick(book).perform();
		
		Thread.sleep(3000);
		Robot r1= new Robot();		
		r1.keyPress(KeyEvent.VK_DOWN);
		r1.keyRelease(KeyEvent.VK_DOWN);
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement fashion = driver.findElement(By.xpath("//a[text()='Fashion']"));
		Actions act2= new Actions(driver);
		act2.contextClick(fashion).perform();
		
		Thread.sleep(3000);
		Robot r2= new Robot();		
		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyRelease(KeyEvent.VK_DOWN);
		r2.keyPress(KeyEvent.VK_ENTER);
		r2.keyRelease(KeyEvent.VK_ENTER);
		
		
		String parentWinHan= driver.getWindowHandle();
		
		Set<String> allWinHan = driver.getWindowHandles();
		String swicthTitle = "Book Store Online : Buy Books Online at Best Prices in India | Books Shopping @ Amazon.in";
		
		for(String ah:allWinHan) {
			String title=driver.switchTo().window(ah).getTitle();
			System.out.println(driver.getTitle());	
			
			if(!title.equals(swicthTitle)) {
				driver.close();
			}
			
			if(title.equals(swicthTitle)) {
					break;
				}
			
			if(driver.findElement(By.className("nav-search-facade")).isDisplayed()) {
				System.out.println("Control is in books");
			}
			
		}
		}
	}
