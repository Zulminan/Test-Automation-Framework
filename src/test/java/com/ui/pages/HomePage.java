package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.constants.*;


public final class HomePage extends BrowserUtility {
	
	
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browserName, boolean isHeadless)
	{
		super(browserName,isHeadless);
		goToWebsite(JSONUtility.readJson(Env.QA).getUrl());
		
	}
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		goToWebsite(JSONUtility.readJson(Env.QA).getUrl());
		
	}
	
	

	public LoginPage gotoLoginPage()
	{
		logger.info("Trying to perform click to goto Sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}


	

}
