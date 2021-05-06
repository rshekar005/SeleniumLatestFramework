package com.qa.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.listener.RetryFailedTest;
import com.qa.pages.OrangeHRMHomePage;
import com.qa.pages.OrangeLoginPage;
import com.qa.reports.ExtentReport;
import com.qa.util.DataProviderUtils;

public final class OrangeHRMTest extends BaseTest {
	private OrangeHRMTest() {
	}

	@Test
	public void doLoginLogout(Map<String, String> data) {
		OrangeLoginPage login = new OrangeLoginPage();
		String title = login.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}

	@Test
	public void newTest(Map<String, String> data) {
		OrangeLoginPage login = new OrangeLoginPage();
		String title = login.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	/*
	 * @DataProvider(parallel = true) public Object[][] getLoginData(){ return new
	 * Object[][] { {"Admin","admin123"}, {"Admin123","admin123"} {"123","1234"},
	 * {"A1dmin","adm1in123"}, {"anv","cbd"}, {"Admwin","adminq123"},
	 * {"kjdk","ojjsj"} }; }
	 */

}
