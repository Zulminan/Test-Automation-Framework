/*
 * package com.ui.tests;
 * 
 * import org.openqa.selenium.chrome.ChromeDriver; import org.testng.Assert;
 * import org.testng.annotations.Test;
 * 
 * import com.ui.pages.HomePage; import com.utility.BrowserUtility;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement;
 * 
 * import io.github.bonigarcia.wdm.WebDriverManager;
 * 
 * 
 * public class LoginTestOLD {
 * 
 * public static void main(String args) { WebDriver wd = new ChromeDriver();//
 * Launch a Browser Window! ! Browser Session is
 * 
 * BrowserUtility browserUtility = new BrowserUtility(wd);
 * 
 * browserUtility.goToWebsite("http://www.automationpractice.pl/index.php?");
 * browserUtility.maximizeWindow();
 * 
 * //By signInLinkLocator = By.xpath("//a[contains(text(),\"Sign\")]");
 * 
 * //browserUtility.clickOn(signInLinkLocator);
 * 
 * HomePage homePage = new HomePage(wd);
 * 
 * homePage.gotoLoginPage();
 * 
 * 
 * By emailTextBoxLocator = By.id("email");
 * browserUtility.enterText(emailTextBoxLocator,"a@aa.com");
 * 
 * By passwordTextBoxLocator = By.id( "passwd");
 * browserUtility.enterText(passwordTextBoxLocator, "1234");
 * 
 * By submitLoginButtonLocator = By.id("SubmitLogin");
 * browserUtility.clickOn(submitLoginButtonLocator);
 * 
 * 
 * } }
 */