package com.bazinga.pom.Zones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class RedGreenOrange {

	@Test
	public void zonesTest() throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get(
				"https://www.news18.com/news/india/centre-marks-all-metro-city-as-red-zones-for-covid-19-curbs-post-may-3-heres-the-full-list-2600595.html");
		List<WebElement> allZones = driver
				.findElements(By.xpath("//div[@id='article_body']/p[contains(text(),'Zone')]"));
		String path = "C:\\Users\\ghorh\\Documents\\seleniumbazinga\\zones2.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.createSheet("Zones");
		wb.removeSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		int rowid = 0;

		for (WebElement e : allZones) {
			row = ws.createRow(rowid);
			cell = row.createCell(0);
			cell.setCellValue(e.getText());
			// System.out.println(e.getText());
			rowid++;
		}

		FileOutputStream fileOut = new FileOutputStream(path);
		wb.write(fileOut);
		fileOut.close();

	}

}
