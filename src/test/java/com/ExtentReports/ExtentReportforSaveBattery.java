package com.ExtentReports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ExtentReportforSaveBattery
{
		ExtentReports report;
		ExtentSparkReporter spark;
		ExtentTest Test;
		AndroidDriver<AndroidElement> driver;
	    public void exreportopen()
	    {
		     report= new ExtentReports();
			 spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/SaveBattery.html");
			 report.attachReporter(spark);
			 Test=report.createTest("RedGreen Unsecure apps not Exist functionality testing");
	    }
	    public void exreportclose()
	    {
	    	report.flush();
	    }
	    public static String getScreenshot(AndroidDriver<AndroidElement> driver) throws Exception
		{
	    	   TakesScreenshot ts=(TakesScreenshot)driver;
			   File src=ts.getScreenshotAs(OutputType.FILE);	  
			   String path=System.getProperty("user.dir") + "/Screenshots/"+System.currentTimeMillis()+".png";
			   File finalDest=new File(path); 
			   FileUtils.copyFile(src, finalDest);
			   return path;	
	    }
	    public void redgreenappopen(AndroidDriver<AndroidElement> driver) throws Exception
		{
	    		Test.pass("RedGreen App Opened Sucessfully");
		}
	    public void splashscreenverification(AndroidDriver<AndroidElement> driver) throws Exception
		{
	    		Test.pass("Splash Screen Verified Sucessfully");
		}
	    public void savebatterypass(AndroidDriver<AndroidElement> driver) throws Exception
		{
	    		Test.pass("Clicked on Save Battery option and Successfully Navigates to Save Battery Home Screen");
		}
	    public void savebatteryfail(AndroidDriver<AndroidElement> driver) throws Exception
		{
	        	String temp=getScreenshot(driver);
				Test.fail("Save Battery option not exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	    public void remainingbatterypass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Battery Remaining percentage displaying");	
		}
		public void remainingbatteryfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Battery Remaining percentage not displaying - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	    public void systemappsspass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("System Apps option displaying");	
		}
		public void systemappssfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("System Apps option not displaying- some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void cpucoolerpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("CPU Cooler option displaying");	
		}
		public void cpucoolerfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("CPU Cooler option not displaying- some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void systemappinfopass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("System App Info Displaying : Reset to default state to improve battery");	
		}
		public void systemappinfofail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("System App Info Not Displaying  - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void cpucoolerinfopass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("CPU Cooler Info Displaying : All Apps");	
		}
		public void cpucoolerinfofail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("CPU Cooler Info Not Displaying  - an internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void cpucoolerokpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			String temp=getScreenshot(driver);
			Test.pass("CPU Cooler Working as expected",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());	
		}
		public void cpucoolerokfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("CPU Cooler option not working  - an internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void cpucoolercancelpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("CPU Cooler Cancel Button on popup working fine");	
		}
		public void cpucoolercancelfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("CPU Cooler Cancel Button on popup Not Working - an internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void alloptimizationinfopass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			String temp=getScreenshot(driver);
			Test.pass("Optimization completed sucessfully",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());		
		}
		public void alloptimizationinfofail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Optimization unsucessful - an internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void cpucoolbattery(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.pass("Complete Battery Information:",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		public void cpucoolerbaterysever(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Battery Saver working as expected");	
		}
		public void cpucoolerbaterypercentage(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Battery Percentage working as expected");	
		}
		public void cpucoolermobilesleep(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Sleep Time working as expected");	
		}
		public void cpucoolerappandcpu(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Apps battery and Device battery usage displaying as expected");	
		}

}

