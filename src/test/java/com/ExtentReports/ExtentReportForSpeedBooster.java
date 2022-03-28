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

public class ExtentReportForSpeedBooster
{
	ExtentReports report; 
	ExtentSparkReporter spark;
	ExtentTest Test;
	AndroidDriver<AndroidElement> driver;
	
    public void exreportopen()
    {
	     report= new ExtentReports();
		 //spark=new ExtentSparkReporter("./reports/result.html");
		 spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/SpeedBooster.html");
		 report.attachReporter(spark);
		 Test=report.createTest("SpeedBooster functionality testing");
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
    
    public void speedboosterclick(AndroidDriver<AndroidElement> driver) throws Exception
   	{
       		
       		String temp=getScreenshot(driver);
			Test.fail("Speed Booster not Exist- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
  
  
    public void speedboosteropen(AndroidDriver<AndroidElement> driver) throws Exception
   	{
       		Test.pass("Speed Booster Opened Successfully");

   	}
    public void speedboosternotfound(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	String temp=getScreenshot(driver);
		Test.fail("Speed Booster not Exist- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

   	}  
    public void disableautosync(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Auto Sync Disabled successfully");
   	}
    public void disableautosyncpermissionno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Disable auto sync pop up -No Button clicked sucessfully");
   	}
    public void enableautosyncdisplayed(AndroidDriver<AndroidElement> driver) throws Exception
   	{
     	Test.pass("Auto sync Enabled sucessfully");
   	}
    public void enableautosyncnotfound(AndroidDriver<AndroidElement> driver) throws Exception
	{
    	String temp=getScreenshot(driver);
    	Test.fail("Enable autosync Option not found",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}

    public void enableautosysucessful(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("enable auto sync");
   	}
    public void enableautosyncpermissionno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("enable auto sync pop up no select");
   	}
    public void disableautosyncfail(AndroidDriver<AndroidElement> driver) throws Exception
    
   	{
    	String temp=getScreenshot(driver);
    	Test.fail("Disable autosync not found ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
   
    public void disablewifi(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Wifi Disabled successfully");
   	}
    public void disablewifipermissionno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Disable Wifi pop up -No Button clicked sucessfully");
   	}
    public void disablewifinotclicked(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Disable Wifi Option not found");
   	}  
    public void disablewififail(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	String temp=getScreenshot(driver);
    	Test.fail("Disable WIFI functionality not working-Some Internal Error ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
    public void disablelocation(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Location Disabled successfully");
   	}
    public void disablelocationpermissionno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Disable Location pop up -No Button clicked sucessfully");
   	}
    
    public void disablelocationfail(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	String temp=getScreenshot(driver);
    	Test.fail("Disable Location functionality failed -Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
    public void updatedevice(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Update device option verified successfully");
   	}
    public void updatedevicepermissionno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Update Device pop up -No Button clicked sucessfully");
   	}
    public void updatedevicenotfound(AndroidDriver<AndroidElement> driver) throws Exception
	{
	Test.pass("Update Device Option not found");
	}
    public void updatedevicefail(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	String temp=getScreenshot(driver);
    	Test.fail("Update Device functionality failed -Some Internal Error ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
    public void touchactions(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("App Scroll down successful");
   	}
    public void notficationsblock(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Notifications blocked options verified successfully");
   	}
    public void notficationsblockno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Notifications block pop up -No Button clicked sucessfully");
   	}
    public void notificationblockfail(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	String temp=getScreenshot(driver);
    	Test.fail("Notification block functionality failed -Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
    
    public void cleanhomeapps(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Clean-Home App Option verified successfull");
   	}
    public void cleanhomeappsno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Clean-Home app pop up -No Button clicked sucessfully");
   	}
    public void cleanuphomeappfail(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	String temp=getScreenshot(driver);
    	Test.fail("Cleanup home app functionality failed -Some Internal Error ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
    
    
    public void restricthotspot(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Hotspot option verified sucessfully ");
   	}
    public void restricthotspotno(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	Test.pass("Hotspot pop up -No Button clicked sucessfully");
   	}
    public void hotspotrestirctfail(AndroidDriver<AndroidElement> driver) throws Exception
   	{
    	String temp=getScreenshot(driver);
    	Test.fail("Restricting hotspot functionality failed -Some Internal Error ",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
   	}
}
