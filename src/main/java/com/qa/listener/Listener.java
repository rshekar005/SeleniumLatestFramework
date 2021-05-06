package com.qa.listener;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.annotation.FrameworkAnnotation;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentReport;
import com.qa.util.ELKUtils;
/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 * 
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 * @author rajasekhar
 *
 */
public class Listener implements ITestListener, ISuiteListener {

	/**
	 * Initialise the reports with the file name
	 * @see com.qa.reports.ExtentReport
	 */
	public void onStart(ISuite suite) {
				ExtentReport.initReport();
	}

	/**
	 * Terminate the reports
	 * @see com.qa.reports.ExtentReport
	 */
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Starts a test node for each testng test
	 * @see com.qa.reports.ExtentReport
	 * @see com.qa.annotation.FrameworkAnnotation
	 */
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
		
	}

	/**
	 * Marks the test as pass and logs it in the report
	 * @see com.qa.reports.ExtentLogger
	 */
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getDescription() + " is passed");
		ELKUtils.sendELKData(result.getMethod().getDescription(), "Pass");
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 * @see com.qa.reports.ExtentLogger
	 * @see com.qa.util.ScreenshotUtils
	 */
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getDescription() + " is failed");
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
			ExtentLogger.fail(result.getThrowable().toString()); // It will print 1 row in report
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ELKUtils.sendELKData(result.getMethod().getDescription(), "Fail");
	}

	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.qa.reports.ExtentLogger
	 */
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
		ELKUtils.sendELKData(result.getMethod().getDescription(), "Skip");
	}

	public void onFinish(ITestContext context) {
		/**
		 * For now we are not using
		 */
	}

	public void onStart(ITestContext context) {
		/**
		 * For now we are not using
		 */
	}

}
