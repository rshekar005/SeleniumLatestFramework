package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.enums.WaitStrategy;
import com.qa.util.DynamicXpathUtils;

public final class AmazonSideMenuPage extends BasePage {
	
	private String linkSubmenu="//a[text()='%s']";
	private String clickComputers="//div[text()='Mobiles, Computers']/parent::a";
	
	public AmazonSideMenuPage clickComputers() {
		doClick(By.xpath(clickComputers), WaitStrategy.CLICKABLE, "Mobiles & Computers");
		return new AmazonSideMenuPage();
	}
	public AmazonLaptopPage clickSubmenu(String menulist) {
		String menu= DynamicXpathUtils.getDynamicXpath(linkSubmenu, menulist);
		doClick(By.xpath(menu), WaitStrategy.CLICKABLE, menulist);
		if(menulist.contains("Laptops")) {
			return new AmazonLaptopPage();
		}
		return null;
	}
}
