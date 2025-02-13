package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {
	
	private static final By USER_NAME_LOCATOR = By.cssSelector("#header .nav .container .row nav .header_user_info a span");
	
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.xpath("//div/div[1]/div[1]/div[2]/form[1]");
	
	private static final By SEARCH_BUTON_LOCATOR = By.xpath("//button[@name='submit_search']");
	
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public String getUserName()
	{
		return getVisibilityText(USER_NAME_LOCATOR);
	}
	
	

}
