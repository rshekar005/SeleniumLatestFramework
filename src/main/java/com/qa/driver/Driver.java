package com.qa.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.Exceptions.BrowserException;
import com.qa.constants.FrameWorkConstants;
import com.qa.enums.ConfigProperty;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *
 * Driver class is responsible for initializing and closing the driver.
 * <p>
 * It is responsible for setting the driver variable to DriverManager which
 * handles the thread safety for the webdriver instance.
 * <p>
 * 
 * @author rajasekhar
 * @see DriverManager
 * @see com.qa.tests.BaseTest
 *
 */
public final class Driver{

	/**
	 * Private constructor to avoid external initialization
	 */
	private Driver() {
	}

	/**
	 * @param browser -- Value will be passed from BaseTest. Values can be chrome or
	 *                firefox. These are fetching from Excel
	 *  @param version -- Value will be passed from BaseTest. Values will fetched from the excel.
	 * @throws MalformedURLException
	 */
	public static void initDriver(String browser,String version) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser,version));
			} catch (MalformedURLException e) {
				throw new BrowserException("Browser invocation failed. Please check the capabilities");
			}
			DriverManager.getDriver().get(ConfigReader.getValue(ConfigProperty.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}

}
