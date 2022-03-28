package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.ZRedGreenDetails;
import com.RedGreen.AppManager.ZRedGreen_AppManager_And_SpeedBooster;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppLock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ZRunnerClassRedGreen_AppManager_And_SpeedBooster 
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
	    ZRedGreen_AppManager_And_SpeedBooster appmanagerwp=new ZRedGreen_AppManager_And_SpeedBooster(driver);
	    appmanagerwp.appmanagerfavdelclick();
     	appmanagerwp.removeunsecureappsclick();
     	appmanagerwp.speedboosteropen();
     	appmanagerwp.closeapp();
	}
   
}
