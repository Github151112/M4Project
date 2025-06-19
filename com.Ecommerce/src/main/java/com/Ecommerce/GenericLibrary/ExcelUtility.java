package com.Ecommerce.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static Object[][] readMultipleData(String path, String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream f = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		int rowNo = sheet.getPhysicalNumberOfRows();
		int cellNo = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[rowNo - 1][cellNo];
		for (int i = 1; i < rowNo; i++) {
			for (int j = 0; j < cellNo; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return data;
	}

}
