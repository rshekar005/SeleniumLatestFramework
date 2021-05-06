package com.qa.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.constants.FrameWorkConstants;
import com.qa.enums.CategoryType;

/**
 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal 
 * variable for providing thread safety.
 * 
 * @author rajasekhar
 * @see com.qa.listener.Listener
 * @see com.qa.annotation.FrameworkAnnotation 
 *
 */
public final class ExtentReport {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {
	}

	private static ExtentReports extentReport;

	/**
	 * Set the initial configuration for the Extent Reports and decides the report generation path.
	 * @author rajasekhar
	 * @throws IOException 
	 */
	public static void initReport() {
		if (Objects.isNull(extentReport)) {
			extentReport = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath());
			/* spark.loadXMLConfig(new File("extentconfig.xml")); */
			
			  spark.config().setTheme(Theme.STANDARD);
			  spark.config().setDocumentTitle("Automation");
			  spark.config().setReportName("Automation Framework");
			 
			extentReport.attachReporter(spark);
			
			
		}
	}

	/**
	 * Flushing the reports ensures extent logs are reflected properly. 
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 * @author rajasekhar
	 */
	public static void flushReport()   {
		if (Objects.nonNull(extentReport)) {
			extentReport.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
 	 * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety

	 * @author rajasekhar
	 * @param testcasename  Test Name that needs to be reflected in the report
	 */
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extentReport.createTest(testcasename));
	}

	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives an clear idea of Authors Vs Percentage success metrics
	 * @author rajasekhar
	 * @param author  Authors who created a particular test case
	 */
	public static void addAuthors(String[] author) {
		for(String name: author) {
			ExtentManager.getExtentTest().assignAuthor(name);
		}
	}

	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group Vs Percentage success metrics.
	 * @author rajasekhar
	 * @param category category a particular test case belongs to.
	 */
	public static void addCategory(CategoryType[] category) {
		for(CategoryType temp: category) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}
