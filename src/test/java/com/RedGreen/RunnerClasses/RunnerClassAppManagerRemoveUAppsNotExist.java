package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.AppManagerRUAppsNotExist;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppMngrRUAppsNotExit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppManagerRemoveUAppsNotExist
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
    public void NoUnsecuredAppsVerified() throws Exception
     {  
    	AppManagerRUAppsNotExist unsecureappnotexist=new AppManagerRUAppsNotExist(driver);
    	unsecureappnotexist.Removeunsecureappsclick();
    	unsecureappnotexist.closeapp();       
     }
  

}
