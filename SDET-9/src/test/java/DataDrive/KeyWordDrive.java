package DataDrive;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class KeyWordDrive {

	public static void main(String[] args) throws Throwable  {
		//DataFormatter df = new DataFormatter();

		FileInputStream fis=new FileInputStream("../SDET-9/SQLmode.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh= wb.getSheet("Sheet1");

		int lastrow=sh.getLastRowNum(); 
		
		/*
		 * Description = 
		 */

		//		for (int i = 1; i <= lastrow; i++)
		//		{
		//			String name =sh.getRow(i).getCell(1).getStringCellValue();
		//			System.out.println(name);
		//			
		//		}

		//		for (int i = 1; i <=lastrow; i++) {
		//			int sal=(int)sh.getRow(i).getCell(3).getNumericCellValue();
		//			if(sal>35000)
		//			{
		//				String name=sh.getRow(i).getCell(1).getStringCellValue();
		//				System.out.println(name);
		//			}
		//		}

		for (int i = 1; i <= lastrow; i++) 
		{

			String dept =sh.getRow(i).getCell(2).getStringCellValue();
			if(dept.equalsIgnoreCase("Q/A")) {
				String name=sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println(name);
			}
		}



	}

}
