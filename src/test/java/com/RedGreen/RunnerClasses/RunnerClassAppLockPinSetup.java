package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.AppLockPinSetup;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLock;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLock2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppLockPinSetup {
	AndroidDriver<AndroidElement>  driver;
/*RedGreen app testing start
 * Open App
 * Validating Splash Screens
 * Clicking on App Lock Module and Verifying the pinsetup functionality
  */
	
	@Test(priority=1)
	public void OpenRedGreenApp() throws Exception 
		{
		
		//RedGreen App calling using(AppDetails)
		driver=RegGreenDesiredCapabilitiesAppLock2.getAndroidDriver();
		}
		
			
	@Test(priority=2)
	
	public void AppLockpinsetupwithpermissionclick() throws Exception
	{
		
		AppLockPinSetup applockpinsetup= new AppLockPinSetup(driver);
		applockpinsetup.AppLockPinSetupWithpermissionclick();
		applockpinsetup.closeApp();
			          
		}
}
		



