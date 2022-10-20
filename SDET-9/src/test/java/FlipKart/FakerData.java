package FlipKart;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FakerData{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date=new Date();
		String d= date.toString();
		System.out.println(d);
		
		String[]arr=d.split("  ");
		String day = arr[0];
		String month= arr[1];
		String date1= arr[2];
		String year=arr[5];
		
		String exp=day+" "+month+" "+date1+" "+year;
		System.out.println(exp);
		
		
		
		
//		Faker fake = new Faker();
//		
//		String fname= fake.name().firstName();
//		System.out.println(fname);
//		
//		String cityname = fake.address().cityName();
//		System.out.println(cityname);
//		
//		String ename = fake.company().name();
//		System.out.println(ename);
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[@aria-label='"+exp+"']")).click();
		
		

	}

}
