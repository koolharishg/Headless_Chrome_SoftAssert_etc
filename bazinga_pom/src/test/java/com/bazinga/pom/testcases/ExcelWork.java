package com.bazinga.pom.testcases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWork {

	@Test
	public void excelCheck() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet ws = wb.createSheet("Fruits");
		XSSFRow row;
		XSSFCell cell;

		int rowid;
		int cellid = 1;

		for (int i = 1; i <= 5; i++) {
			row = ws.createRow(i);
			cell = row.createCell(cellid);
			cell.setCellValue("Apple" + i);

		}

		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Fruits.xlsx"));
		wb.write(out);
		out.close();
		System.out.println("done");

	}
}
