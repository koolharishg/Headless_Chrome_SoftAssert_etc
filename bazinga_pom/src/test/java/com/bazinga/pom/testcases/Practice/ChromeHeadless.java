package com.bazinga.pom.testcases.Practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class ChromeHeadless {

	@Test
	public void headlessScreenShot() throws IOException {

		DesiredCapabilities capability = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		capability.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://google.com");

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File("C:\\Users\\ghorh\\Documents\\seleniumbazinga\\screenshots" + "\\baz2" + ".png"));

	}

}
