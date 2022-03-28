package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.ZRedGreenDetails;
import com.RedGreen.AppManager.ZRedGreenDetails_SaveBattery_And_AppLock;
import com.RedGreen.AppManager.ZRedGreen_AppManager_And_SpeedBooster;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails1;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppLock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ZRunnerClassRedGreen_SaveBattery_And_AppLock 
{
	/*RedGreen app testing start
	 * Open App
	 * Validating Splash Screens
	 * Clicking on AppManager Module and Verify the Remove Unsecure app
	 * Verify the There is no unsecure apps
	 */
	
	
	
	AndroidDriver<AndroidElement> driver;
   @Test(priority=1)
   public void OpenRedGreenApp() throws Exception
   {
      	  driver=RegGreenDesiredCapabilitiesZAppDetails1.getAndroidDriver();
   }
   @Test(priority=2)
   public void removeunsecureapp() throws Exception
   { 	
	    ZRedGreenDetails_SaveBattery_And_AppLock appmanagerwp=new ZRedGreenDetails_SaveBattery_And_AppLock(driver);
	    appmanagerwp.savebatteryclick();
     	appmanagerwp.AppLockPinSetupWithpermissionclick();
     	appmanagerwp.AppLockChangePasswordclick();
     	appmanagerwp.ForgotPassword();
     	appmanagerwp.closeapp();
	}
   
}
