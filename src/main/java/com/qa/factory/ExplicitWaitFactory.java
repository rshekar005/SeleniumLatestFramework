package com.qa.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.constants.FrameWorkConstants;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * @author rajasekhar
 *
 */
public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {
	}

	/**
	 * 
	 * @author rajasekhar
	 * @param waitstrategy Strategy to be applied to find a webelement {@link com.qa.enums.WaitStrategy}
	 * @param by By locator of the webelement
	 * @return webelement Locates and return the webelement
	 */
	public static WebElement performExplicitWait(By locator, WaitStrategy waitStrategy) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(locator));
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitwait())
					.until(ExpectedConditions.presenceOfElementLocated(locator));
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} else {
			element = DriverManager.getDriver().findElement(locator);
		}
		return element;
	}

}
