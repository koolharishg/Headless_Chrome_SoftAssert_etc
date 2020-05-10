package com.bazinga.pom.testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileRead1 {

	public static void main(String[] args) throws IOException {

		boolean check;
		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet("Validate");

		// Create row object
		XSSFRow row;

		// Create cell object
		XSSFCell cell;

		// set initial row and column

		int rowid = 0;
		int cellid = 0;

		// get files directory

		String target_dir = "C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Files";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();
		System.out.println(files.length);

		for (int i = 0; i < files.length - 1; i++) {

			try {
				BufferedReader inputStream = new BufferedReader(new FileReader(files[i]));
				String line;
				try {
					while ((line = inputStream.readLine()) != null) {
						String baz = line.split(",")[1];
						check = comparetokeys(baz);
						if (check) {
							row = spreadsheet.createRow(rowid++);
							cell = row.createCell(cellid);
							cell.setCellValue(baz);
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (inputStream != null) {
						try {
							inputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\result\\bazinga.xlsx"));

		workbook.write(out);
		out.close();
		System.out.println("Writesheet.xlsx written successfully");

	}

	public static boolean comparetokeys(String str) throws IOException {
		int flag = 0;
		BufferedReader bf = new BufferedReader(
				new FileReader("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Files\\keys.txt"));
		String lin;
		while ((lin = bf.readLine()) != null) {
			if (lin.equals(str)) {
				System.out.println(str);
				flag = 1;
				return true;
			}
		}
		bf.close();
		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}

}

//try with resources -- finally, connection close etc
