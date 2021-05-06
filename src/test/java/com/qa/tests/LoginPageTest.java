package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qa.driver.Driver;
import com.qa.driver.DriverManager;


public final class LoginPageTest extends BaseTest{
	
	private  LoginPageTest() {
		
	}
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium" , Keys.ENTER);
	}
	
	
}
