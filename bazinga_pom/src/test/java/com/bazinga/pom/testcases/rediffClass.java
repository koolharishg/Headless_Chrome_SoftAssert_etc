package com.bazinga.pom.testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class rediffClass {
	WebDriver driver = null;
	WebDriverWait wait;

	@Test
	public void selectdate() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);

		driver.get("http://in.rediff.com/");
		driver.findElement(By.cssSelector(".moneyicon.relative")).click();
		driver.findElement(By.xpath("//a[text()='Sign In']")).click();
		driver.findElement(By.cssSelector(".input")).sendKeys("koolharishg@gmail.com");
		driver.findElement(By.cssSelector("input#emailsubmit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#userpass")));
		driver.findElement(By.cssSelector("input#userpass")).sendKeys("Eight@24");
		driver.findElement(By.cssSelector("input#loginsubmit")).click();
		driver.findElement(By.cssSelector("input#addStock")).click();
		driver.findElement(By.cssSelector("input#addstockname")).sendKeys("Tata Steel");
		driver.findElement(By.cssSelector(".optionDivSelected")).click();
		selectdate("24/05/2020");

	}

	private void selectdate(String selecteddate) {
		Date current = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date tobe = sd.parse(selecteddate);
			String day = new SimpleDateFormat("dd").format(tobe);
			String month = new SimpleDateFormat("MMMM").format(tobe);
			String year = new SimpleDateFormat("yyyy").format(tobe);
			String desiredmonyear = month + " " + year;
			System.out.println("desired month and year->" + desiredmonyear);

			while (true) {
				driver.findElement(By.cssSelector("a#stockPurchaseDate")).click();
				String displayeddate = driver.findElement(By.cssSelector(".dpTitleText")).getText();
				System.out.println("displayed date " + displayeddate);
				if (desiredmonyear.equals(displayeddate)) {
					// select date
					driver.findElement(By.cssSelector(".dpTD")).click();
					break;
				} else {

					if (tobe.compareTo(current) > 0) {
						// move forward
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")));
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();

					} else if (tobe.compareTo(current) < 0) {
						// move backward
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")));
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
					}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
