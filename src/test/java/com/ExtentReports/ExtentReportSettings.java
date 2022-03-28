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

public class ExtentReportSettings {
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest Test;
	AndroidDriver<AndroidElement> driver;

	public void exreportopen() {
		report = new ExtentReports();
		// spark=new ExtentSparkReporter("./reports/result.html");
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/Settings.html");
		report.attachReporter(spark);
		Test = report.createTest("Settings functionality testing");
	}


public void Preferenceslickpass(AndroidDriver<AndroidElement> driver) throws Exception {
	Test.pass(" Preferencec clicked sucessfully");
}

public void Preferencesnotfound(AndroidDriver<AndroidElement> driver) throws Exception 
{
	String temp = getScreenshot(driver);
	Test.fail("Preferences not exist- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}
public void AutomaticallyLockappsoninstalloff(AndroidDriver<AndroidElement> driver) throws Exception {
	Test.pass(" Automatically Lock apps on install off sucessfully");
}

public void AutomaticallyLockappsoninstallnotfound(AndroidDriver<AndroidElement> driver) throws Exception 
{
	String temp = getScreenshot(driver);
	Test.fail("Automatically Lock apps on install- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}

public void AutomaticallyLockappsoninstallnotenable(AndroidDriver<AndroidElement> driver) throws Exception 
{
	String temp = getScreenshot(driver);
	Test.fail("Automatically Lock apps on install should be disable very first time- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}
public void Setapplockpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Set App Lock ok button clicked sucessfully");
}

public void Setapplockpopupnotfound(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Set App Lock Popup Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}

public void Tutorialsoff(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Tutorials toggle button clicked sucessfully");
}

public void Tutorialson(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Tutorials toggle button on clicked sucessfully");
}

public void Tutorialsfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Tutorials Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}


public void Rateusongoogleplaypass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass(" Rate us on google play clicked sucessfully");
}

public void Rateusongoogleplayfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Tutorials Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}

public void Recommenduspass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass(" Recommened us clicked sucessfully");
}

public void Recommendusfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Recommend us Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Messagespass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass(" Messages icon clicked sucessfully");
}

public void Messagesfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Messages icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void NewMessagespass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass(" New Messages clicked sucessfully");
}

public void NewMessagesfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("New Messages  Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Phonenumberclickpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Phone number clicked sucessfully");
}

public void Phonenumberfieldclickedfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Phone number field clicked  Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Sendtonumberpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Send to number clicked sucessfully");
}

public void Sendtonumberfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Send to number Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Sendpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Send clicked sucessfully");
}

public void Sendfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Send icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Gmailselectpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Gmail clicked sucessfully");
}

public void Gmailselectfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Gamil icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Toselectpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("To field clicked sucessfully");
}

public void Toselectfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("To field icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Sendbuttonpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Send button clicked sucessfully");
}

public void Sendbuttonfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Send icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Clipboardpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Clipboard button clicked sucessfully");
}

public void Clipboardbuttonfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Clipboard icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Svetodrivepass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Save to drive button clicked sucessfully");
}

public void Savetodrivebuttonfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Save to drive icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Documenttittlepass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Document tittle button clicked sucessfully");
}

public void Documenttittlebuttonfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Document tittle icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void Savepass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Save button clicked sucessfully");
}

public void Savebuttonfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Save icon Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}


public void Autoapplockfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Auto app lock toggle Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}


public void Togglebuttononpass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Toggle button clicked sucessfully");
}

public void Togglebuttonfailed(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("toggle button Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void TogglebutonisEnablepass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Toggle button is enaabled");
}

public void Togglebuttonenablefailed(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("toggle button enable Not Found- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void pinsetuppass(AndroidDriver<AndroidElement> driver) throws Exception 
{
Test.pass("Applock clicked sucessfully");
}

public void Applockpermissionsfail(AndroidDriver<AndroidElement> driver) throws Exception 
{
String temp = getScreenshot(driver);
Test.fail("Applock permissions fail- Some Internal Error",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
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
Test.pass("Splash Screens Verified Sucessfully");
}

public void allowphotosmediaandphonespermissionsallow(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass("Permissions allowed Sucessfully and Navigates to DashBoard");
}

public void getapplockpasswordclick(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass("GET APPLOCK PASSWORD clicked Successfully");
}

public void getapplockpasswordclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("GET APPLOCK PASSWORD not exists - some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void getapplockpasswordinvalidemailverifypass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass("Invalid email id verified Successfully");
}

public void getapplockpasswordinvalidemailverifyfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("Invalid email id verification failed - some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void getapplockpasswordemailsentpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass("GET APPLOCK PASSWORD functionality working as expected");
}

public void getapplockpasswordmailsentfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("GET APPLOCK PASSWORD not working - some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void touchactions(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass("Scrolled Successfully");
}

public void aboutusclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass("ABOUT US clicked Successfully");
}

public void aboutusclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("ABOUT US not exists - some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void termsofservicesclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass("TERMS OF SERVICE clicked Successfully");
}

public void termsofservicesclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("TERMS OF SERVICE screen loading fail - some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}

public void contactusclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" CONTACT US clicked Successfully");
}

public void contactusclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("CONTACT US not exists - some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

}

public void gmailclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Gmail clicked Successfully");
}

public void gmailclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("Gmail not exists - some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void mailcomposedpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Mail composed Successfully");
}

public void mailcomposefail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("Unable to compose mail- some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void mailsentass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Emailed Successfully");
}

public void mailsentfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("Unable to send Email- some internal error",
		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void securemeclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" SecureME application clicked Successfully");
}

public void securemeclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("SecureME application not exist", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void downloadclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Download button clicked and navigated to playstore Successfully");
}

public void downloadclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail("Download button not exist", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void appopenpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Application opened Successfully");
}

public void appinstallpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Application installed Successfully");
}


public void unfoldprintspass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" UnfoldPrints application clicked Successfully");
}

public void unfoldprintsfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail(" Applications not exist", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}

public void mobileswitchpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" MobileSwitch application clicked Successfully");
}
public void uflapplockpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" 2020AppLock application clicked Successfully");
}
public void uflwalletpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" 2020Wallet application clicked Successfully");
}
public void myfamilypass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" MyFamily application clicked Successfully");
}
public void forgotpasswordspass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" Email address entered, permission verified and navigated to home screen successfully");
}

public void forgotpasswordfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail(" Forgot Password not displayed some internal error", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}
public void applockclickpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" AppLock Clicked Successfully");
}

public void applockclickfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail(" AppLock not exist some internal error", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}
public void applockpermissionspass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" AppLock permissions allowed Successfully");
}

public void applockpermissionsfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail(" AppLock permissions failed exist some internal error", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}
public void pinsetupspass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" AppLock PIN Setup done Successfully");
}

public void pinsetupfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail(" AppLock PIN Setup fail some internal error", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}
public void getapplockpass(AndroidDriver<AndroidElement> driver) throws Exception {
Test.pass(" GET APP LOCK PASSWORD FUNCTIONALITY working as expected");
}

public void getapplockfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail(" GET APP LOCK PASSWORD not working- some internal error", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}
public void exitappfail(AndroidDriver<AndroidElement> driver) throws Exception {
String temp = getScreenshot(driver);
Test.fail(" Unable to exit from the application- some internal error", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}



}
