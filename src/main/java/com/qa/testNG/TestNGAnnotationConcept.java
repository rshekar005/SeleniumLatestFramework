package com.qa.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 
 * @author rajasekhar
 * Annotation will start with '@'
 * Each and every annotation will associate with method
 */
public class TestNGAnnotationConcept {
	
	@BeforeSuite//1
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	@BeforeClass//3
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod//5
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@BeforeTest//2
	public void beforeTest()
	{
		System.out.println("Before Test");
	}

	@BeforeGroups("IT Department")//4
	public void group()
	{
		System.out.println("Before Group");
	}
	
	@AfterGroups("IT Department")
	public void afterGroup()
	{
		System.out.println("After Group");
	}
	@Test(groups="IT Department")//6
	public void test()
	{
		System.out.println("Test method 1");
	}
	@Test
	public void test1()
	{
		System.out.println("Test method 2");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After Class");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite");
	}
}
