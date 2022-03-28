package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.RedGreensettingscode;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesSpeedBooster;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails1;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesZAppDetails2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ZRunnerClassSettings {
	
	AndroidDriver<AndroidElement> driver;
	@Test(priority=1)
	
	public void Runner() throws Exception 
	{
		driver = RegGreenDesiredCapabilitiesZAppDetails2.getAndroidDriver();
	}
	
	
	@Test(priority=2)
	public void Preferences() throws Exception
	{
		RedGreensettingscode st= new RedGreensettingscode(driver);
		Thread.sleep(10000);
		st.Preferencesclickpass();
		st.GetAppLockPasswordclick();
		st.aboutusclick();
		st.closeapp();

	}

}
