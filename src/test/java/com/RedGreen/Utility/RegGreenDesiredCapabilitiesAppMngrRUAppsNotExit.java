package com.RedGreen.Utility;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RegGreenDesiredCapabilitiesAppMngrRUAppsNotExit  
{
	@BeforeTest
	public static AndroidDriver<AndroidElement> getAndroidDriver() throws Exception{
		AndroidDriver<AndroidElement> driver = null;
		try{
			/* Appium Server start
			 * Give the Device details
			 */
			
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		    URL u = new URL("http://0.0.0.0:4723/wd/hub");
	  		DesiredCapabilities dc = new DesiredCapabilities();
	        dc.setCapability(CapabilityType.BROWSER_NAME,""); 
	        dc.setCapability("deviceName","emulator-5554");
	        dc.setCapability("platformName", "Android");
	        dc.setCapability("platformVersion", "8.1.0");
	        dc.setCapability("appPackage","com.unfoldlabs.redgreen");
	        dc.setCapability("appActivity", "com.unfoldlabs.redgreen.activity.Splash");        
	        while(2>1){
		      try{
			       driver=new AndroidDriver<AndroidElement>(u,dc);
			       break;
		      }
		      catch(Exception ex){
		    	  System.out.println(ex);
		      } 
     	    }   
	        
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return driver;
	}

}
