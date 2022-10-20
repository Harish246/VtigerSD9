package testNG_ParsPac;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

import GenericUtility.Amazon;
import GenericUtility.BaseClass;
public class Listeners_1 implements ITestListener 
{


	public void onTestFailure(ITestResult result) {
		//String testName=result.getMethod().getMethodName();
		//System.out.println(testName +"Execute ---> i am pass");
		TakesScreenshot ts= ((TakesScreenshot) BaseClass.sdriver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./ScreenShort/"+result.getMethod().getMethodName()+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		System.out.println("This will execute when @test will start");
	} 

	public void onTestSuccess(ITestResult result) {
		System.out.println("Good Job");
		System.out.println("This will execute when @test is gonna Pass");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getThrowable());	
	}



	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}



}
