package com.bazinga.pom.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bazinga.pom.pages.base.BasePage;

public class LandingPage extends BasePage {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='linkWrap noCount']")
	public WebElement profilelink;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public ProfilePage gotoProfile() {

		profilelink.click();
		return PageFactory.initElements(driver, ProfilePage.class);
	}

}
