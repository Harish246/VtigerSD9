package DataDrive;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class KeyWordDriveSqlTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		DataFormatter df = new DataFormatter();
		FileInputStream fis= new FileInputStream("./SQLmode.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int sal=sh.getFirstRowNum();
		
//           r = sh.getRow(0);
//    	Cell c = r.getCell(0);
//    	String s = c.getStringCellValue();
		
		int lastrow=sh.getLastRowNum(); 
		System.out.println(lastrow);
		int firstrow=sh.getFirstRowNum();
		
		for(int i=0;i<=lastrow;i++) {
			for(int j=0;j<=firstrow;j++) {
				if (i>35000) {
					String data1=df.formatCellValue(wb.getSheet("Sheet1").getRow(i).getCell(3));
					System.out.println(data1);
				}
				else {
				String data1=df.formatCellValue(wb.getSheet("Sheet1").getRow(i).getCell(3));
				System.out.println(data1);
				}
			}
			
			
		}

	}

}
