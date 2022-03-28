package com.RegGreen.InstallApp;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppInstall 
{
	

	public static void main(String[] args) throws Exception 
	{
		 
		     
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		
		URL u = new URL("http://0.0.0.0:4723/wd/hub");
		
		
		  		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("app", "D:\\batch249\\apps\\VodQA.apk");
		AndroidDriver<AndroidElement> driver =  new AndroidDriver<AndroidElement>(u,dc);
		
		
		
		driver.closeApp();	
		Thread.sleep(10000);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		


	}


}
