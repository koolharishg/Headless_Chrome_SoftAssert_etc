package com.bazinga.pom.testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NaukriTest {

	@Test
	public void Naukri() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.get("https://www.naukri.com/");
		Set<String> winids = driver.getWindowHandles();
		System.out.println(winids.size());
		Iterator<String> it = winids.iterator();
		String mainwid = it.next();
		String pop = it.next();
		driver.switchTo().window(pop);
		driver.close();

	}

}
