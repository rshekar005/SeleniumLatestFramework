/**
 * 
 */
package com.qa.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.driver.DriverManager;
import com.qa.enums.ConfigProperty;
import com.qa.util.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author rajasekhar
 *
 */
public final class DriverFactory {
	private DriverFactory() {}

	public static WebDriver getDriver(String browser,String version) throws MalformedURLException {
		WebDriver driver=null;
		String runmode = ConfigReader.getValue(ConfigProperty.RUNMODE);
		if (browser.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase("Remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL(ConfigReader.getValue(ConfigProperty.SELENIUMGRIDURL)), cap);
				//Here we are not used DriverManager for chromedriver. Docker will take care of invoking chrome browser if it is remote
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runmode.equalsIgnoreCase("Remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL(ConfigReader.getValue(ConfigProperty.SELENIUMGRIDURL)), cap);
				//Here we are not used DriverManager for firefox driver. Docker will take care of invoking firefox browser if it remote
			}
			else {
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}	
		}
		return driver;
	}

}
