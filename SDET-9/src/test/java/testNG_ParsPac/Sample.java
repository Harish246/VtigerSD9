package testNG_ParsPac;

import org.testng.annotations.Test;

public class Sample extends Annotations {
	@Test(groups="smoke")
	public void createaccount() {
		System.out.println("smoke1");
	}
	@Test(groups="regression")
	public void createOrg() {
		System.out.println("regression1");
	}
	@Test(groups = {"integration","smoke","regression"})
	public void allconditions() {
		System.out.println("allconditions");
	}

}
