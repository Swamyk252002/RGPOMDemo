package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLockTestingAp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppLockTesting {
	AndroidDriver<AndroidElement> driver;

	/*RedGreen app testing start
	 * Open App
	 * Validating Splash Screens
	 * Clicking on App Lock Module and Verify the Change password functionality
	  */
	
	@Test(priority=1)
	public void OpenRedGreenApp() throws Exception 
		{
		driver=RegGreenDesiredCapabilitiesAppLockTestingAp.getAndroidDriver();
		}
		
}
		




