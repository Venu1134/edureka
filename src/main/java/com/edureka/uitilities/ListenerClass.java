package com.edureka.uitilities;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.base.BaseClass;
import com.ics.actionDriver.ActionClass;

public class ListenerClass extends BaseClass implements ITestListener {

	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestMethod = new ThreadLocal<ExtentTest>();
	public WebDriver driver = null;
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName+" Test Started");
		extentTestMethod.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		//extentTest.generateLog(Status.PASS, testName+"Test Passed");
		if(result.getStatus() == ITestResult.SUCCESS) {
		extentTestMethod.get().log(Status.PASS, testName +"Test Passed");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			extentTestMethod.get().fail(result.getThrowable());
			String testName = result.getName();
			try {
				String screenShotFilePath = ActionClass.screenShot(BaseClass.getDriver(), testName);
				extentTestMethod.get().addScreenCaptureFromPath(screenShotFilePath, testName);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
}
