package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.AppLockForgotPassword;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLock;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassAppLockForgotPassword {
	AndroidDriver<AndroidElement> driver;

/*RedGreen app testing start
 * Open App
 * Validating Splash Screens
 * Clicking on App Lock Module and Verify the forgot password functionality
  */
	
	@Test(priority=1)
	public void OpenRedGreenApp() throws Exception 
	{
		driver=RegGreenDesiredCapabilitiesAppLock.getAndroidDriver();
	}	
	@Test(priority=2)
	public void AppLockwithoutpermissionsForgotPassword() throws Exception
	{
		AppLockForgotPassword alforgotpassword= new AppLockForgotPassword(driver);
		alforgotpassword.ForgotPassword();
		alforgotpassword.closeApp();
	}
}
		


