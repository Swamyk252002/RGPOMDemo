package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.AppManagerAppsUsedorNotUsed;
import com.RedGreen.AppManager.AppManagerAppsUsedorNotUsed2;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppMngrFavAndDel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppManagerUsedandnotUsedapps2 
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
	   driver=RegGreenDesiredCapabilitiesAppMngrFavAndDel.getAndroidDriver();
   }
   @Test(priority=2)
   public void removeunsecureapp() throws Exception
   { 	
	   AppManagerAppsUsedorNotUsed2 appmanagerun=new AppManagerAppsUsedorNotUsed2(driver);
	   appmanagerun.appmanagerclick(); 
	   appmanagerun.closeapp();    
	}
}
