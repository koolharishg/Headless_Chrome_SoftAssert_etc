package com.bazinga.pom.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class temp {

	WebDriver driver;

	@Test
	public void launchfb() {
		driver = new ChromeDriver();
		driver.get("http://facebook.com");
	}
}
