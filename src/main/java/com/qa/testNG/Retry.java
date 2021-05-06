package com.qa.testNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	/**
	 * Whenever the test is fails then this method retry will be called.
	 * If this method returns true then it will rerun
	 * If this method returns false then it will not rerun
	 */
	
	int counter =0;
	int maxlimit =2;
	public boolean retry(ITestResult arg0) {
		if(counter<maxlimit) {
			counter++;
			return true;
		}
		return false;
	}

}
