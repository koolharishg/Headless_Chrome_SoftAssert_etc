package com.bazinga.pom.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bazinga.pom.pages.common.TopMenu;

public class BasePage {

	public WebDriver driver;
	public TopMenu menu;

	public BasePage() {

	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
		menu = PageFactory.initElements(driver, TopMenu.class);
	}

	public String verifyTitle(String expTitle) {
		return "";
	}

	public TopMenu getMenu() {
		return menu;
	}

}
