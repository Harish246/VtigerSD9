package GenericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	WebDriver driver;
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * this method is used to maxmize the window
	 * @author HARISH
	 */
	
	public void maximize(){
		driver.manage().window().maximize();	
	}
	
	/**
	 * This Method is used to wait for pageload
	 * @author Vivek
	 */
	
	public void implicitlyWait(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * @author Ganesh
	 * @param ele 
	 * @param num 
	 * @param select 
	 */
	public void selctByIndex(WebElement ele, int num) {
		Select select=new Select(ele);
		select.selectByIndex(num);
	}
	
	public void selectByVisibleText(WebElement ele, String Text) {
		Select select=new Select(ele);
		select.selectByVisibleText(Text);
		
	}
	
	public void selectByValue(WebElement ele, String value) {
		Select select=new Select(ele);
		select.selectByValue(value);
	
	}
	
	public String getParentHandle() {
		String parentHandle=driver.getWindowHandle();
		System.out.println(parentHandle);
		return parentHandle;
		
	}
	public void allHandles(String pHandle) {
		Set<String> allWinHandles = driver.getWindowHandles();
		System.out.println("All window Handles");
		for(String aW:allWinHandles) {
			System.out.println(aW);
			if(!pHandle.equals(aW)) {
				driver.switchTo().window(aW);
			}
			else {
				driver.switchTo().window(pHandle);
			}
		}
	}
	public void mouseOverAction(WebElement variable) {
		Actions act=new Actions(driver);
		act.moveToElement(variable).perform();
	}
	
}
