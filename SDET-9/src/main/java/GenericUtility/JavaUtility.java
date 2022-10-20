package GenericUtility;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtility {
	public static int generateRamNum() {
		Random r= new Random();
		int ranNum=r.nextInt(1000);
//		System.out.println(ranNum);
		return ranNum;
	}
	
	

}
