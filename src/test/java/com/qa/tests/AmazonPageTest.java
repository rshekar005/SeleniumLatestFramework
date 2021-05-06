package com.qa.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.qa.annotation.FrameworkAnnotation;
import com.qa.enums.CategoryType;
import com.qa.pages.AmazonHomePage;
import com.qa.reports.ExtentManager;

public final class AmazonPageTest extends BaseTest{
	private AmazonPageTest() {}
	
	@FrameworkAnnotation(author = {"Rajashekar", "Narayana"}, category = { CategoryType.SANITY,CategoryType.REGRESSION })
	@Test
	public void amazonTest(Map<String,String> data) {
		 String title=new AmazonHomePage().clickHamurgMenu().clickComputers().clickSubmenu(data.get("menuname")).getTitile();
		 Assertions.assertThat(title).isNotNull();
	}

}
