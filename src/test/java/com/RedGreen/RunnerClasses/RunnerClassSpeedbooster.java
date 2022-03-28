package com.RedGreen.RunnerClasses;

import org.testng.annotations.Test;

import com.RedGreen.AppManager.SpeedBooster;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesSpeedBooster;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunnerClassSpeedbooster
{
	
	AndroidDriver<AndroidElement> driver;
		@Test(priority=1)
		
		public void Runner() throws Exception 
		{
			driver = RegGreenDesiredCapabilitiesSpeedBooster.getAndroidDriver();
		}
	
		@Test(priority=2)
		public void Speedbooster() throws Exception
		{
			SpeedBooster st = new SpeedBooster(driver);
			Thread.sleep(20000);
			st.speedboosteropen();
			st.closeapp();

		}

	}
