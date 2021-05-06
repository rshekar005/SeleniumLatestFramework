/**
 * 
 */
package com.qa.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

/**
 * @author rajasekhar
 *
 */
public class RunSeleniumInDocker {
	
	@Test
	public void runSeleniumInDocker() throws MalformedURLException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		cap.setCapability("enableVNC", true);
		cap.setCapability("enableVideo", true);
		cap.setCapability("videoName", "test1_video.mp4");
		WebDriver driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.google.com");
		String title= driver.getTitle();
		System.out.println(title);
		driver.findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);
		Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
		driver.quit();
		
	}

}
