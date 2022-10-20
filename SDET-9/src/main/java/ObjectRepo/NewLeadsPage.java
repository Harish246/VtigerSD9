package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class NewLeadsPage {
	WebDriver driver;

	WebDriverUtility wdu=new WebDriverUtility(driver);
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreNewLed;
	
	public NewLeadsPage(WebDriver driver){
		PageFactory.initElements(driver,this );
	}

	public WebElement getCreNewLed() {
		return CreNewLed;
	}
	@FindBy(name = "salutationtype")
	private WebElement fnType;
	
	public void fNType(String value) {
		wdu.selectByValue(fnType, value);
	}
	

}
