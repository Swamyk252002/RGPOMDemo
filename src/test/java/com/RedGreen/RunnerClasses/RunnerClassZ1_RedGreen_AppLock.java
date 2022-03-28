package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.ZRedGreenDetails;
import com.RedGreen.AppManager.RedGreenDetails_AppLock;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppLock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassZ1_RedGreen_AppLock 
{
	/*RedGreen app testing start
	 * Open App
	 * Validating Splash Screens
	 * Clicking on AppManager Module and Verify the Remove Unsecure app
	 * Verify the There is no unsecure apps
	 */
	
	
	
	AndroidDriver<AndroidElement> driver;
   @Test(priority=1)
   public void OpenRedGreenAppAgin() throws Exception
   {
	   driver=RegGreenDesiredCapabilitiesZAppLock.getAndroidDriver();
   }
   @Test(priority=2)
   public void savebatteryLock() throws Exception
   { 	
	    
	   RedGreenDetails_AppLock appmanagerwp=new RedGreenDetails_AppLock(driver);
	    appmanagerwp.AppLockPinSetupWithpermissionclick();
     	
     	appmanagerwp.AppLockChangePasswordclick();
     	appmanagerwp.ForgotPassword();
     	appmanagerwp.closeapp();
	}}
