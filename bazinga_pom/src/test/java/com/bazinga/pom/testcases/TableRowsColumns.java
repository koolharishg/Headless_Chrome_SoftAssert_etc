package com.bazinga.pom.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TableRowsColumns {

	WebDriver driver = null;

	@Test
	public void doTableTest() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://money.rediff.com/gainers");

		// display all column headings
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));

		for (WebElement e : columns) {
			System.out.println(e.getText());
		}

		// display number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

		System.out.println("number of rows ->" + rows.size());

		// all cells in 4th row

		// table[@class='dataTable']/tbody/tr[4]/td

		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[4]/td"));
		for (WebElement e : cells) {
			System.out.println("columns in 4th row are ->" + e.getText());
		}
	}

}
