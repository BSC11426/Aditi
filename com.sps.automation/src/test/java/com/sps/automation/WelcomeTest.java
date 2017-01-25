package com.sps.automation;

import java.util.Iterator;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.sps.automation.utilities.ConfigReader;

public class WelcomeTest 
{
	ConfigReader config;
	WebDriver driver;
	String matchingProfileNameXpath;
	String matchingProfileNameTableXpath;
	int counter1=0, counter2=0, count=0, i,j, matchingProfileNameTableStatus=9, matchingProfileNameTableService=10, matchingProfileNameTableCapabilityUID=13;
	String matchingProfileNameTabledoctypeXpath, matchingProfileNameTabledoctypeXpath_CounterValue, matchingProfileNameTableStatusXpath, matchingProfileNameTableServiceXpath;
	String matchingProfileNameTableCapabilityUIDXpath, matchingProfileNameTableCapabilityUIDValue, parentWindowHandleName, fileBrokerDirectoryPath, fileBrokerFileSpecification;
	
	
	
	public void setUp()
	{
		config=new ConfigReader();
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
		driver=new ChromeDriver();
		System.out.println("**********Setup Ready ***********");
	}
	
	
	public void TransactionTrackerlogin()
	{
		System.out.println("********** Test Started ***********");
		driver.get(config.getTransactionTrackerUrl());
		
		driver.findElement(By.xpath(config.getLoginPageUsernamePath())).sendKeys(config.getLoginPageUsernameValue());
		driver.findElement(By.xpath(config.getLoginPagePasswordPath())).sendKeys(config.getLoginPagePasswordValue());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(config.getLoginPageSignInPath())).click();
	}
	
	
	public void transactionTracker()
	{
		driver.findElement(By.xpath(config.getTransactionTrackerPath())).click();
	}
	

	public void preProdLoginUrl()
	{
		System.out.println("********** Test Started ***********");
		driver.get(config.getPreProdUrl());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
		
	public void preProdLogin()
	{
		System.out.println("Logging in DC4 Pre Prod");
		driver.findElement(By.xpath(config.getPreProdLoginPageUsernamePathXpath())).sendKeys(config.getPreProdLoginPageUsernameValue());
		driver.findElement(By.xpath(config.getPreProdLoginPagePasswordPathXpath())).sendKeys(config.getPreProdLoginPagePasswordValue());
		driver.findElement(By.xpath(config.getPreProdLoginPageLoginButtonPathXpath())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("********** Successful Login in DC4 Pre Prod ***********");
	}
	
	public void clickDC4()
	{
		System.out.println("Click on DC4 Link");
		driver.findElement(By.xpath(config.getPreProdHomePageDC4PathXpath())).click();
		System.out.println("Clicked on DC4 Link");
	}
	
	public String DC4EnterCompanyName(String companyName)
	{
		System.out.println("Going to Enter Company Name");
		driver.findElement(By.xpath(config.getPreProdDC4CompanyNameXpath())).sendKeys(companyName);
		System.out.println("Entered Company Name");
		return companyName;
	}
	
	public String addingModulusToCompanyName(String companyName)
	{
		String copy_CompanyName=companyName;
		copy_CompanyName=copy_CompanyName.concat("%");
		return copy_CompanyName;
	}
	
	public void clickDC4BrowseCustomersSearchButton()
	{
		driver.findElement(By.xpath(config.getPreProdDC4BrowseCustomersSearchButtonXpath())).click();
		System.out.println("Clicked on Search Button");
	}
	
	public void DC4BrowseCustomers()
	{
		
		System.out.println("Browsing Customers Name in DC4 Table");
		List<WebElement> companyNameList=driver.findElements(By.xpath(config.getPreProdDC4BrowseCustomersTableXpath()));
		for(WebElement companyNameList_counter: companyNameList)
				{
					if(companyNameList_counter.getText().toUpperCase().contains("IRON CLAD PERFORMANCE WEAR CORP"))
					{
						System.out.println("Entered If Block");
						driver.findElement(By.xpath("html/body/form/span[1]/div[1]/div[3]/span/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr['"+companyNameList_counter+"']/td[1]/a")).click();
						break;
					}
				}
		}
	 
	public void clickProfilesSubmenu()
	 {
		 driver.findElement(By.xpath(config.getPreProdProfileXpath())).click();
	 }
	
	public Integer listOfProfiles()
	{
		System.out.println("Trying to Locate the List of Profiles");
		List<WebElement> profileList=driver.findElements(By.xpath(config.getPreProdProfileListOfProfilesXpath()));
		for(WebElement profileList_Counter: profileList)
		{
			counter1=counter1+1;
			if(profileList_Counter.getText().toLowerCase().contains("amazon warehouse"))
			{
				counter2=counter1;
				break;
			}
		}
		//left to return true
	return counter2;
	}

	public String clickOnCompanyProfile(int indexNumberOfProfile)
	{
		
		System.out.println(indexNumberOfProfile);
		matchingProfileNameXpath=String.format("html/body/form/span[1]/div[1]/div[3]/div[1]/table[2]/tbody/tr[%s]/td[2]/div/a[2]", indexNumberOfProfile);
		driver.findElement(By.xpath(matchingProfileNameXpath)).click();
		return matchingProfileNameXpath;
		//left to return true
	}
	
	public String copyCapabilityUid(String matchingProfileNameXpath, int indexNumberOfProfile)
	{
		if((driver.findElement(By.xpath(matchingProfileNameXpath)).getText()).equalsIgnoreCase("hide"))
		{
			matchingProfileNameTableXpath=String.format("html/body/form/span[1]/div[1]/div[3]/div[1]/table[2]/tbody/tr[%s]/td/div/div/table/tbody/tr[%s]/td/table/tbody/tr", indexNumberOfProfile+1, indexNumberOfProfile);
			List<WebElement> matchingProfileNameTableList=driver.findElements(By.xpath(matchingProfileNameTableXpath));
			count=matchingProfileNameTableList.size();
			System.out.println(count);
			matchingProfileNameTabledoctypeXpath=String.format("html/body/form/span[1]/div[1]/div[3]/div[1]/table[2]/tbody/tr[%s]/td/div/div/table/tbody/tr[%s]/td/table/tbody/tr[1]/th[3]",indexNumberOfProfile+1, indexNumberOfProfile);
			if((driver.findElement(By.xpath(matchingProfileNameTabledoctypeXpath)).getText()).equalsIgnoreCase("DocType"))
			{
				for(i=1, j=2;i<=count-1;i++, j++)
				{
					matchingProfileNameTabledoctypeXpath_CounterValue=String.format("html/body/form/span[1]/div[1]/div[3]/div[1]/table[2]/tbody/tr[%s]/td/div/div/table/tbody/tr[%s]/td/table/tbody/tr[%s]/td[3]", indexNumberOfProfile+1, indexNumberOfProfile, j);
					if((driver.findElement(By.xpath(matchingProfileNameTabledoctypeXpath_CounterValue)).getText()).equalsIgnoreCase("856"))
					{
						matchingProfileNameTableStatusXpath=String.format("html/body/form/span[1]/div[1]/div[3]/div[1]/table[2]/tbody/tr[%s]/td/div/div/table/tbody/tr[%s]/td/table/tbody/tr[%s]/td[%s]", indexNumberOfProfile+1, indexNumberOfProfile, j, matchingProfileNameTableStatus);
						matchingProfileNameTableServiceXpath=String.format("html/body/form/span[1]/div[1]/div[3]/div[1]/table[2]/tbody/tr[%s]/td/div/div/table/tbody/tr[%s]/td/table/tbody/tr[%s]/td[%s]", indexNumberOfProfile+1, indexNumberOfProfile, j, matchingProfileNameTableService);
						
						if(driver.findElement(By.xpath(matchingProfileNameTableStatusXpath)).getText().equalsIgnoreCase("Active"))
						{
							if((driver.findElement(By.xpath(matchingProfileNameTableServiceXpath)).getText().equalsIgnoreCase("FIfromService"))||(driver.findElement(By.xpath(matchingProfileNameTableServiceXpath)).getText().equalsIgnoreCase("FItoService")))
							{
								matchingProfileNameTableCapabilityUIDXpath=String.format("html/body/form/span[1]/div[1]/div[3]/div[1]/table[2]/tbody/tr[%s]/td/div/div/table/tbody/tr[%s]/td/table/tbody/tr[%s]/td[%s]", indexNumberOfProfile+1, indexNumberOfProfile, j, matchingProfileNameTableCapabilityUID);
								matchingProfileNameTableCapabilityUIDValue=driver.findElement(By.xpath(matchingProfileNameTableCapabilityUIDXpath)).getText();
								System.out.println(matchingProfileNameTableCapabilityUIDValue);
								return matchingProfileNameTableCapabilityUIDValue;
							}
						}
						else
						{
							continue;
						}
						
					}
					
				}
				
			}
		}
		return "Not Found Capability UID";
	}
	
	public void clickCapabilitiesSubmenu()

	{
		System.out.println("Going to Click on Capabilities Tab");
		driver.findElement(By.xpath(config.getPreProdCapabilitiesXpath())).click();
		System.out.println("Clicked on Capabilities Submenu");
	}
	
	public void enterCapabilityUIDValue(String matchingProfileNameTableCapabilityUIDValue)
	{
		System.out.println("Trying to enter Capability UID Value");
		driver.findElement(By.xpath(config.getPreProdCapabilitiesCapabilityUIDXpath())).sendKeys(matchingProfileNameTableCapabilityUIDValue);
		System.out.println("Entered Capability UID Value");
	}
	
	public void clickOnCapabilitiesSearchButton()
	{
		System.out.println("Going to Click on Capabilities Page Search Button");
		driver.findElement(By.xpath(config.getPreProdCapabilitiesSearchButton())).click();
		System.out.println("Clicked on the Capabilities Search Button");
	}
	
	public void clickOnEditFileBrokerSettingsLink()
	{
		System.out.println("Trying to click on Edit File Broker Settings Link");
		parentWindowHandleName=driver.getWindowHandle();
		System.out.println(parentWindowHandleName);
		driver.findElement(By.xpath(config.getPreProdCapabilitiesEditFileBrokerSettingsLink())).click();
		System.out.println("Clicked on the Edit File Broker Settings Link");
		try
		{
		Set<String> listOfAllWindows=driver.getWindowHandles();
		Iterator<String> listOfAllWindowsIterator=listOfAllWindows.iterator();
		while(listOfAllWindowsIterator.hasNext())
		{
			String child_Window=listOfAllWindowsIterator.next();
			if(!(parentWindowHandleName.equalsIgnoreCase(child_Window)))
			{
				
				driver.switchTo().window(child_Window);
				System.out.println(driver.getTitle());
				Screen screen = new Screen();
				Pattern editFileBrokerSettings_DirectoryPath = new Pattern("D:\\Bristlecone\\SPS Automation\\Sikuli Images\\directoryPath.PNG");
				Pattern editFileBrokerSettings_FileSpecification = new Pattern("D:\\Bristlecone\\SPS Automation\\Sikuli Images\\fileSpecification.PNG");
				screen.wait(editFileBrokerSettings_DirectoryPath,15).click();
				//String editFileBrokerSettings_DirectoryPath_Text=driver.findElement(By.xpath("html/body/form/div[1]/div[3]/table[2]/tbody/tr/td[1]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).getText();
				//String editFileBrokerSettings_DirectoryPath_Text=screen.find(editFileBrokerSettings_DirectoryPath).text();
				Settings.OcrTextSearch = true;
				Settings.OcrTextRead=true;
				
				String editFileBrokerSettings_DirectoryPath_Text=screen.find(editFileBrokerSettings_DirectoryPath).text();
				System.out.println(editFileBrokerSettings_DirectoryPath_Text);
				//screen.wait(editFileBrokerSettings_FileSpecification,15).click();
				
				driver.close();
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		driver.switchTo().window(parentWindowHandleName);
	}
}
