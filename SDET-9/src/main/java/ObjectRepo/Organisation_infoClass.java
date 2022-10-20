package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organisation_infoClass {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement hText;
	
	public WebElement gethText() {
		return hText;
	}

	public Organisation_infoClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String hText1() {
	return hText.getText();
}
	
}
