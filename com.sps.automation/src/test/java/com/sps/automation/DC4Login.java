package com.sps.automation;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class DC4Login extends WelcomeTest 
{
	int counter=0;
	String matchingProfileNameXpath;
	String matchingProfileNameTableCapabilityUIDValue;
	
@Test(priority=1)
	public void setUp() 
	{
		super.setUp();
	}

@Test(priority=2)
	public void preProdLoginUrl() 
	{
		super.preProdLoginUrl();
	}
@Test(priority=3)
	public void preProdLogin() 
	{
		super.preProdLogin();
	}
@Test(priority=4)
	public void clickDC4() 
	{
	
		super.clickDC4();
	}
@Test(priority=5)
	public void DC4EnterCompanyName() 
	{
		super.DC4EnterCompanyName("IRON CLAD PERFORMANCE WEAR CORP%");
		System.out.println("Entered Company Name");
	}
@Test(priority=6)
	public void clickDC4BrowseCustomersSearchButton() 
	{
			super.clickDC4BrowseCustomersSearchButton();
			System.out.println("Clicked Search Button");
	}
@Test(priority=7)
	public void DC4BrowseCustomers() 
	{
		super.DC4BrowseCustomers();
	}
@Test(priority=8)
	public void clickProfilesSubMenu() 
	{
		super.clickProfilesSubmenu();
	}
@Test(priority=9)
	public void listOfProfilesCall()
	{
		counter=super.listOfProfiles();
	}
@Test(priority=10)
	public void clickOnCompanyProfile() 
	{
		matchingProfileNameXpath=super.clickOnCompanyProfile(counter);
	}
@Test(priority=11)
	public void copyCapabilityUidCall()
	{
		matchingProfileNameTableCapabilityUIDValue=copyCapabilityUid(matchingProfileNameXpath, counter);
	}
@Test(priority=12)
	public void clickCapabilitiesSubmenu() 
	{
	super.clickCapabilitiesSubmenu();
	}
@Test(priority=13)
	public void enterCapabilityUIDValueCall()
	{
	super.enterCapabilityUIDValue(matchingProfileNameTableCapabilityUIDValue);
	}
@Test(priority=14)
public void clickOnCapabilitiesSearchButton()
	{
	super.clickOnCapabilitiesSearchButton();
	}
@Test(priority=15)
public void clickOnEditFileBrokerSettingsLink()
	{
	super.clickOnEditFileBrokerSettingsLink();
	}
}
