package com.bazinga.pom.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTest {
	WebDriver driver = null;

	@Test
	public void Test1() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://facebook.com");
		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void Test2() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://google.com");
		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void Test3() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(5000);
		driver.close();
	}

}
