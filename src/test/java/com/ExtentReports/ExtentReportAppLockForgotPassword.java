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

public class ExtentReportAppLockForgotPassword {
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest Test;
	AndroidDriver<AndroidElement> driver;

	public void exreportopen() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/AppLockForGotPassWord.html");
		report.attachReporter(spark);
		Test = report.createTest("RedGreen AppLock Forgot Password Functionality Testing");
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
		Test.fail("AppLock not exist - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	public void applockpinsetuppass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("Applock PIN Setup Done Successfully ");
	}

	public void applockpinsetupfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("Applock PIN Setup not done -some internal error ",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void applockforgotpasstoastmessagepass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("Forgot Password toast message verified Successfully ");
						
	}
	public void applockforgotpasswordtoastmessagefail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("Forgot Password toast message not verified  -some internal error ",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	public void applockforgotpasswordemail(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Forgot Password Email Message Displaying as expected : Password Will Be Mailed to Your Working mail id...");
	}

	public void applockforgotpasswordsucessfullshared(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Forgot Password Email Sucessful message Displaying as expected : Your password has been sent to...");
	}
	public void applockforgotpassworcancel(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Forgot Password Cancel button Functionality Working as expected ");
	}
	public void applockforgotpasswordpass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Forgot Password Functionality Working as expected ");
	}
	
	public void applockforgotpasswordfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock Forgot password not working as expected - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	public void applockforgotpasstextverifypass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Forgot Password Text Message Displaying as expected ");
	}

	public void applockforgotpasswordtextverifyfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock Forgot password not working as expected - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	public void applockforgotpasswordinvalidpinverifypass(AndroidDriver<AndroidElement> driver) throws Exception {
		Test.pass("AppLock Forgot Password Invalid PIN verified Successfully ");
	}

	public void applockchangepasswordinvalidpinverifyfail(AndroidDriver<AndroidElement> driver) throws Exception {
		String temp = getScreenshot(driver);
		Test.fail("AppLock Forgot password invalid pin verification failed - some internal error",
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}

	

}
