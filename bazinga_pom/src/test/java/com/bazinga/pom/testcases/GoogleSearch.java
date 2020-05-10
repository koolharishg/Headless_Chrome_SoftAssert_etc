package com.bazinga.pom.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleSearch {

	@Test
	public void yahoo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bazinga");
		WebElement baz;
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='sbtc']/div/span")));
		// System.out.println("all elements are visible");
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='sbtc']/div/span"));
		for (WebElement e : options) {
			System.out.println(e.getText());

		}
	}

}
