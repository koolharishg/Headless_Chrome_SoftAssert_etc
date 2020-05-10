package com.bazinga.pom.testcases;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.bazinga.pom.pages.LaunchPage;
import com.bazinga.pom.pages.LoginPage;
import com.bazinga.pom.pages.session.LandingPage;
import com.bazinga.pom.pages.session.ProfilePage;

public class ProfileTest extends BaseTest {

	@Test
	public void TestProfile() {
		init("Chrome");
		LaunchPage launchpage = PageFactory.initElements(driver, LaunchPage.class);
		LoginPage loginpage = launchpage.gotoLogin();
		Object page = loginpage.Login("koolharishg@gmail.com", "donnoone");

		if (page instanceof LoginPage)
			Assert.fail("login failed");
		else if (page instanceof LandingPage)
			System.out.println("login successful");

		LandingPage landingpage = (LandingPage) page;
		ProfilePage profilepage = landingpage.gotoProfile();
		profilepage.getMenu().logout();

	}

}
