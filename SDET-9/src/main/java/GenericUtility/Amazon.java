package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Amazon {
	//public static WebDriver sdriver;
	static WebDriver sdriver;
	@Test
	public void amazon() {
		WebDriverManager.chromedriver().setup();
		sdriver=new ChromeDriver();
		sdriver.get("https://www.amazon.in/");
		sdriver.manage().window().maximize();
		System.out.println(sdriver.getTitle());
		Assert.assertEquals(false, true);

	}
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
