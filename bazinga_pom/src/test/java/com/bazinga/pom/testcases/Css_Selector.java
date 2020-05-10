package com.bazinga.pom.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Css_Selector {

	@Test
	public void FB_Login() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.cssSelector("input#email")).sendKeys("koolharishg@gmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("donnoone");
		driver.findElement(By.cssSelector("label#loginbutton")).click();

		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("alert is not present");

		} else {
			System.out.println("alert is present");
		}

	}
}
