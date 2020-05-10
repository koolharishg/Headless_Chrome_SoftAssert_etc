package com.bazinga.pom.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class headless {

	@Test
	public void doHeadLess() {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://google.com");
		WebElement element = driver
				.findElement(By.xpath("//img[@title='To all doctors, nurses, and medical workers, thank you']"));
		wait.until(ExpectedConditions.visibilityOf(element));

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		try {
			FileUtils.copyFile(file, new File(
					"C:\\Users\\ghorh\\Documents\\seleniumbazinga\\" + "headless_screenshot" + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
