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

public class ExtentReportforRemoveUnsecureApps
{
	ExtentReports report; 
	ExtentSparkReporter spark;
	ExtentTest Test;
	AndroidDriver<AndroidElement> driver;
    public void exreportopen()
    {
	     report= new ExtentReports();
		 spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/UnsecureAppsRemoved.html");
		 report.attachReporter(spark);
		 Test=report.createTest("RedGreen Unsecure apps removing functionality testing");
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
			Test.fail("App Manager option not exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
    public void removeunsecurepass(AndroidDriver<AndroidElement> driver) throws Exception 
	{
			Test.pass("Remove Unsecure App working as expected -Navigates to Remove UnSecure App Home Screen");	
	}
	public void removeunsecurefail(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		    String temp=getScreenshot(driver);
			Test.fail("Remove Unsecure option Not Exist - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void unsecureappsdetails(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		    String temp=getScreenshot(driver);
			Test.pass("Unsecure Apps Exists in App Manager",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void allunsecureappsremoved(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		    String temp=getScreenshot(driver);
			Test.pass("All Unsecure Apps are removed sucessfully -Great you don't have Unsecure Apps",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void allunsecureappsremovedfailed(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		    String temp=getScreenshot(driver);
			Test.fail("All Unsecure Apps are not removed - some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void allunsecureappsnotinstalled(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		    String temp=getScreenshot(driver);
			Test.fail("Unsecure apps are not displaying- some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void noappspass(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		   String temp=getScreenshot(driver);
		   Test.pass("Great you don't have Unsecure Apps",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void noappsfail(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		   String temp=getScreenshot(driver);
		   Test.fail("Internal error- Great you don't have Unsecure Apps - message not displaying",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void cancelbuttonpass(AndroidDriver<AndroidElement> driver) throws Exception 
	{
			Test.pass("Cancel Button Working Good");	
	}
	public void cancelbuttonnotdisplaying(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		    String temp=getScreenshot(driver);
			Test.fail("Cancel Button not exist",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());	
	}
	public void cancelbuttonfail(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		   String temp=getScreenshot(driver);
		   Test.fail("Cancel button functionality not working displaying- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void okbuttonpass(AndroidDriver<AndroidElement> driver) throws Exception 
	{
			Test.pass("OK Button Working Good");	
	}
	public void okbuttonnotdisplaying(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		    String temp=getScreenshot(driver);
			Test.fail("OK Button not exist- App not deleted",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());	
	}
	public void okbuttonfail(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		   String temp=getScreenshot(driver);
		   Test.fail("OK button functionality not working displaying- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void toastmessagepass(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		   Test.pass("Toaster message displaying sucessfully -message Uninstalled AppLock ");
	}
	public void toastmessagefail(AndroidDriver<AndroidElement> driver) throws Exception 
	{
		   String temp=getScreenshot(driver);
		   Test.fail("Toaster message not displaying -some internal error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	
}
