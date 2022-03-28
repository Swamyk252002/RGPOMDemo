package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.ZRedGreenDetails;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppLock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassZRedGreen 
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
	    ZRedGreenDetails appmanagerwp=new ZRedGreenDetails(driver);
	    appmanagerwp.appmanagerfavdelclick();
     	appmanagerwp.appmanagerclick(); 
     	Thread.sleep(5000);
     	appmanagerwp.speedboosteropen();
     	Thread.sleep(5000);
     	appmanagerwp.closeapp();
	}
   @Test(priority=3)
   public void OpenRedGreenAppAgin() throws Exception
   {
	   driver=RegGreenDesiredCapabilitiesZAppLock.getAndroidDriver();
   }
   @Test(priority=4)
   public void savebatteryLock() throws Exception
   { 	
	    
	    ZRedGreenDetails appmanagerwp=new ZRedGreenDetails(driver);
	    Thread.sleep(5000);
     	appmanagerwp.savebatteryclick();
     	Thread.sleep(5000);
     	appmanagerwp.AppLockPinSetupWithpermissionclick();
     	Thread.sleep(5000);
     	appmanagerwp.AppLockChangePasswordclick();
     	Thread.sleep(5000);
     	appmanagerwp.ForgotPassword();
     	Thread.sleep(5000);
     	appmanagerwp.closeapp();
	}
   @Test(priority=5)
   public void OpenRedGreenAppAgain() throws Exception
   {
	   driver=RegGreenDesiredCapabilitiesZAppLock.getAndroidDriver();
   }
   @Test(priority=6)
   public void setting() throws Exception
   { 	
	    
	    ZRedGreenDetails appmanagerwp=new ZRedGreenDetails(driver);
		Thread.sleep(5000);
     	appmanagerwp.Preferencesclickpass();
    	Thread.sleep(5000);
     	appmanagerwp.closeapp();    
	}
}
