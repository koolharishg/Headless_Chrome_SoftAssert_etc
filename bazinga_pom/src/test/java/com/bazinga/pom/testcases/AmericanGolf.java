package com.bazinga.pom.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmericanGolf {
	WebDriver driver = null;

	@Test
	public void putters() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://www.americangolf.co.uk/club-page");
		WebElement golf = driver.findElement(By.xpath("//*[@id=\"header-navigation\"]/div[1]/ul/li[2]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(golf).build().perform();
		WebElement putters = driver.findElement(By.xpath("(//span[text()='Putters'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(putters));
		putters.click();

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\putters_screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
