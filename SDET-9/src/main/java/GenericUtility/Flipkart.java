package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(Listeners_1.class)
public class Flipkart {
		static WebDriver sdriver;
		@Test
		public void flipkart() {
			WebDriverManager.chromedriver().setup();
			sdriver=new ChromeDriver();
			sdriver.get("https://www.flipkart.com/");
			sdriver.manage().window().maximize();
			System.out.println(sdriver.getTitle());
			Assert.assertEquals(false, true);
			
	}
}
