package com.qa.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.driver.DriverManager;
import com.qa.enums.ConfigProperty;
import com.qa.util.ConfigReader;
import com.qa.util.ScreenshotUtils;

/**
 * Used for logging the events in the extent report.
 * <p>
 * Encapsulates the unnecessary methods from users
 * @author rajasekhar
 *
 */
public final class ExtentLogger {
	private ExtentLogger() {
	}

	/**
	 * Logs pass event in the extent report
	 * @author rajasekhar
	 * @param message custom message that needs to be logged
	 */
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	/**
	 * Logs fail event in the extent report
	 * @author rajasekhar
	 * @param message custom message that needs to be logged
	 */
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	/**
	 * Logs skip event in the extent report
	 * @author rajasekhar
	 * @param message custom message that needs to be logged
	 */
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	/**
	 * Logs pass event in the extent report based on user input in property file
	 * @author rajasekhar
	 * @param message custom message that needs to be logged
	 * @param isScreenShotNeeded appends screenshot when true ,ignore otherwise
	 */
	public static void pass(String message, boolean isScreenShotNeeded){
		if(ConfigReader.getValue(ConfigProperty.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}

	/**
	 * Logs fail event in the extent report based on user input in property file
	 * @author rajasekhar
	 * @param message custom message that needs to be logged
	 * @param isScreenShotNeeded appends screenshot when true ,ignore otherwise
	 */
	public static void fail(String message, boolean isScreenShotNeeded)  {
		if(ConfigReader.getValue(ConfigProperty.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}

	/**
	 * Logs skip event in the extent report based on user input in property file
	 * @author rajasekhar
	 * @param message custom message that needs to be logged
	 * @param isScreenShotNeeded appends screenshot when true ,ignore otherwise
	 */
	public static void skip(String message, boolean isScreenShotNeeded){
		if(ConfigReader.getValue(ConfigProperty.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") 
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().skip(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}


}
