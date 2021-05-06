package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.enums.WaitStrategy;

public final class AmazonHomePage extends BasePage{	
	private By Hamburgmenu= By.id("nav-hamburger-menu");
	
	public AmazonSideMenuPage clickHamurgMenu() {
		doClick(Hamburgmenu, WaitStrategy.CLICKABLE, "Hamburg Menu");
		return new AmazonSideMenuPage();
	}
}
