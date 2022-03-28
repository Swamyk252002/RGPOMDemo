package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.AppManagerRUApps;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppMngrRUApps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppManagerRemoveUApps 
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
      	  driver=RegGreenDesiredCapabilitiesAppMngrRUApps.getAndroidDriver();
   }
   @Test(priority=2)
   public void appmanagerverifyingunsecureappavailableornot() throws Exception
   {    
      	 AppManagerRUApps appmanager=new AppManagerRUApps(driver);
    	 appmanager.appmanagerclick();
         appmanager.closeapp();       
   }
}
