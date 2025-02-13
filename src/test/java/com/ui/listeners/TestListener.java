package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener 

{
	
Logger logger = LoggerUtility.getLogger(this.getClass());
	

	public void onTestStart(ITestResult result) 
	{
	 
	   logger.info(result.getMethod().getMethodName());
	   logger.info(result.getMethod().getDescription());
	   logger.info(Arrays.toString(result.getMethod().getGroups()));
	   
	   ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	   
	   
	  }
	
	public void onTestSuccess(ITestResult result) 
	{
		logger.info(result.getMethod().getMethodName()+" PASSED");
		
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" PASSED");
	  }
	
	public void onTestFailure(ITestResult result) 
	{
	    logger.error(result.getMethod().getMethodName()+" FAILED");
	    logger.error(result.getThrowable().getMessage());
	    
	    ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" FAILED");
	    ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
	    
	    Object testClass = result.getInstance();
	    
	    BrowserUtility browserUtility  = ((TestBase)testClass).getInstance();
	    
	    logger.info("Capturing screenshot of failed tests");
	    
	    String screenShotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
	    
	    logger.info("Attaching screenshot to HTML file");
	    
	    ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenShotPath);
	    
	    
	  }
	
	public void onTestSkipped(ITestResult result) 
	{
		logger.warn(result.getMethod().getMethodName()+" SKIPPED");
		
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" SKIPPED");
		
	  }
	
	public void onStart(ITestResult result)  //test suite
	{
	    logger.info("Test Suite Started!!!");
	    
	  ExtentReporterUtility.setUpSparkReporter("report.html");
		
	  }
	
	public void onFinish(ITestResult result) //test suite
	{
		logger.info("Test Suite Completed!!!");
		
		ExtentReporterUtility.flushReport();
		
	  }
	

}
