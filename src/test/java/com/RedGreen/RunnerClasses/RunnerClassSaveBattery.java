package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.SaveBattery;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppMngrRUAppsNotExit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassSaveBattery 
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
      	  driver=RegGreenDesiredCapabilitiesAppMngrRUAppsNotExit.getAndroidDriver();
   }
   @Test(priority=2)
   public void removeunsecureapp() throws Exception
   { 	
	   SaveBattery savebatterysystem=new SaveBattery(driver);
	   savebatterysystem.savebatteryclick();
	   savebatterysystem.closeapp();
	}
}
