package GenericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String readDataFromExcelFile(String SheetNum, int rowNum, int cellNum) throws Throwable{
		FileInputStream fis = new FileInputStream("./CommonData/ComD.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sn = wb.getSheet(SheetNum);
		Row rn = sn.getRow(rowNum);
		Cell cn = rn.getCell(cellNum);
		String value = cn.getStringCellValue();
		return value;
	}
	public int getLastRowCount(String SheetNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./CommonData/ComD.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(SheetNum).getLastRowNum();
	}

}
