package GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import ObjectRepo.HomePageClass;
import ObjectRepo.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public  WebDriver driver;
	public static WebDriver sdriver;
	PropertyFileUtility propertyFileUtility= new PropertyFileUtility();

	@BeforeSuite(groups ={"smoke","integration","regression"})

	public void dataBaseConnection() {
		System.out.println("==Connect to DataBase==");
	}

	@AfterSuite(groups ={"smoke","integration","regression"})

	public void disConnectDatavbase() {
		System.out.println("==DisConnect to DataBase==");
	}
	/*
	 * Launch Browser
	 */

	@BeforeClass(groups ={"smoke","integration","regression"})
	public void launchBrowser() throws Throwable 
	{
		String browser= propertyFileUtility.readPropertiesFile("browser");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Input");
		}
		
		WebDriverUtility wdu=new WebDriverUtility(driver);
		wdu.maximize();
		driver.get(propertyFileUtility.readPropertiesFile("url"));
		wdu.implicitlyWait();
		sdriver=driver;

	}


	@AfterClass(groups ={"smoke","integration","regression"})
	public void closeBrowser() {
		driver.close();
	}

	@BeforeMethod(groups ={"smoke","integration","regression"})
	public void logintoApp() throws Throwable {
		String UN = propertyFileUtility.readPropertiesFile("username");
		String PW= propertyFileUtility.readPropertiesFile("password");


		LoginPageClass lpc = new LoginPageClass(driver);
		lpc.login(UN, PW);

	}

	@AfterMethod(groups ={"smoke","integration","regression"})
	public void logoutfromApp()throws Throwable {

		HomePageClass hpc= new HomePageClass(driver);
		hpc.signOut(driver);

	}
	
	public static String takescreenshot(String name) {
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		 String path= "./ScreenShort/"+name+".PNG";
		 
		 File dest=new File(path);
		 try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}

