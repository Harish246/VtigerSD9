package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import ObjectRepo.HomePageClass;
import ObjectRepo.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners
public class BaseClass {

	public  WebDriver driver;
	public static WebDriver sdriver;
	PropertyFileUtility propertyFileUtility= new PropertyFileUtility();

	@BeforeSuite(groups ={"smoke","integration","regression"})

	public void dataBaseConnection() {
		System.out.println("==Connect to DataBase==");
	}

	@BeforeSuite(groups ={"smoke","integration","regression"})

	public void dataBaseDisConnection() {
		System.out.println("==DisConnect to DataBase==");
	}
	/*
	 * Launch Browser
	 */

	@BeforeClass(groups ={"smoke","integration","regression"})
	public void launchBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
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
	public void logoutfromApp() {

		HomePageClass hpc= new HomePageClass(driver);
		hpc.signOut(driver);

	}

}

