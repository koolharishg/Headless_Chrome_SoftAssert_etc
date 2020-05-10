package com.bazinga.pom.testcases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExceWork {

	@Test
	public void exelWork() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet ws = wb.createSheet("Testing");
		XSSFRow row;
		XSSFCell cell;

		for (int i = 0; i < 5; i++) {
			row = ws.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("Test" + i);
		}

		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Testing.xlsx"));
		wb.write(out);
		out.close();

		System.out.println("done");

	}

}
