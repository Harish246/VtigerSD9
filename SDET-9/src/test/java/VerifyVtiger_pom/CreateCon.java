package VerifyVtiger_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepo.ConPageClass;
import ObjectRepo.HomePageClass;
import ObjectRepo.NewConPage;


@Listeners
public class CreateCon extends BaseClass {

	@Test(groups = {"smoke","integration","regression"} )
	public void createCon() throws Throwable {
		WebDriverUtility wdu = new WebDriverUtility(driver);

		ExcelFileUtility eFu = new ExcelFileUtility();
		String orgName = eFu.readDataFromExcelFile("Sheet1", 1, 1);
		String firstNameType = eFu.readDataFromExcelFile("Sheet1", 7, 1);
		String firstN = eFu.readDataFromExcelFile("Sheet1", 7, 2);
		String lastN = eFu.readDataFromExcelFile("Sheet1", 7, 3);

		HomePageClass hpc = new HomePageClass(driver);
		hpc.getConButton().click();

		ConPageClass cpc = new ConPageClass(driver);
		cpc.getCrecon().click();

		NewConPage ncp = new NewConPage(driver);
		ncp.fNtype(firstNameType);
		ncp.firstName(firstN);
		ncp.lastName(lastN);
		ncp.getSelectOrg().click();

		String pHandle = wdu.getParentHandle();
		wdu.allHandles(pHandle);

		WebElement orgsearchTF = driver.findElement(By.name("search_text"));
		orgsearchTF.sendKeys(orgName);

		WebElement searchBTN = driver.findElement(By.name("search"));
		searchBTN.click();
		Thread.sleep(3000);

		WebElement select = driver.findElement(By.id("1"));
		select.click();
		Thread.sleep(3000);

		wdu.allHandles(pHandle);
		driver.switchTo().window(pHandle);

	}

}
