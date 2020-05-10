package com.bazinga.pom.testcases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BlankWB {

	public static void main(String[] args) throws IOException {

		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");

		// Create row object
		XSSFRow row;
		XSSFCell cell;

		int rowid = 0;
		int cellid = 0;

		for (int i = 1; i <= 5; i++) {
			row = spreadsheet.createRow(rowid++);
			cell = row.createCell(cellid);
			cell.setCellValue(i);
		}

		// Write the workbook in file system

		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Files\\bazinga.xlsx"));

		workbook.write(out);
		out.close();
		System.out.println("Writesheet.xlsx written successfully");

	}

}
