package com.bazinga.pom.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ChromeNewDr {

	@Test
	public void TestChrome() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://facebook.com");
	}

}
