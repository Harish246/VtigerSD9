package testNG_ParsPac;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;

public class ExcelDataProvider {
	@Test(dataProvider = "excedata") 
	public void getData(String un , String pwd) {
		System.out.println(un + "-->" + pwd);
	}
	@DataProvider
	public Object[][] excedata() throws Throwable{
		Object arr[][]=new Object[4][2];
		
		ExcelFileUtility excelFileUtility=new ExcelFileUtility();
		
		for(int i=0;i<=excelFileUtility.getLastRowCount("Sheet2");i++ ) {
			arr[i][0]=excelFileUtility.readDataFromExcelFile("Sheet2", i, 0);
			arr[i][1]=excelFileUtility.readDataFromExcelFile("Sheet2", i, 1);
			
		}
		return arr;
		}
	

}
