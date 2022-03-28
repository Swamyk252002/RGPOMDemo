package com.RedGreen.AppManager;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ExtentReports.ExtentReportAppLockChangePassword;
import com.ExtentReports.ExtentReportAppLockForgotPassword;
import com.ExtentReports.ExtentReportAppLockPinSetup;
import com.ExtentReports.ExtentReportForSpeedBooster;
import com.ExtentReports.ExtentReportSettings;
import com.ExtentReports.ExtentReportforAppManagerFavAndDel;
import com.ExtentReports.ExtentReportforRemoveUnsecureApps;
import com.ExtentReports.ExtentReportforSaveBattery;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ZRedGreenDetails_SaveBattery_And_AppLock 
{
	 AndroidDriver<AndroidElement> driver;
	    
	    public ZRedGreenDetails_SaveBattery_And_AppLock(AndroidDriver<AndroidElement> driver)
	    {
	    	 this.driver=driver;
	    	 PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	    }
		
	    /* Open RedGreen App
	     * Splash screen validating and click got it button and moving to allows RedGreen access photos, media and files on your device
         * Allows RedGreen access photos, media 
         * Allows RedGreen access phone Calls 
	     * AppManager - navigate to AppManager DashBoard,OK button of Accept Permission - navigate to Apps with Usage Access
	     * OK button of Accept Permission - navigate to Apps with Usage Access,Permit usage access - in Usage Access - navigate to Display over other apps
	     * Remove Unsecure Apps- using this commened we can remove the unsecure apps in your mobile,Delete to select the App
	     * Delete to select the App,Back to App Dashboard,Cancel, to cancel selection  the App,Toaster message Validation - Back to App Dashboard
	     * Verify Unsecure apps existing or not
	     */
	    
	    
	    /* RedGreenApps Locators*/
	    
	    @AndroidFindBy(xpath="//*[@text='App Manager']")
	    private AndroidElement appmanager;
	    @AndroidFindBy(xpath="//*[@text='OK']")
	    private AndroidElement acceptpermissionok;  
	    @AndroidFindBy(xpath="//*[@text='RedGreen']")
	    private AndroidElement redgreenoption; 
	    @AndroidFindBy(xpath="//*[@text='OFF']")
	    private AndroidElement permitusageaccess;  
	    @AndroidFindBy(xpath="//*[@text='Remove Unsecure Apps']")
	    private AndroidElement removeunsecureapps; 
	    @AndroidFindBy(xpath="//*[@text='ES File Manager | File Explorer' ]/following-sibling::android.widget.ImageView")
	    private AndroidElement esappselect;
	    @AndroidFindBy(xpath="//*[@text='AppLock' ]/following-sibling::android.widget.ImageView")
	    private AndroidElement applockselect;
	    @AndroidFindBy(xpath="//*[contains(@text,'DU')]/following-sibling::android.widget.ImageView")
	    private AndroidElement duspeedappselect;
	    @AndroidFindBy(xpath="//*[contains(@text,'Great')]")
	    private AndroidElement noapps;
	    @AndroidFindBy(xpath="//*[@class='android.widget.ImageButton']")
	    private AndroidElement backtoappmanagerdashboard;
	    @AndroidFindBy(xpath="/hierarchy/android.widget.Toast")
	    private AndroidElement toaster;
	    @AndroidFindBy(className="android.widget.TextView")
	    private AndroidElement listof;
	    @AndroidFindBy(xpath="//*[@resource-id='com.unfoldlabs.redgreen:id/fraudapps_delete']")
	    private AndroidElement unsecureappexistornot;
	    @AndroidFindBy(xpath="//*[@text='OK']")
	    private AndroidElement unsecureappdelete; 
	    @AndroidFindBy(xpath="//*[@text='CANCEL']")
	    private AndroidElement unsecureappcanceltodelete;
	    @AndroidFindBy(xpath="//*[@text='GOT IT']")
	    private AndroidElement gotit;
	    @AndroidFindBy(xpath="//*[@text='ALLOW']")
	    private AndroidElement allowphotosandmedia;
	    @AndroidFindBy(xpath="//*[@text='ALLOW']")
	    private AndroidElement allowphones;
	   
	    
	   
	    @AndroidFindBy(xpath="//*[@text='APP MANAGER']")
	    private AndroidElement appmanagertitle; 
	    SoftAssert softAssert= new SoftAssert();
	    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView")
	    private AndroidElement usedone;	
	    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")
	    private AndroidElement nusedone;	
	    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[2]")
	    private AndroidElement nusedone1;
	    @AndroidFindBy(xpath="//*[@text='CleanDroid']")
	    private AndroidElement selectapp;
	    @AndroidFindBy(xpath="//*[@resource-id='com.unfoldlabs.redgreen:id/fav']")
	    private AndroidElement favoriteappselection;
	    @AndroidFindBy(xpath="//*[@class='androidx.recyclerview.widget.RecyclerView'][@index='0']")
	    private AndroidElement verifyingfavoritesisavailable;
	    @AndroidFindBy(xpath="//*[@text='Beauty Plus Editor']")
	    private AndroidElement selectappfordelete;
	    @AndroidFindBy(xpath="//*[@resource-id='com.unfoldlabs.redgreen:id/del']")
	    private AndroidElement deleteappselection;
	    @AndroidFindBy(xpath="//*[@text='OK']")
	    private AndroidElement deleteokbutton;
	    @AndroidFindBy(xpath="//*[@text='CANCEL']")
	    private AndroidElement deletecancelbutton;
	    @AndroidFindBy(xpath="//*[@resource-id='com.unfoldlabs.redgreen:id/menu_settings']")
	    private AndroidElement settingclick;
	    @AndroidFindBy(xpath="//*[contains(@text,'Automatically')]")
	    private AndroidElement settingtab;
	    @AndroidFindBy(xpath="//*[@class='android.widget.CheckBox']")
	    private AndroidElement settingcheckbox;
	    @AndroidFindBy(xpath="//*[@text='1 Week']")
	    private AndroidElement oneweek;
	    @AndroidFindBy(xpath="//*[@text='15 Days']")
	    private AndroidElement fifteendays;
	    @AndroidFindBy(xpath="//*[@text='1 Month']")
	    private AndroidElement onemonth;
	    @AndroidFindBy(xpath="//*[@text='DONE']")
	    private AndroidElement doneclick;
	    @AndroidFindBy(xpath="//*[@content-desc='Settings']")
	    private AndroidElement settingbuttonclick;
	    
	    
	    @AndroidFindBy(xpath="//*[@text='Save Battery']")
	    private AndroidElement savebattery; 
	    @AndroidFindBy(xpath="//*[@text='OFF']")
	    private AndroidElement usagepermitusageaccess;
	    @AndroidFindBy(xpath="//*[@text='OFF']")
	    private AndroidElement displaypermitusageaccess;
	    @AndroidFindBy(xpath="//*[contains(@text,'Display')]")
	    private AndroidElement displaytitle;
	    @AndroidFindBy(xpath="(//*[contains(@text,'access')][@class='android.widget.TextView'])[1]")
	    private AndroidElement usageacesstitle;
	    @AndroidFindBy(xpath="//*[@text='SAVE BATTERY']")
	    private AndroidElement savebatterytitle; 
	    @AndroidFindBy(xpath="//*[contains(@text,'Remaining')]")
	    private AndroidElement remainingbatteryinfo;
	    @AndroidFindBy(xpath="//*[@text='System Apps']")
	    private AndroidElement systemappsname;
	    @AndroidFindBy(xpath="//*[contains(@text,'Reset')]")
	    private AndroidElement systemappinfo;
	    @AndroidFindBy(xpath="//*[contains(@text,'Time')]")
	    private AndroidElement screentimeoutset;
	    @AndroidFindBy(xpath="//*[contains(@text,'Blue')]")
	    private AndroidElement bluetoothoff;
	    @AndroidFindBy(xpath="//*[contains(@text,'Bright')]")
	    private AndroidElement screenbritnessdecresemessage;
	    /*@AndroidFindBy(xpath="//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]")
	    private AndroidElement screentimeoutset;
	    @AndroidFindBy(xpath="//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]")
	    private AndroidElement bliuetoothoff;
	    @AndroidFindBy(xpath=" //android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[3]")
	    private AndroidElement screenbritnessdecresemessage;*/
	    @AndroidFindBy(xpath="//*[@resource-id='com.unfoldlabs.redgreen:id/layout_clipdata']")
	    private AndroidElement systemoptimizationmessage;
	    @AndroidFindBy(xpath="//*[@text='DONE']")
	    private AndroidElement donebutton;
	    
	    @AndroidFindBy(xpath="//*[@text='CPU Cooler']")
	    private AndroidElement cpucoolername;
	    @AndroidFindBy(xpath="//*[contains(@text,'All')]")
	    private AndroidElement cpucoolerinfo;
	    @AndroidFindBy(xpath="//*[contains(@text,'One')]")
	    private AndroidElement cpucoolerpopup;
	    @AndroidFindBy(xpath="//*[@text='Cancel']")
	    private AndroidElement cpucoolerpopupcancel;
	    @AndroidFindBy(xpath="//*[@text='Ok']")
	    private AndroidElement cpucoolerpopupok;
	 
	    
	    @AndroidFindBy(xpath="//*[@text='Speed Booster']")
		private AndroidElement Speedbooster;
		@AndroidFindBy(xpath="//*[@text='Disable Auto Sync']")
		private AndroidElement Disableautosync;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement Permissionyes;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement Permissionno;
		@AndroidFindBy(xpath="//*[@text='Enable Auto Sync']")
		private AndroidElement Enableautosync;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement Enablepermissionyes;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement Enablepermissionno;
		@AndroidFindBy(xpath="//*[@text='Disable Wi-Fi']")
		private AndroidElement Disablewifi;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement Disablewifiyes;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement Disablewifino;
		@AndroidFindBy(xpath="//*[@text='Disable Location']")
		private AndroidElement Disablelocation;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement Disablelocationyes;
		@AndroidFindBy(xpath="//*[@text='ON']")
		private AndroidElement Disablelocationoff;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement Disablelocationno;
		@AndroidFindBy(xpath="//*[@text='Update Device']")
		private AndroidElement Updatedevice;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement Updatedeviceno;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement Updatedeviceyes;
		@AndroidFindBy(xpath="//*[@text='Check for update']")
		private AndroidElement Updatecheck;
		@AndroidFindBy(xpath="//*[@text='Notification Block']")
		private AndroidElement Notificationblock;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement permissionno;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement permissionyes;
		@AndroidFindBy(xpath="//*[@text='OFF']")
		private AndroidElement Notificationoff;
		@AndroidFindBy(xpath="//*[@text='ALLOW']")
		private AndroidElement permissionallow;	
		@AndroidFindBy(xpath="//*[@text='Cleanup Home Screen']")
		private AndroidElement cleanuphomescreen;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement popupno;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement popupyes;
		@AndroidFindBy(xpath="//*[@text='Restrict Hotspot']")
		private AndroidElement Restricthotspot;
		@AndroidFindBy(xpath="//*[@text='No']")
		private AndroidElement Restricthotspotpermissionno;
		@AndroidFindBy(xpath="//*[@text='Yes']")
		private AndroidElement Restricthotspotpermissionyes;
		@AndroidFindBy(xpath="//*[@text='ALLOW']")
		private AndroidElement allowphoto;
		@AndroidFindBy(xpath="//*[@text='ALLOW']")
		private AndroidElement allowphone;
		
		
		@AndroidFindBy(xpath = "//*[@text='App Lock']")
		private AndroidElement applock;
		@AndroidFindBy(xpath = "//*[@text='RedGreen']")
		AndroidElement applockpermission;
		@AndroidFindBy(xpath = "//*[@text='OFF']")
		AndroidElement applockpermissionclickonoff;
		@AndroidFindBy(xpath = "//*[@text='OK']")
		AndroidElement applockpermissionok;
		@AndroidFindBy(xpath = "//*[@text='Vysor']")
		AndroidElement vysorlock;
		@AndroidFindBy(xpath = "//*[@text='CleanDroid']")
		AndroidElement CleanDroidlock;
		@AndroidFindBy(xpath = "//*[@text='5']")
		AndroidElement pinnumbertwo;
		@AndroidFindBy(xpath = "//*[@text='2']")
		AndroidElement pinnumberone;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/tick_button']")
		AndroidElement nextbutton;
		@AndroidFindBy(xpath = "//*[@text='ALLOW']")
		AndroidElement allowpermission;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/edit_text']")
		AndroidElement email;
		@AndroidFindBy(xpath = "//*[@text='Done']")
		AndroidElement emaildone;
		@AndroidFindBy(xpath = "//*[@text='OK']")
		AndroidElement permissionok;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/lockUnLockImageView']")
		AndroidElement unlockapp;
		@AndroidFindBy(xpath = "//*[@text='Thank You']")
		AndroidElement forgotpasswordthankyou;
		Boolean vysorlockverify = false;

		@AndroidFindBy(xpath = "//*[@text='8']")
		AndroidElement pinnumberthree;
		@AndroidFindBy(xpath = "//*[@text='0']")
		AndroidElement pinnumberfour;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/forgotPassword']")
		AndroidElement forgotpassword;
		@AndroidFindBy(xpath = "//*[@text='OK']")
		AndroidElement forgotpasswordemailsentok;
		@AndroidFindBy(xpath = "//*[@text='Change Password']")
		AndroidElement changepassword;
		@AndroidFindBy(xpath = "//*[@text='GOT IT']")
		
		
		@AndroidFindBy(xpath = "//*[@text='CANCEL']")
		AndroidElement applockpermissioncancel;
		@AndroidFindBy(xpath = "//*[@text='Vysor']")
		@AndroidFindBy(xpath = "//*[@text='Thank You']")
		private AndroidElement thankyouok;
		@AndroidFindBy(xpath = "//*[@text='Your password has been']")
		private AndroidElement passwordsentok;
		
        
		@AndroidFindBy(xpath = "//*[@text='PREFERENCES']")
		private AndroidElement SettingsPreference;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/appsAutoLock']")
		private AndroidElement AutomaticallyLockappsoninstall;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/appsAutoLock']")
		private AndroidElement AutomaticallyLockappsoninstallbuttonon;
		@AndroidFindBy(xpath = "//*[@text='OK']")
		private AndroidElement SetAppLockok;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/tutorialSwitch']")
		private AndroidElement Tutorials;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/tutorialSwitch']")
		private AndroidElement Tutorialson;
		@AndroidFindBy(xpath = "//*[@text='RATE US ON GOOGLE PLAY']")
		private AndroidElement Rateusongoogleplay;
		@AndroidFindBy(xpath = "//*[@text='RECOMMEND US']")
		private AndroidElement Recommendus;
		@AndroidFindBy(xpath = "//*[@text='Messages']")
		private AndroidElement Messages;
		@AndroidFindBy(xpath = "//*[@text='NEW MESSAGE']")
		private AndroidElement Newmessages;
		@AndroidFindBy(xpath = "//*[@class='android.widget.MultiAutoCompleteTextView']")
		private AndroidElement Phonenumber;
		@AndroidFindBy(xpath = "//*[@resource-id='com.google.android.apps.messaging:id/contact_picker_create_group']")
		private AndroidElement Sendtonumber;
		@AndroidFindBy(xpath = "//*[@text ='SMS']")
		private AndroidElement Send;
		@AndroidFindBy(xpath = "//*[@text='Gmail']")
		private AndroidElement Gmail;
		@AndroidFindBy(xpath = "//*[@resource-id ='com.google.android.gm:id/to']")
		private AndroidElement Toselect;
		@AndroidFindBy(xpath = "//*[@resource-id ='com.google.android.gm:id/send']")
		private AndroidElement Sendbutton;
		@AndroidFindBy(xpath = "//*[@text ='Copy to clipboard']")
		private AndroidElement Clipboard;
		@AndroidFindBy(xpath = "//*[@text ='Save to Drive']")
		private AndroidElement Savetodrive;
		@AndroidFindBy(xpath = "//*[@text ='I tried.txt']")
		private AndroidElement Documenttitle;
		@AndroidFindBy(xpath = "//*[@text ='SAVE']")
		private AndroidElement Savebutton;
		@AndroidFindBy(xpath = "//*[@text='GET APP LOCK PASSWORD']")
		private AndroidElement getapplockpassword;
		@AndroidFindBy(xpath = "//*[@text='Forgot Password?']")
		private AndroidElement forgotpasswordtext;
		@AndroidFindBy(xpath = "//*[@text='SEND']")
		private AndroidElement sendbuttonclick;
		@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/appsAutoLock']")
		private AndroidElement togglebuttonon;
		

		
		ExtentReportforSaveBattery ESaveBattery = new ExtentReportforSaveBattery();
	    ExtentReportAppLockPinSetup EAppLockPinSetUP = new ExtentReportAppLockPinSetup();
        ExtentReportAppLockForgotPassword EApplockForgotPassword = new ExtentReportAppLockForgotPassword();
		ExtentReportAppLockChangePassword EApplockChangePassword = new ExtentReportAppLockChangePassword();
		
		@Test(priority=1)
	    public void savebatteryclick() throws Exception, InterruptedException, MalformedURLException
	    {

	    	/* Open the Extent Report
	    	 * verifing splashscreens 
	         */
	    	ESaveBattery.exreportopen();
	    	ESaveBattery.redgreenappopen(driver);
	    	Thread.sleep(5000);
	    	gotit.click();
	    	Thread.sleep(5000);
	    	ESaveBattery.splashscreenverification(driver);
	    	Thread.sleep(3000);
	       	allowphotosandmedia.click();
	       	Thread.sleep(3000);
	       	allowphones.click();
	       	
	    	
	       	
	       	/*Click on  Appmanager module to verify remove unsecure apps exist
	         * Remove unsecure apps - To delete the unsecure apps
	         * Great you don't have Unsecure Apps - message verification
	         */
	       	
			try {
				savebattery.isDisplayed();
				savebattery.click();  
				ESaveBattery.savebatterypass(driver);
				Thread.sleep(5000);
		  	    try{
		  	    	savebatterytitle.isDisplayed();
		  	    }catch(Exception ex){
		  		       acceptpermissionok.click();
		  		       try{
		  		    	 Thread.sleep(5000);
		  		    	  displaytitle.isDisplayed();
		  		    	  Thread.sleep(5000);
		  		    	  displaypermitusageaccess.click();
		  		    	  Thread.sleep(5000);
		  		    	  driver.navigate().back();
		  		    	  Thread.sleep(5000);
		  		       }catch(Exception e){
		  		    	  redgreenoption.click();
		  		    	  Thread.sleep(5000);
		  		    	  usagepermitusageaccess.click();
		  		    	  Thread.sleep(5000);
		  		    	  displaypermitusageaccess.click();
		  		    	  Thread.sleep(5000);
		  		    	  driver.navigate().back();
		  		    	  Thread.sleep(5000);
		  		    	  driver.navigate().back();
		  		    	  Thread.sleep(5000);
		  		    	  driver.navigate().back();
		  		    	  Thread.sleep(5000);
		  		    	  savebattery.click(); 
		  		       }	  			   
		  			}
		  	        try{
		  	             remainingbatteryinfo.isDisplayed();
		  	        	 String bs=remainingbatteryinfo.getText();
		  	        	 Thread.sleep(5000);
		  	        	 System.out.println("Remaining Battery Info :"+bs);
		  	        	 ESaveBattery.remainingbatterypass(driver);
		  	        	 Thread.sleep(5000);
		  	        }catch(Exception e){
		  	        	ESaveBattery.remainingbatteryfail(driver);
		  	        }  
		  	        try {
		  	        	    systemappsname.isDisplayed();
		  	        	    Thread.sleep(5000);
		  	        	    ESaveBattery.systemappsspass(driver);
		  	        	    Thread.sleep(5000);
		  	        	    try {
		  	        		    systemappinfo.isDisplayed();
		  	        		    Thread.sleep(5000);
		  	        		    String s=systemappinfo.getText();
		  	        		    System.out.println("System App Info :" +s);
		  	        		    Thread.sleep(5000);
		  	        		    ESaveBattery.systemappinfopass(driver);
		  	        		    Thread.sleep(5000);
		  	        	    }catch(Exception e){
		  	        		    ESaveBattery.systemappinfofail(driver);}
		  	        	    try {
		  	        		    systemappsname.click();
		  	        		    Thread.sleep(5000);
		  	        		    savebatterytitle.isDisplayed();
		  	        	     }catch(Exception e) {
		  	        	    	Thread.sleep(5000);
			  		    	    displaypermitusageaccess.click();
			  		    	    Thread.sleep(5000);
			  		    	    driver.navigate().back();
			  		    	    Thread.sleep(5000);   
			  		         }
		  	        	    try{
		  	        	        //String b=systemoptimizationmessage.getText();
		  	        	        //System.out.println(b);
		  	        	       //Thread.sleep(5000);  
		  	        	       String c=screentimeoutset.getText();
		  	        	       System.out.println(c);
		  	        	       Thread.sleep(5000);
		  	        	       String d=bluetoothoff.getText();
		  	        	       Thread.sleep(5000);
		  	        	       System.out.println(d);
		  	        	       Thread.sleep(5000);
		  	        	       String e=screenbritnessdecresemessage.getText();
		  	        	       System.out.println(e);
		  	        	       Thread.sleep(5000);
		  	        	       donebutton.click();
		  	        	       ESaveBattery.alloptimizationinfopass(driver);
		  	        	       Thread.sleep(5000);
		  	        	    }catch(Exception e) {
		  	        		   ESaveBattery.alloptimizationinfofail(driver);
		  	        		   Thread.sleep(5000);
			  	        	   driver.navigate().back();
			  	        	   Thread.sleep(5000);
			  	        	   driver.navigate().back();}
		  	        	}catch(Exception ex) {
		  	        		ESaveBattery.alloptimizationinfofail(driver);
		  	        		Thread.sleep(5000);
		  	        		driver.navigate().back();
		  	        		Thread.sleep(5000);
		  	        		driver.navigate().back();
		  	        	}
		  	        	try{
		  	        		savebattery.click();
		  	        		cpucoolername.isDisplayed();
			  	        	ESaveBattery.cpucoolerpass(driver);
			  	        	Thread.sleep(5000);
			  	        	try {
			  	        		Thread.sleep(5000);
			  	        		cpucoolerinfo.isDisplayed();
			  	        		String s=cpucoolerinfo.getText();
			  	        		Thread.sleep(5000);
			  	        		System.out.println("CPU App Info :" +s);
			  	        		ESaveBattery.cpucoolerinfopass(driver);
			  	        		Thread.sleep(5000);
			  	        		cpucoolername.click();
			  	        		Thread.sleep(5000);
			  	        	}catch(Exception e) {
			  	        		ESaveBattery.cpucoolerinfofail(driver);}
			  	        	try {
			  	        		cpucoolerpopup.isDisplayed();
			  	        	}catch(Exception e) {
			  	        		Thread.sleep(5000);
			  	        		redgreenoption.click();
			  	        		Thread.sleep(5000);
				  		    	displaypermitusageaccess.click();
				  		    	Thread.sleep(5000);
				  		    	acceptpermissionok.click();
				  		    	Thread.sleep(5000); 
				  		    	driver.navigate().back();
				  		    	Thread.sleep(5000);
				  		    	driver.navigate().back();
				  		    	Thread.sleep(5000);
				  		    	cpucoolername.click();
				  		    	Thread.sleep(5000);
				  		     }
			  	        	try {
			  	        		Thread.sleep(5000);
			  	        		cpucoolername.click();
			  	        		Thread.sleep(5000);
			  	        		cpucoolerpopup.isDisplayed();
			  	        		Thread.sleep(5000);
			  	        		cpucoolerpopupcancel.click();
			  	        		ESaveBattery.cpucoolercancelpass(driver);
			  	        	}catch(Exception e){
			  	        		ESaveBattery.cpucoolercancelfail(driver);
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        	}
			  	        	try {
			  	        		cpucoolername.click();
			  	        		Thread.sleep(5000);
			  	        		cpucoolerpopup.isDisplayed();
			  	        		cpucoolerpopupok.click();
			  	        		Thread.sleep(8000);
			  	        		driver.findElement(By.xpath("//*[@resource-id='com.android.settings:id/battery_percent']")).click();
	                            Thread.sleep(5000);
	                            ESaveBattery.cpucoolbattery(driver);
	                            Thread.sleep(5000);
	                            driver.navigate().back();
	                            Thread.sleep(5000);
	                            
	                            driver.findElement(By.id("com.android.settings:id/switchWidget")).click();
			  	        		Thread.sleep(5000);
			  	        		driver.findElement(By.id("com.android.settings:id/switchWidget")).click();
			  	        		Thread.sleep(5000);
			  	        		ESaveBattery.cpucoolerbaterysever(driver);
			  	        		driver.findElement(By.xpath("//*[@resource-id='android:id/switch_widget']")).click();
	                            Thread.sleep(5000);
			  	        		driver.findElement(By.xpath("//*[@resource-id='android:id/switch_widget']")).click();
			  	        		Thread.sleep(5000);
			  	        		ESaveBattery.cpucoolerbaterypercentage(driver);
			  	        		driver.findElement(By.xpath("//*[@text='Sleep']")).click();
			  	        		Thread.sleep(5000);
			  	                driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='2 minutes']")).click();
			  	                Thread.sleep(5000);
			  	                driver.findElement(By.xpath("//*[@text='Sleep']")).click();
			  	                Thread.sleep(5000);
			  	                
			  	                driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='30 minutes']")).click();
			  	                Thread.sleep(5000);
			  	              
			  	                ESaveBattery.cpucoolermobilesleep(driver);
			  	              
			  	                driver.findElement(By.xpath("//*[@content-desc='More options']")).click();
			  	        		Thread.sleep(5000);
			  	                
			  	        		driver.findElement(By.xpath("//*[@text='Show full device usage']")).click();
			  	        		Thread.sleep(5000);
			  	                
			  	        		String s1= driver.findElement(By.xpath("(//*[@resource-id='android:id/title'])[7]")).getText();
			  	        		Thread.sleep(5000);
			  	                System.out.println(s1);
			  	                 Thread.sleep(5000);
			  	        		
			  	                 
			  	                 
			  	               driver.findElement(By.xpath("//*[@content-desc='More options']")).click();
			  	        		Thread.sleep(5000);
			  	                
			  	        		driver.findElement(By.xpath("//*[@text='Show app usage']")).click();
			  	        		Thread.sleep(5000);
			  	                
			  	        		String s= driver.findElement(By.xpath("(//*[@resource-id='android:id/title'])[7]")).getText();
			  	        		Thread.sleep(5000);
			  	                System.out.println(s);
			  	                 Thread.sleep(5000);
			  	        		
			  	                 
			  	                 
			  	                 
			  	        		ESaveBattery.cpucoolerokpass(driver);
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        	}catch(Exception e){
			  	        		ESaveBattery.cpucoolerokfail(driver);
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        	}
		  	        }catch(Exception e) {
		  	        	ESaveBattery.cpucoolerfail(driver);
		  	        }	  	        
			    }catch(Exception e){
	   			  ESaveBattery.savebatteryfail(driver);
	   		}
			
			
		}
		@Test(priority=5)
	    public void AppLockPinSetupWithpermissionclick() throws Exception 
	    {
			EAppLockPinSetUP.exreportopen();
			Thread.sleep(5000);
			try {
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				EAppLockPinSetUP.applockclickpass(driver);

				try {
					applockpermission.isDisplayed();
					applockpermission.click();
					Thread.sleep(5000);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					applockpermissionclickonoff.click();
					Thread.sleep(5000);
					applockpermissionok.click();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					applock.click();

				} catch (Exception ex2) {
					vysorlock.isDisplayed();

				}

				try {
					vysorlock.click();
					//CleanDroidlock.click();
					Thread.sleep(5000);
					EAppLockPinSetUP.applockwithpermissionspass(driver);

				} catch (Exception ex2) {
					EAppLockPinSetUP.applockwithpermissionsfail(driver);
				}

				try {
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(5000);
					}
					nextbutton.click();
					for (int n = 0; n < 4; n++) {
						pinnumberone.click();
						Thread.sleep(5000);
					}
					EAppLockPinSetUP.applockinvalidpinpass(driver);
					nextbutton.click();
					WebDriverWait wait = new WebDriverWait(driver, 25);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage);
					Thread.sleep(5000);
					for (int j = 0; j < 4; j++) {
						pinnumbertwo.click();
						Thread.sleep(5000);
					}
					nextbutton.click();
					Thread.sleep(5000);
					EAppLockPinSetUP.applockpinverifyuppass(driver);

					try {
						allowpermission.click();
						Thread.sleep(5000);
						email.sendKeys("bhanupriy");
						emaildone.click();
						Thread.sleep(5000);
						email.clear();
						Thread.sleep(5000);
						EAppLockPinSetUP.applockpinvalidemailverifyppass(driver);
						email.sendKeys("bhanupriyam@ctrlaltfix.co");
						Thread.sleep(5000);
						emaildone.click();
						Thread.sleep(5000);
						try {
							vysorlock.isDisplayed();
							//CleanDroidlock.isDisplayed();
						} catch (Exception ex) {
							Thread.sleep(5000);
							applockpermissionok.click();
							Thread.sleep(5000);
							applockpermission.click();
							Thread.sleep(5000);
							applockpermissionclickonoff.click();
							Thread.sleep(5000);
							applockpermissionclickonoff.click();
							Thread.sleep(5000);
						}
						Thread.sleep(8000);

						//CleanDroidlock.click();
						Thread.sleep(5000);
						driver.navigate().back();
						driver.navigate().back();
						Thread.sleep(10000);
			        	//driver.activateApp("com.unfoldlabs.redgreen");
						EAppLockPinSetUP.applockpinsetupfunctionalityppass(driver);
						
					}

					catch (Exception ex) {
						EAppLockPinSetUP.applockpinvalidemailverifyfail(driver);
						

					}

				} catch (Exception ex) {
					EAppLockPinSetUP.applockinvalidpinfail(driver);
					
				}
			} catch (Exception ex) {
				EAppLockPinSetUP.applockclickfail(driver);
				

			}
		}
		@Test(priority=6)
	    public void AppLockChangePasswordclick() throws Exception {
			EApplockChangePassword.exreportopen();
			Thread.sleep(5000);
		

			try {
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				EApplockChangePassword.applockclickpass(driver);

				Boolean changepasswordverify = false;
				try {
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(3000);
					}
					Thread.sleep(3000);
					nextbutton.click();
					Thread.sleep(3000);
					driver.findElementByAccessibilityId("Settings").click();
					Thread.sleep(5000);
					changepassword.click();
					if (changepasswordverify == true) {
						EApplockChangePassword.applockchangepasswordtextverifypass(driver);
					} else {
						EApplockChangePassword.applockchangepasswordtextverifyfail(driver);
					}
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(3000);
					}
					nextbutton.click();
					Thread.sleep(5000);
					for (int j = 0; j < 4; j++) {
						pinnumbertwo.click();
						Thread.sleep(3000);
					}
					nextbutton.click();
					Thread.sleep(5000);
					email.clear();
					Thread.sleep(5000);
					email.sendKeys("bhanupriyam@ctrlaltfix.co");
					Thread.sleep(5000);
					emaildone.click();
					Thread.sleep(5000);
					unlockapp.click();
					Thread.sleep(5000);
					unlockapp.click();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					EApplockChangePassword.applockcchangepasswordpass(driver);

				}catch(Exception ex) {
				   try {
					applockpermission.isDisplayed();
					applockpermission.click();
					Thread.sleep(5000);
					applockpermissionclickonoff.click();
					Thread.sleep(5000);
					applockpermissionok.click();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					applock.click();
					Thread.sleep(5000);
					driver.findElementByAccessibilityId("Settings").click();
					Thread.sleep(5000);
					changepassword.click();
					Thread.sleep(5000);
					changepasswordverify = true;
					if (changepasswordverify == true) {
						EApplockChangePassword.applockchangepasswordtextverifypass(driver);
					} else {
						EApplockChangePassword.applockchangepasswordtextverifyfail(driver);
					}
					Thread.sleep(5000);
					nextbutton.click();
					WebDriverWait wait = new WebDriverWait(driver, 25);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage);
					EApplockChangePassword.applockcwithoupinpass(driver);
					
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
					}
					nextbutton.click();
					Thread.sleep(5000);
					for (int j = 0; j < 4; j++) {
						pinnumbertwo.click();
					}
					nextbutton.click();
					Thread.sleep(5000);
					allowpermission.click();
					Thread.sleep(5000);
					// Email Id
					email.sendKeys("bhanupriyam@ctrlaltfix.co");
					Thread.sleep(5000);
					emaildone.click();
					Thread.sleep(5000);
					unlockapp.click();
					WebDriverWait wait1 = new WebDriverWait(driver, 25);
					wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage1);
					EApplockChangePassword.applockcwithoupinpass(driver);
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					EApplockChangePassword.applockcchangepasswordpass(driver);
					EApplockChangePassword.exreportclose();
				} catch (Exception ex1) {
					driver.findElementByAccessibilityId("Settings").click();
					Thread.sleep(5000);
					changepassword.click();
					if (changepasswordverify == true) {
						EApplockChangePassword.applockchangepasswordtextverifypass(driver);
					} else {
						EApplockChangePassword.applockchangepasswordtextverifyfail(driver);
					}
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
					}
					nextbutton.click();
					Thread.sleep(5000);
					for (int j = 0; j < 4; j++) {
						pinnumbertwo.click();
					}
					nextbutton.click();
					Thread.sleep(5000);
					allowpermission.click();
					Thread.sleep(5000);
					email.sendKeys("bhanupriyam@ctrlaltfix.co");
					Thread.sleep(5000);
					emaildone.click();
					Thread.sleep(5000);
					unlockapp.click();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					EApplockChangePassword.applockcchangepasswordpass(driver);
				}
				}
			} catch (Exception ex) {
				EApplockChangePassword.applockclickfail(driver);
				
			}
					}
		@Test(priority=7)
	    public void ForgotPassword() throws Exception 
		{
			EApplockForgotPassword.exreportopen();
			Thread.sleep(5000);
			try {
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				EApplockForgotPassword.applockclickpass(driver);

				try {					
					forgotpassword.isDisplayed();
					Thread.sleep(5000);
					forgotpassword.click();
					Thread.sleep(5000);
					applockpermissionok.click();
					Thread.sleep(5000);
					applockpermissionok.click();
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(3000);
					}
					Thread.sleep(5000);
					nextbutton.click();
					Thread.sleep(5000);
					vysorlock.click();
					WebDriverWait wait2 = new WebDriverWait(driver, 25);
					wait2.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage2 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage2);
					Thread.sleep(8000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='SYSTEM APPS']")).click();
					Thread.sleep(5000);

					driver.findElement(By.id("com.unfoldlabs.redgreen:id/searchEditText")).sendKeys("calculator");
					Thread.sleep(5000);

					driver.findElement(By.xpath("//*[@text='Calculator']")).click();
					WebDriverWait wait1 = new WebDriverWait(driver, 25);
					wait1.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage1);
					Thread.sleep(5000);
					/////////////////////// **********CALCULATOR
					/////////////////////// OPEN*******//////////////////////////////////////

					Activity activity = new Activity("com.android.calculator2", "com.android.calculator2.Calculator");
					Thread.sleep(5000);
					activity.setStopApp(false);
					driver.startActivity(activity);
					Thread.sleep(5000);
					driver.navigate().back();
					
				}catch (Exception ex) {
					applockpermission.isDisplayed();
					try {applockpermission.click();
						Thread.sleep(5000);
						applockpermissionclickonoff.click();
						Thread.sleep(5000);
						applockpermissionok.click();
						Thread.sleep(5000);
						driver.navigate().back();
						Thread.sleep(5000);
						driver.navigate().back();
						Thread.sleep(5000);
						applock.click();
						Thread.sleep(5000);
						vysorlock.click();
						Thread.sleep(5000);
						for (int i = 0; i < 4; i++) {
							pinnumbertwo.click();
							Thread.sleep(5000);
						}
						nextbutton.click();
						Thread.sleep(5000);
						for (int j = 0; j < 4; j++) {
							pinnumbertwo.click();
							Thread.sleep(5000);
						}
						nextbutton.click();
						Thread.sleep(5000);
						EApplockForgotPassword.applockpinsetuppass(driver);
						
					} catch (Exception ex1) {
						EApplockForgotPassword.applockpinsetupfail(driver);
					}

					try {
						allowpermission.click();
						Thread.sleep(5000);
						email.sendKeys("bhanupriyam@ctrlaltfix.co");
						Thread.sleep(5000);
						emaildone.click();
						Thread.sleep(5000);
						driver.navigate().back();
						Thread.sleep(5000);
						applock.click();
						Thread.sleep(5000);
						forgotpassword.click();
						Thread.sleep(5000);
						applockpermissionok.click();
						EApplockForgotPassword.applockforgotpasstoastmessagepass(driver);
						applockpermissionok.click();
						Thread.sleep(5000);

						for (int i = 0; i < 4; i++) {
							pinnumberthree.click();
							Thread.sleep(5000);
						}
						nextbutton.click();
						Thread.sleep(5000);
						EApplockForgotPassword.applockforgotpasswordinvalidpinverifypass(driver);

						for (int j = 0; j < 4; j++) {
							pinnumbertwo.click();
							Thread.sleep(5000);
						}

						nextbutton.click();
						Thread.sleep(5000);
						Thread.sleep(5000);
						vysorlock.click();
						WebDriverWait wait2 = new WebDriverWait(driver, 25);
						wait2.until(
								ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
						String atoastmessage2 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
						System.out.println(atoastmessage2);
						Thread.sleep(8000);
						driver.findElement(By.xpath("//android.widget.TextView[@text='SYSTEM APPS']")).click();
						Thread.sleep(5000);

						driver.findElement(By.id("com.unfoldlabs.redgreen:id/searchEditText")).sendKeys("calculator");
						Thread.sleep(5000);

						driver.findElement(By.xpath("//*[@text='Calculator']")).click();
						WebDriverWait wait1 = new WebDriverWait(driver, 25);
						wait1.until(
								ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
						String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
						System.out.println(atoastmessage1);
						Thread.sleep(5000);
						/////////////////////// **********CALCULATOR
						/////////////////////// OPEN*******//////////////////////////////////////

						Activity activity = new Activity("com.android.calculator2", "com.android.calculator2.Calculator");
						Thread.sleep(5000);
						activity.setStopApp(false);
						driver.startActivity(activity);
						Thread.sleep(5000);
						driver.navigate().back();

						driver.navigate().back();
						
						
						EApplockForgotPassword.applockforgotpasswordpass(driver);
						

					} catch (Exception ex2) {
						EApplockForgotPassword.applockforgotpasswordfail(driver);
						
					}

				}
				 
			} catch (Exception ex) {
				EApplockForgotPassword.applockclickfail(driver);
				
			}
			ESaveBattery.exreportclose();
			EAppLockPinSetUP.exreportclose();
			EApplockForgotPassword.exreportclose();
			EApplockChangePassword.exreportclose();
		}
	    public void closeapp() throws Exception
	    {
	    		
	    	
	    	Thread.sleep(5000);
	        driver.closeApp();
	        
            //Stop the Server
	        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	        
	    }
	}
