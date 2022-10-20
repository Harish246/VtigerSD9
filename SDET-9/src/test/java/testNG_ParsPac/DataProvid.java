package testNG_ParsPac;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvid {
	@Test(dataProvider = "getData")

	public void BookTicket(String src,String dest) {
		System.out.println(src+"-->"+dest);
	}
	@DataProvider
	public Object [][] getData(){
		Object arr[][]=new Object[3][2];
		
		arr[0][0]="BLR";
		arr[0][1]="KKR";
		
		arr[1][0]="BTR";
		arr[1][1]="HYD";
		
		arr[2][0]="MAA";
		arr[2][1]="VIZAG";

		return arr;
	}
}
