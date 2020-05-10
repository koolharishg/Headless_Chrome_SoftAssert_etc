package com.bazinga.pom.pages.session;

import org.openqa.selenium.WebDriver;

import com.bazinga.pom.pages.base.BasePage;

public class ProfilePage extends BasePage {

	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public void VerifyProfile() {
		System.out.println("profile page reached successfully");
	}
}
