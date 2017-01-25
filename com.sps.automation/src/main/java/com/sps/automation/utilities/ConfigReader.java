package com.sps.automation.utilities;

import java.io.File;


import java.io.FileInputStream;

import java.util.Properties;

public class ConfigReader 
{
	//Making it a Global Variable
	Properties pro;
	public ConfigReader()
	{
		File src=new File("./Configuration/Config.property");
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getMozillaPath()
	{
		return pro.getProperty("MOZILLADRIVER");
	}
	
	public String getChromePath()
	{
		return pro.getProperty("CHROMEDRIVER");
	}
	
	public String getTransactionTrackerUrl()
	{
		return pro.getProperty("TRANSACTION_TRACKER_URL");
	}
	
	//***********************SPS TRACKER LOGIN PAGE****************************
	
	public String getLoginPageUsernamePath()
	{
		return pro.getProperty("USERNAME_XPATH");
	}
	
	public String getLoginPagePasswordPath()
	{
		return pro.getProperty("PASSWORD_XPATH");
	}
	
	public String getLoginPageSignInPath()
	{
		return pro.getProperty("SIGNIN_XPATH");
	}
	
	public String getLoginPageUsernameValue()
	{
		return pro.getProperty("USERNAME_VALUE");
	}

	public String getLoginPagePasswordValue()
	{
		return pro.getProperty("PASSWORD_VALUE");
	}
	
	public String getTransactionTrackerPath()
	{
		return pro.getProperty("TRANSACTION_TRACKER_XPATH");
	}
	
	
	//**************************************************************************

	//***********************DC4 PRE PROD LOGIN PAGE****************************
	
	public String getPreProdUrl()
	{
		return pro.getProperty("PREPROD_URL");
	}
		
	public String getPreProdLoginPageUsernamePathXpath()
	{
		return pro.getProperty("PREPROD_LOGIN_USERNAME_XPATH");
	}
	
	public String getPreProdLoginPageUsernameValue()
	{
		return pro.getProperty("PREPROD_LOGIN_USERNAME_VALUE");
	}
		
	public String getPreProdLoginPagePasswordPathXpath()
	{
		return pro.getProperty("PREPROD_LOGIN_PASSWORD_XPATH");
	}
	public String getPreProdLoginPagePasswordValue()
	{
		return pro.getProperty("PREPROD_LOGIN_PASSWORD_VALUE");
	}
	
	public String getPreProdLoginPageLoginButtonPathXpath()
	{
		return pro.getProperty("PREPROD_LOGIN_LOGINBUTTON_XPATH");
	}
	
	//**************************************************************************
	
	//***********************DC4 PRE PROD HOME PAGE****************************

	public String getPreProdHomePageDC4PathXpath()
	{
		return pro.getProperty("PREPROD_HOMEPAGE_DC4LINK_XPATH");
	}
	
	//**************************************************************************

	//***********************DC4 Tab****************************

	public String getPreProdDC4CompanyNameXpath()
	{
		return pro.getProperty("PREPROD_DC4_COMPANY_NAME_XPATH");
	}
	
	public String getPreProdDC4BrowseCustomersTableXpath()
	{
		return pro.getProperty("PREPROD_DC4_BROWSE_CUSTOMERS_TABLE_XPATH");
	}
	
	public String getPreProdDC4BrowseCustomersSearchButtonXpath()
	{
		return pro.getProperty("PREPROD_DC4_BROWSE_CUSTOMERS_SEARCH_BUTTON_XPATH");
	}
	
	//**************************************************************************
	
	
	//***********************Profiles****************************

	public String getPreProdProfileListOfProfilesXpath()
	{
		return pro.getProperty("PREPROD_PROFILE_LIST_OF_PROFILES_XPATH");
	}

	//***********************Capabilities****************************

	public String getPreProdCapabilitiesCapabilityUIDXpath()
	{
		return pro.getProperty("PREPROD_CAPABILITIES_CAPABILITY_UID_XPATH");
	}
	
	public String getPreProdCapabilitiesSearchButton()
	{
		return pro.getProperty("PREPROD_CAPABILITIES_SEARCH_BUTTON_XPATH");
	}
	
	public String getPreProdCapabilitiesEditFileBrokerSettingsLink()
	{
		return pro.getProperty("PREPROD_CAPABILITIES_EDIT_FILEBROKER_SETTINGS_XPATH");
	}
	
	//***********************Sub Menu**********************************
	
	public String getPreProdProfileXpath()
	{
		return pro.getProperty("PREPROD_PROFILES_XPATH");
	}
	
	public String getPreProdCapabilitiesXpath()
	{
		return pro.getProperty("PREPROD_CAPABILITIES_XPATH");
	}
	
	//***********************Edit File Broker Settings**********************************

	public String getPreProdEditFileBrokerSettingsDirectoryXpath()
	{
		return pro.getProperty("PREPROD_EDITFILEBROKERSETTINGS_DIRECTORY_XPATH");
	}
	
	public String getPreProdEditFileBrokerSettingsFileSpecificationXpath()
	{
		return pro.getProperty("PREPROD_EDITFILEBROKERSETTINGS_FILESPECIFICATIONS_XPATH");
	}
	
	//***********************General Functions**********************************

}
