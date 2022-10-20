
package VerifyVtiger_pom;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepo.HomePageClass;
import ObjectRepo.NewOrgPageClass;
import ObjectRepo.OrgPageClass;
import ObjectRepo.Organisation_infoClass;

@Listeners
public class CreateOrgInd extends BaseClass{
	
	
	@Test(groups= {"smoke","regression","integration"})
	public void createOrgInd() throws Throwable {
		WebDriverUtility wdu=new WebDriverUtility(driver);
		
	ExcelFileUtility eFu= new ExcelFileUtility();
	String orgName=eFu.readDataFromExcelFile("Sheet1", 1, 1)+JavaUtility.generateRamNum();
	String indType=eFu.readDataFromExcelFile("Sheet1", 4, 2);

	HomePageClass hpc= new HomePageClass(driver);
	hpc.getOrgButton().click();
	
	OrgPageClass opc= new OrgPageClass(driver);
	opc.getCreOrg().click();
	Thread.sleep(3000);
	
	
	NewOrgPageClass nop=new NewOrgPageClass(driver);
	nop.orgTF(orgName);
	nop.indt(indType);
	nop.getSaveButton().click();

	Organisation_infoClass oic=new Organisation_infoClass(driver);
	Assert.assertEquals(orgName, oic.hText1());
	
	}
}
