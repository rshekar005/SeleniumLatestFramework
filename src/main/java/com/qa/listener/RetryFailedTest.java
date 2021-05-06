package com.qa.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.enums.ConfigProperty;
import com.qa.util.ConfigReader;

/**
 *Implements {@link IRetryAnalyzer}.<p>
 * Helps in rerunning the failed tests.<p>
 * @author rajasekhar
 *
 */

public class RetryFailedTest implements IRetryAnalyzer{
	
	int counter =0;
	int maxlimit =1;
	
	/**
	 * Return true when needs to be retried and false otherwise.
	 * Maximum will retry for one time.
	 * Retry will happen if user desires to and set the value in the property file
	 */
	public boolean retry(ITestResult arg0) {
			if(ConfigReader.getValue(ConfigProperty.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				if(counter<maxlimit) {
					counter++;
					return true;
				}
				return false;
			}
	return false;
	}
}
