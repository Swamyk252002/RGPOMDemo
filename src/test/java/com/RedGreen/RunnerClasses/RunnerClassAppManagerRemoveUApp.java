package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.AppManagerRUApp;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppMngrRUApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppManagerRemoveUApp 
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
      	  driver=RegGreenDesiredCapabilitiesAppMngrRUApp.getAndroidDriver();
   }
   @Test(priority=2)
   public void removeunsecureapp() throws Exception
   { 	
	    AppManagerRUApp appmanagerwp=new AppManagerRUApp(driver);
     	appmanagerwp.appmanagerclick(); 
	   	appmanagerwp.closeapp();    
	}
}
