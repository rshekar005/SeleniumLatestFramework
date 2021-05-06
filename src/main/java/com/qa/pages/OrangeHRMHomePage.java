package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentManager;
import com.qa.reports.ExtentReport;

public class OrangeHRMHomePage extends BasePage{
	
	
	private By linkWelcome= By.id("welcome");
	private By logout=By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome() {
		doClick(linkWelcome, WaitStrategy.CLICKABLE ,"Welcome link");
		return this;
	}
	
	public OrangeLoginPage clickLogout() {
		doClick(logout,WaitStrategy.CLICKABLE, "logout button");
		return new OrangeLoginPage();
	}

}
