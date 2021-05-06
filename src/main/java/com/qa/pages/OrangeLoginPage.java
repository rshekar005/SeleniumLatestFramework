package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.reports.ExtentReport;
import com.qa.util.DecodeUtils;

public class OrangeLoginPage extends BasePage{
	
	private By textboxusername = By.id("txtUsername");
	private By textboxpassword= By.xpath("//input[@id='txtPassword' and @type='password']");
	private By buttonlogin= By.id("btnLogin");
	
	public OrangeLoginPage enterUsername(String username) {
		doSendKeys(textboxusername, username,WaitStrategy.PRESENCE ,"username");
		return this;
	}
	
	public OrangeLoginPage enterPassword(String pwd) {
		doSendKeys(textboxpassword, DecodeUtils.getDecoderString(pwd),WaitStrategy.PRESENCE, "password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		doClick(buttonlogin,WaitStrategy.CLICKABLE,"Login button");
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}

}
