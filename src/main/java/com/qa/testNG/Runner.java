package com.qa.testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Runner {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite in runner");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite in runner");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method in runner");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method in runner");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	@Test
	public void test2() {
		System.out.println("test2");
		Assert.assertTrue(false);
	}
	@Test
	public void test3() {
		System.out.println("test3");
	}
}
