package com.bazinga.pom.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSMain {

	@Test
	public void js_exec() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log In']"));
		System.out.println(loginbutton.getAttribute("value"));
	}

}
