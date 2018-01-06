package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
	public static String getCellValue(String path, String sheet, int r, int c) {
		String value = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {

		}
		return value;
	}

	public static int getRowCount(String path, String sheet) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		int rowCnt  = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowCnt = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {

		}
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));

		return rowCnt;

	}

}
