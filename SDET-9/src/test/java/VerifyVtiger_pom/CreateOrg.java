package VerifyVtiger_pom;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepo.HomePageClass;
import ObjectRepo.NewOrgPageClass;
import ObjectRepo.OrgPageClass;
@Listeners
public class CreateOrg extends BaseClass{
	
	@Test(groups= {"smoke","integration","regression"})
	public void createOrg() throws Throwable {
	WebDriverUtility wdu=new WebDriverUtility(driver);
		
	ExcelFileUtility eFu= new ExcelFileUtility();
	String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1)+JavaUtility.generateRamNum();

	HomePageClass hpc= new HomePageClass(driver);
	hpc.getOrgButton().click();
	
	OrgPageClass opc= new OrgPageClass(driver);
	opc.getCreOrg().click();
	
	NewOrgPageClass nop=new NewOrgPageClass(driver);
	nop.orgTF(orgName);
	nop.getSaveButton().click();
	Thread.sleep(3000);

	}
}
