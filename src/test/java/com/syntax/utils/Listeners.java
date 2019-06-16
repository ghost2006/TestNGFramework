package com.syntax.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) { //will listen to each test case @Test
		System.out.println("Test case started: " + result.getName()); //get a name of our test case
		test= report.createTest(result.getName()); //creating a report
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed: "+ result.getName());
		test.pass("Test passed: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed: "+ result.getName());
		test.fail("Test failed: "+result.getName());
	 String imagePath=CommonMethods.takeScreenshot(result.getName());
	 try {
		test.addScreenCaptureFromPath(imagePath);
	} catch (IOException e) {
		e.printStackTrace();
		test.info("Not able to attach screeenshot");
	}
}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: "+ result.getName());
	}

	@Override
	public void onStart(ITestContext context) { //name of the test in xml.file
	System.out.println("Test started: "+ context.getName());		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test finished: "+ context.getName());		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {	
	}
	
	
}
