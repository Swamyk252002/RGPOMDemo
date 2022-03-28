package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.AppLockChangePassword;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppLockChangePassword {
	AndroidDriver<AndroidElement> driver;

	/*RedGreen app testing start
	 * Open App
	 * Validating Splash Screens
	 * Clicking on App Lock Module and Verify the Change password functionality
	  */
	
	@Test(priority=1)
	public void OpenRedGreenApp() throws Exception 
		{
		driver=RegGreenDesiredCapabilitiesAppLock.getAndroidDriver();
		}
		
		@Test(priority=2)
	
	public void AppLockChangePasswordclick1() throws Exception
	{
		AppLockChangePassword alchangepassword=new AppLockChangePassword(driver);
			
		alchangepassword.AppLockChangePasswordclick();
		alchangepassword.closeApp();
			          
		}
}
		




