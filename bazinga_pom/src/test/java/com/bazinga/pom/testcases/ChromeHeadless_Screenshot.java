package com.bazinga.pom.testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeHeadless_Screenshot {

	public static WebDriver driver;

	@BeforeClass
	public static void Setup() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	@Test
	public static void logoCheck() {
		boolean logo = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();

		assertTrue(logo);
		// capture screenshot of google homepage
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\headless_screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}