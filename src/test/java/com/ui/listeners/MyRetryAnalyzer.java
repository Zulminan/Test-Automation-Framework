package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer

{
	//private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS")); // from properties file
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS(); //from json
	
	
	private static int currentAttempt=1;

	@Override
	public boolean retry(ITestResult result)
	{
		if(MAX_NUMBER_OF_ATTEMPTS>=currentAttempt)
		{
			currentAttempt++;
			return true;
		}
		
		return false;
	}
}
