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

public class ExtentReportforAppManagerFavAndDel
{
		ExtentReports report;
		ExtentSparkReporter spark;
		ExtentTest Test;
		AndroidDriver<AndroidElement> driver;
	    public void exreportopen()
	    {
		     report= new ExtentReports();
			 spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/UnsecureAppsFevAndDel.html");
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
	    public void appmanagerpass(AndroidDriver<AndroidElement> driver) throws Exception
		{
	    		Test.pass("Clicked on App Manager option and Successfully Navigates to App Manager Home Screen");
		}
	    public void appmanagerfail(AndroidDriver<AndroidElement> driver) throws Exception
		{
	        	String temp=getScreenshot(driver);
				Test.fail("App Manager Module not exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	    public void headingsoflistappspass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Heading displaying");	
		}
		public void headingsoflistappsfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("App Manager Home page not exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	    public void listofusedorunusedappspass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
	    	    String temp=getScreenshot(driver);
	    	    Test.pass("List Of Apps Recently Used or Not Used displaying as expected",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());	
		}
		public void listofusedorunusedappsfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("List Of Used or Unused apps are not displaying - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void favoritesapppass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Successfully selected App moved to Favorites");	
		}
		public void favoritesappfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Selected App not moved to Favorites - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void changefavoritesapppass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Successfully selected App moved to Un Favorites");	
		}
		public void changefavoritesappfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Selected App not moved to Un Favorites - an internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void deleteappcancelpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Uninstall App Cancel Button on popup working as expected");	
		}
		public void deleteappcancelfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Uninstall App Cancel Button on popup not working - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void deleteappokpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Sucessfully Deleted selected App ");	
		}
		public void deleteappokfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Selected App not deleted - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void settingbuttonpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Setting Clicking button working as expected and sucessfully navigated to Setting page");	
		}
		public void settingbuttonpassfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Setting Clicking button not exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void automaticallyuninstallpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Automatically Uninstall Apps Popup displaying as expected");	
		}
		public void automaticallyuninstallfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Automatically Uninstall Apps Popup not displaying - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void checkboxenableanddisablepass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Toggle button enable and disable Working as expected");	
		}
		public void checkboxenableanddisablefail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Toggle button enable and disable not working - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void optionspass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Options- 1 Week,15 Days and 1 Month displaying as expected");	
		}
		public void optionsfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Options- 1 Week,15 Days and 1 Month not displaying - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void doneoptionspass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Clicked on Done Button and Successfully Navigates to App Manager Home Screen");	
		}
		public void doneoptionsfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Done Button not Working - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void optionseletionverifivationpass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
				Test.pass("Options- 1 Week,15 Days and 1 Month Working as expected");	
		}
		public void optionseletionverifivationfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			    String temp=getScreenshot(driver);
				Test.fail("Options- 1 Week,15 Days and 1 Month not Working - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		public void noappspass(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			   String temp=getScreenshot(driver);
			   Test.pass("Great you don't have Unsecure Apps - Unsecure apps not exist",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}		
		public void noappsfail(AndroidDriver<AndroidElement> driver) throws Exception 
		{
			   String temp=getScreenshot(driver);
			   Test.pass("Internal error- message not displaying",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
}

