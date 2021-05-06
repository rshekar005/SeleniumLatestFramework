package com.qa.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;
/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * @author rajasekhar
 *
 */
public final class ExtentManager {
	private ExtentManager() {
	}
	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author rajasekhar
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	static  ExtentTest getExtentTest() { // default access modifier, it can be accessed with in the package, private package
		return extentTest.get();
		
	}
	
	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author rajasekhar
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 */
	static void setExtentTest(ExtentTest test) {
		if(Objects.nonNull(test)) {
			extentTest.set(test);
		}
		
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author rajasekhar
	 */
	static void unload() {
		extentTest.remove();
	}

}
