package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public BrowserUtility(WebDriver driver)
	{
		//this.driver=driver;
		
		this.driver.set(driver);
		
	}
	
	public BrowserUtility(String browserName)
	{
		logger.info("Launching browser for "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			//driver = new ChromeDriver();
			
			driver.set(new ChromeDriver());
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver.set(new FirefoxDriver());
		}
		
		else
		{
			logger.error("Invalid browser Name...Please select Chrome or Firefox only");
		}
	}
	
	public BrowserUtility(Browser browserName)
	{
		logger.info("Launching browser for "+browserName);
		
		if(browserName==Browser.CHROME)
		{
			
			driver.set(new ChromeDriver());
		}
		
		else if(browserName==Browser.FIREFOX)
		{
			
			driver.set(new FirefoxDriver());
		}
		
		else if(browserName==Browser.EDGE)
		{
			
			driver.set(new FirefoxDriver());
		}
		
		else
		{
			logger.error("Invalid browser Name...Please select Chrome or Firefox only");
		}
	}
	
	
	public BrowserUtility(Browser browserName, boolean isHeadless)
	{
		logger.info("Launching browser for "+browserName);
		
		if(browserName==Browser.CHROME)
		{
			if(isHeadless)
			{
				ChromeOptions options = new ChromeOptions();
				
				options.addArguments("--headless=old");
				
				options.addArguments("--window-size=1920,1080");
				
				driver.set(new ChromeDriver(options));
			}
			
			else
			{
				driver.set(new ChromeDriver());
			}
			
			
		}
		
		else if(browserName==Browser.FIREFOX)
		{
			if(isHeadless)
			{
				
				FirefoxOptions options = new FirefoxOptions();
				
				options.addArguments("--headless=old");
				
				options.addArguments("--window-size=1920,1080");
				
				driver.set(new FirefoxDriver(options));
			}
			
			else
			{
			driver.set(new FirefoxDriver());
			}
		}
		
		else
		{
			logger.error("Invalid browser Name...Please select Chrome or Firefox only");
		}
	}
	
	
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	
	
	public void goToWebsite(String url)
	{
		logger.info("Visiting the website "+url);
		
		//driver.get(url);
		
		driver.get().get(url);
		
	}
	
	public void maximizeWindow()
	{
		logger.info("Maximizing the browser window");
		
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		logger.info("Finding element with locator"+locator);
		
		WebElement element = driver.get().findElement(locator);
		
		logger.info("Element found and now performing click");
		
		element.click();
	}
	
	public void enterText(By locator, String textToEnter)
	{
		logger.info("Finding element with locator"+locator);
		
		WebElement element = driver.get().findElement(locator);
		
		logger.info("Element found and now enter text"+textToEnter);
		
		element.sendKeys(textToEnter);
	}
	
	public String getVisibilityText(By locator)
	{
		logger.info("Finding element with locator"+locator);
		
		WebElement element = driver.get().findElement(locator);
		
		logger.info("Element found and now returning visible text"+element.getText());
		
		return element.getText();
	}
	
	public String takeScreenShot(String name)
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver.get();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		
		String timeStamp = format.format(date);
		
		
		
		String path = System.getProperty("user.dir")+"//screenshots//"+name+" - "+timeStamp+".png";
		
		File screenShotFile = new File(path);
		
		try 
		{
		  FileUtils.copyFile(screenShotData, screenShotFile);
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return path;
	}
	
public void quit() {
		
		driver.get().quit();
	}
}
