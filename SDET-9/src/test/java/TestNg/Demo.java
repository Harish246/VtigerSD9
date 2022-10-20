package TestNg;

import org.testng.annotations.Test;

public class Demo extends Annotations {
	@Test()
	public void demo1() {
		System.out.println("demo1");
	}
	@Test(priority = 2 ,dependsOnMethods = "demo1" )
	public void demo2() { 
		System.out.println("demo2");
	}
	@Test(priority = 1 ,dependsOnMethods= "demo2" )
	public void demo3() {
		System.out.println("demo3");
	}
	@Test
	public void demo4() {
		System.out.println("demo4");
	}

}
