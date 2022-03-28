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

public class ExtentReportAppLockPinSetup {
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest Test;
	AndroidDriver<AndroidElement> driver;

	public void exreportopen() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/AppLockPinSetUp.html");
		report.attachReporter(spark);
		Test = report.createTest("RedGreen AppLock PIN Setup Functionality Testing");
	}

	public void exreportclose() {
		report.flush();
	}

	public static String getScreenshot(AndroidDriver<AndroidElement> driver) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
		File finalDest = new File(path);
		FileUtils.copyFile(src, finalDest);
		return path;
	}

	public void redgreenappopen(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("RedGreen App Opened Sucessfully");
	}

	public void splashscreenverification(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("Splash Screen Verified Sucessfully");
	}

	public void allowphotosmediaandphonespermissionsallow(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("Permissions allowed Sucessfully and Navigates to DashBoard");
	}

	public void applockclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("Clicked on AppLock Module and Successfully Navigates to AppLock Home Screen");
	}

	public void applockclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	public void applockwithpermissionspass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Permissions allowed Successfully");
	}

	public void applockwithpermissionsfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock Permissions Verification failed - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	public void applockpinverifyuppass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock PIN Setup Done Successfully");
	}

	public void applockpinverifyfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock PIN Setup not done - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

	}

	public void applockpinvalidemailverifyppass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Invalid Email Id Verified Successfully");
	}

	public void applockpinvalidemailverifyfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock Invalid Email Id verification failed - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	public void applockinvalidpinpass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Invalid PIN Verified Successfully");
	}

	public void applockinvalidpinfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock Invalid PIN verification failed",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	public void applockpinsetupfunctionalityppass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock PIN Setup functionality working as expected");
	}

	public void applockpinsetupfunctionalityfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock PIN Setup functionality failed - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

}
