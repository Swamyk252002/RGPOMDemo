package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.Z1_RedGreenDetails_AppManager;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassZ1_RedGreen_AppManager 
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
      	  driver=RegGreenDesiredCapabilitiesZAppDetails.getAndroidDriver();
   }
   @Test(priority=2)
   public void removeunsecureapp() throws Exception
   { 	
	    Z1_RedGreenDetails_AppManager appmanagerwp=new Z1_RedGreenDetails_AppManager(driver);
	    appmanagerwp.appmanagerfavdelclick();
     	appmanagerwp.appmanagerclick(); 
     	Thread.sleep(5000);
     	appmanagerwp.closeapp();
	}
   }
