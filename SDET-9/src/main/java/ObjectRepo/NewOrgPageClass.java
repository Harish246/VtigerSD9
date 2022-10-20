package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class NewOrgPageClass {
	WebDriver driver;
	WebDriverUtility wdu =new WebDriverUtility(driver);

	@FindAll({@FindBy(name="accountname"),@FindBy(xpath="//input[@class=detailedViewTextBox]")})
	private WebElement orgNameTF;
	
	@FindBys({@FindBy(name="button"),@FindBy(xpath="//input[@type='button']")})
	private WebElement saveButton;
	
	@FindBy(name = "industry")
	private WebElement indDD;
		
	public NewOrgPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void orgTF(String orgText) {
		orgNameTF.sendKeys(orgText);
	}
	
	public void sButton() {
		saveButton.click();
	}

	public WebElement getindDD() {
		return indDD;
	}
	public void indt(String value) {
		wdu.selectByValue(indDD,value );
	}

 
	
	
	

	

	


}
