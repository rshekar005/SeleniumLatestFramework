package com.qa.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 *  
 * @author rajasekhar
 * @see Driver
 */
public final class DriverManager{
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {
	}
	private static ThreadLocal<WebDriver> tldriver= new ThreadLocal<WebDriver>();
	
	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 * 
	 * @author rajasekhar
	 * @return {@link org.openqa.selenium.WebDriver} instance.
	 */
	public static  WebDriver getDriver() {
		return tldriver.get();
	}
	
	/**
	 * Set the WebDriver instance to thread local variable.
	 * @author rajasekhar
	 * <p>
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p> 
	 * default
	 */
	static void setDriver(WebDriver driverref) {
		if(Objects.nonNull(driverref)) {
			tldriver.set(driverref);
		}
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * 
	 * @author rajasekhar
	 */
	static void unload() {
		tldriver.remove();
	}
}
