package com.rmgyantra.ExtentReport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateReport {
	
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	@Test
	
	public void createReport() throws Throwable {
		reporter=new ExtentSparkReporter("./ExtentReport/SDRepo.html");
		reporter.config().setDocumentTitle("NEW FB3");
		reporter.config().setTheme(Theme.STANDARD);
		
		reports= new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Build", "10.3.5");
		reports.setSystemInfo("Report Name", "Harish");
		reports.setSystemInfo("Env", "QA");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://facebook.com");
		test=reports.createTest("FBd");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path="./ScreenShort/Fbb2.png";
		File dest = new File(path);
		Files.copy(src, dest);
		
		test.addScreenCaptureFromPath(path);
		Assert.assertEquals(true, true);
		
		
		
		reports.flush();

	}
	
	@AfterSuite
	public void as() {
		reports.flush();
	}
	

}
