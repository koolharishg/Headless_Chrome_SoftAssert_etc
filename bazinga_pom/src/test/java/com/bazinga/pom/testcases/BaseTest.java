package com.bazinga.pom.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public WebDriver driver;

	public void init(String bType) {

		if (bType.equals("Chrome")) {
			ChromeOptions cr = new ChromeOptions();
			cr.addArguments("--disable-notifications");
			driver = new ChromeDriver(cr);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else {
			driver = new FirefoxDriver();
		}

	}
}