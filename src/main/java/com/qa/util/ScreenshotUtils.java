package com.qa.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.driver.DriverManager;

/**
 * Utility to take base64 screenshot.
 * 
 * @author rajasekhar
 *
 *@see com.qa.reports.ExtentLogger
 */
public final class ScreenshotUtils {
	private ScreenshotUtils() {}
	
	/**
	 * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
	 * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
	 * a new method. It is advisable to use this method for many reasons.
	 * 
	 * @author rajasekhar
	 * @return Image in the form of Base64 String which can be appended directly to report
	 */
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);	
	}

}
