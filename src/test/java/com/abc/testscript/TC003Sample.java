package com.abc.testscript;
import java.awt.AWTException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

import com.abc.projectpage.TestngAnnotations;
import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.seleniumrepository.SeleniumRepoCheckBox;
import com.abc.seleniumrepository.SeleniumRepoDropdown;
import com.abc.util.PropertyFileRead;
/**
 * 
 * @author
 * Search related functionality testcases
 */

public class TC003Sample extends TestngAnnotations {
	
	
	@BeforeMethod
	public void BeforeTest() throws UnknownHostException
	{
	/*
	 * @param 1: Browser name -firefox or internetExplorer or chrome
	 *  Below firefox string is being read from the ProjectData.property file in resources package
	 *  
	 *  @param 2: Browser Proxy Yes or No. If yes then port and Host details are read from the Property file
	 */
		System.out.println("TestCase Starts");
		SeleniumRepo.startBrowser(PropertyFileRead.FileRead("ProjectData.properties","BrowserType"), false);
		SeleniumRepo.driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void AfterTest() throws UnknownHostException
	{
	System.out.println("TestCase Ends");
		SeleniumRepo.driver.quit();
		
	}
	/**
	 * @author
	 * Goes to a specific site and performs Search Suggestion Test
	 * @throws InterruptedException 
	 */
	@Test
	public void FormValidationTest() throws InterruptedException 
	{
	/*
	 * @param : Site URL Navigation
	 * URL is read from ProjectData.properties file in resources package
	 */
		System.out.println("Start Test");
		SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","TS03SiteURLNavigation"));
		SeleniumRepo.WaitForLoad(10);
		
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Email")))
		{
			SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Email"));
//			try {
//				SeleniumRepo.PressTab();
//				SeleniumRepo.WaitForLoad(10);
//				SeleniumRepo.PressShiftTab();
//				SeleniumRepo.WaitForLoad(50);
//			} catch (AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
				// Text Input Suggestion
//				if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","FirstNameErr")))
//				{
//				SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","FirstNameErr"));
//				
//				String FirstNameSuggestion =SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","FirstNameErr"));
//				System.out.println("FirstNameSuggestion = " + FirstNameSuggestion);		
//				}
//				else
//				{
//					System.out.println("Input Suggestion not found");
//				}
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Email"),"user@phptravels.com");
		System.out.println("First Name Textbox is found and First Name is Entered");
		}
		else
		{
			System.out.println("First Name Textbox not found");
			Assert.assertEquals("First Name TextBox","First Name TextBox Not found	","First Name TextBox Not found");
			
		}
		
		
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Password")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Password"));
		// Text Input Suggestion
			if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","LastNameErr")))
//			{
//			SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","LastNameErr"));
//			String LastNameSuggestion = SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","LastNameErr"));
//			System.out.println("LastNameSuggestion = " + LastNameSuggestion);		
//			}
//			else
//			{
//				System.out.println("Input Suggestion not found");
//			}
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Password"),"demouser");
		System.out.println("Last Name Textbox is found and Last Name is Entered");
		}
		else
		{
			System.out.println("LastName Textbox not found");
		}
		System.out.println(SeleniumRepo.driver.getCurrentUrl());
		//Click on the submit button
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Login")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Login"));
		System.out.println("Get started button is found and clicked");
		}
		else
		{
			System.out.println("GetStartedButton not found");
		}
		SeleniumRepo.WaitForLoad(50);
	}
}
