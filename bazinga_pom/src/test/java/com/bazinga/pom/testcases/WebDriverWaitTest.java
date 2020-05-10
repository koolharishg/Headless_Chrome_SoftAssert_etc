package com.bazinga.pom.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebDriverWaitTest {
	WebDriver driver = null;
	WebDriverWait wait = null;
	// yahoo search

	@Test
	public void yahoo() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);

		driver.get("https://in.yahoo.com/");
		driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys("Hello");
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//li[@role='option']"))));
		List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']"));
		for (WebElement e : options) {
			if (e.getText().equals("hello brother")) {
				e.click();
				// e.sendKeys(Keys.ENTER);
				e.submit();

			}
		}
	}

};