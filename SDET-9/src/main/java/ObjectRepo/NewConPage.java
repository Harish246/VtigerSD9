package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class NewConPage {
	WebDriver driver;
	WebDriverUtility wdu =new WebDriverUtility(driver);
	
	@FindBy(name = "salutationtype")
	private WebElement fnameDD;
	
	@FindBy(name="firstname")
	private WebElement firstnameTF;
	
	@FindBy(name="lastname")
	private WebElement lastnameTF;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectOrg;
	
	@FindBy(name="button")
	private WebElement saveBTN;
	
	
	public NewConPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFnameDD() {
		return fnameDD;
	}
	
	public void fNtype(String value) {
		wdu.selectByValue(fnameDD, value);
	}

	public WebElement getFirstnameTF() {
		return firstnameTF;
	}
	public void firstName(String fName) {
	   firstnameTF.sendKeys(fName);
		
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}
	public void lastName(String lName) {
		lastnameTF.sendKeys(lName);		
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}

	public WebElement getSelectOrg() {
		return selectOrg;
	}


	
	


	
	
	

}
