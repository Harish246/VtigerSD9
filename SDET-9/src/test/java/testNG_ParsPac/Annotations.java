package testNG_ParsPac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	
	@BeforeSuite(groups ="smoke")
	public void BeforeSuite() {
		System.out.println("@BeforeSuite");
	}
	@AfterSuite(groups="smoke")
	public void AfterSuite() {
		System.out.println("@AfterSuite");
	}
	@BeforeTest(groups ="regression")
	public void BeforeTest() {
		System.out.println("@BeforeTest");
	}
	@AfterTest(groups ="regression")
	public void AfterTest() {
		System.out.println("@AfterTest");
	}
	
	@BeforeClass(groups ="integration")
	public void BeforeClass() {
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("@AfterClass");
	}
	@BeforeMethod(groups ={"smoke","regression","integration"})
	public void BeforeMethod() {
		System.out.println("@BeforeMethod");
	}
	@AfterMethod(groups ={"smoke","regression","integration"})
	public void AfterMethod() {
		System.out.println("@AfterMethod");
		
	}
	
}

