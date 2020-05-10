package com.bazinga.pom.testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReadHashMap {

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

		Map<String, String> data = new HashMap<>();
		Map<String, String> key = new HashMap<>();

		for (int i = 0; i < files.length - 1; i++) {
			System.out.println(files[i].getName());

			BufferedReader inputStream = new BufferedReader(new FileReader(files[i]));
			String line;
			while ((line = inputStream.readLine()) != null) {
				data.put(line.split(",")[1], line.split(",")[1]);
			}

		}

		BufferedReader keys = new BufferedReader(
				new FileReader("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Files\\keys.txt"));
		String keyline;
		while ((keyline = keys.readLine()) != null) {
			key.put(keys.readLine(), keys.readLine());
		}

		Set<Entry<String, String>> keyset = key.entrySet();
		for (Entry<String, String> e : keyset) {
			System.out.println(e.getKey() + "----" + e.getValue());
		}
	}

}

//try with resources -- finally, connection close etc
