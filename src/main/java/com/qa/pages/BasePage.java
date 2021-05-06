package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.constants.FrameWorkConstants;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.factory.ExplicitWaitFactory;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentReport;

public class BasePage {

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * 
	 * It acts as a parent class for all page classes
	 * @author rajasekhar
	 * @param element By Locator of the webelement
	 * @param waitStrategy Strategy to find webelement. Known  strategies {@link com.qa.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	
	protected void doClick(By element, WaitStrategy waitStrategy, String elementname) {
		ExplicitWaitFactory.performExplicitWait(element, WaitStrategy.CLICKABLE).click();
		try {
			ExtentLogger.pass(elementname +" is clicked ", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * @author rajasekhar
	 * @param element By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitStrategy Strategy to find webelement. Known  strategies {@link com.qa.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void doSendKeys(By element, String value , WaitStrategy waitStrategy , String elementname) {	
		ExplicitWaitFactory.performExplicitWait(element, WaitStrategy.PRESENCE).sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered sucessfully in "+elementname, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Return page title of webpage in String
	 * @author rajasekhar
	 * @return Page title of the webpage where the selenium is currently interacting.
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
