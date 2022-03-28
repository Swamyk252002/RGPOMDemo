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

public class ExtentReportforAppNotExist
{
		ExtentReports report;
		ExtentSparkReporter spark;
		ExtentTest Test;
		AndroidDriver<AndroidElement> driver;
	    public void exreportopen()
	    {
		     report= new ExtentReports();
			 spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/UnsecureAppsNotExist.html");
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
	    public void redgreenappopen(AndroidDriver<AndroidElement>  driver) throws Exception
		{
	    		Test.pass("RedGreen App Opened Sucessfully");
		}
	    public void splashscreenverification(AndroidDriver<AndroidElement>  driver) throws Exception
		{
	    		Test.pass("Splash Screen Verified Sucessfully");
		}
	    public void appmanagerpass(AndroidDriver<AndroidElement>  driver) throws Exception
		{
	    		Test.pass("Clicked on App Manager option and Successfully Navigates to App Manager Home Screen");
		}
	    public void appmanagerfail(AndroidDriver<AndroidElement>  driver) throws Exception
		{
	        	String temp=getScreenshot(driver);
				Test.fail("App Manager option not exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	    public void removeunsecurepass(AndroidDriver<AndroidElement>  driver) throws Exception 
		{
				Test.pass("Remove Unsecure App working as expected -Navigates to Remove UnSecure App Home Screen");	
		}
		public void removeunsecurefail(AndroidDriver<AndroidElement>  driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Remove Unsecure option Not Exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void noappspass(AndroidDriver<AndroidElement>  driver) throws Exception 
		{
			   String temp=getScreenshot(driver);
			   Test.pass("Sucessful message displaying : Great you don't have Unsecure Apps",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void noappsfail(AndroidDriver<AndroidElement>  driver) throws Exception 
		{
			   String temp=getScreenshot(driver);
			   Test.pass("Internal error- Great you don't have Unsecure Apps: message not displaying",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
}

