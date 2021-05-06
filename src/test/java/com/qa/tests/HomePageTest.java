package com.qa.tests;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.driver.Driver;
import com.qa.driver.DriverManager;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {
	}

	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.length()>15);
		Assert.assertTrue(title.length()<100);
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3/span"));
		Assert.assertEquals(elements.size(), 10);
		
		boolean isElementPresent = false;
		for(WebElement ele: elements) {
			if(ele.getText().equalsIgnoreCase("testing mini bytes -- youtube")) {
				isElementPresent=true;
				break;
			}
		}
		Assert.assertTrue(isElementPresent, "Testing mini bytes not found");
	}

	
}
