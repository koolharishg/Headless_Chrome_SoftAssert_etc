package com.bazinga.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bazinga.pom.pages.base.BasePage;
import com.bazinga.pom.pages.session.LandingPage;

public class LoginPage extends BasePage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@id='pass']")
	public WebElement pass;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement login;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public Object Login(String username, String password) {

		email.sendKeys(username);
		pass.sendKeys(password);
		login.click();

		boolean loginsuccess = true;
		if (loginsuccess)
			return PageFactory.initElements(driver, LandingPage.class);
		else
			return PageFactory.initElements(driver, LoginPage.class);

	}
}
