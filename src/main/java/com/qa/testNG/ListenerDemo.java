package com.qa.testNG;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener , ISuiteListener{

	public void onFinish(ISuite suite) {
		System.out.println("after suite in listener");
	}

	public void onStart(ISuite suite) {
		System.out.println("before suite in listener");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" + result.getName());
	}

}
