package com.bazinga.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bazinga.pom.pages.base.BasePage;

public class LaunchPage extends BasePage {

	WebDriver driver;

	public LaunchPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage gotoLogin() {
		driver.get("http://facebook.com");
		return PageFactory.initElements(driver, LoginPage.class);

	}
}
