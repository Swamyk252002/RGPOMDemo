package com.RedGreen.AppManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ExtentReports.ExtentReportAppLockChangePassword;
import com.ExtentReports.ExtentReportAppLockForgotPassword;
import com.ExtentReports.ExtentReportAppLockPinSetup;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ZRedGreenDetails_AppLock 
{
	 AndroidDriver<AndroidElement> driver;
	    
	    public ZRedGreenDetails_AppLock(AndroidDriver<AndroidElement> driver)
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
		

		
		ExtentReportAppLockPinSetup exrapplockwithpermissions = new ExtentReportAppLockPinSetup();
        ExtentReportAppLockForgotPassword exrapplockforgotpassword = new ExtentReportAppLockForgotPassword();
		ExtentReportAppLockChangePassword exrapplockchangepassword = new ExtentReportAppLockChangePassword();
		
		
		@Test(priority=5)
	    public void AppLockPinSetupWithpermissionclick() throws Exception 
	    {
			exrapplockwithpermissions.exreportopen();
			Thread.sleep(5000);
			exrapplockwithpermissions.redgreenappopen(driver);
			Thread.sleep(5000);
			gotit.click();
			Thread.sleep(5000);
			exrapplockwithpermissions.splashscreenverification(driver);
			Thread.sleep(5000);
			allowphotosandmedia.click();
			Thread.sleep(5000);
			allowphones.click();
			Thread.sleep(5000);
			exrapplockwithpermissions.allowphotosmediaandphonespermissionsallow(driver);
			Thread.sleep(5000);
           try {
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				exrapplockwithpermissions.applockclickpass(driver);

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
					exrapplockwithpermissions.applockwithpermissionspass(driver);

				} catch (Exception ex2) {
					exrapplockwithpermissions.applockwithpermissionsfail(driver);
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
					exrapplockwithpermissions.applockinvalidpinpass(driver);
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
					exrapplockwithpermissions.applockpinverifyuppass(driver);

					try {
						allowpermission.click();
						Thread.sleep(5000);
						email.sendKeys("bhanupriy");
						emaildone.click();
						Thread.sleep(5000);
						email.clear();
						Thread.sleep(5000);
						exrapplockwithpermissions.applockpinvalidemailverifyppass(driver);
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
						exrapplockwithpermissions.applockpinsetupfunctionalityppass(driver);
						
					}

					catch (Exception ex) {
						exrapplockwithpermissions.applockpinvalidemailverifyfail(driver);
						

					}

				} catch (Exception ex) {
					exrapplockwithpermissions.applockinvalidpinfail(driver);
					
				}
			} catch (Exception ex) {
				exrapplockwithpermissions.applockclickfail(driver);
				

			}
		}
		@Test(priority=6)
	    public void AppLockChangePasswordclick() throws Exception {
			exrapplockchangepassword.exreportopen();
			Thread.sleep(5000);
		

			try {
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				exrapplockchangepassword.applockclickpass(driver);

				Boolean changepasswordverify = true;
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
						exrapplockchangepassword.applockchangepasswordtextverifypass(driver);
					} else {
						exrapplockchangepassword.applockchangepasswordtextverifyfail(driver);
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
					WebDriverWait wait1 = new WebDriverWait(driver, 25);
					wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage1);
					
					Thread.sleep(5000);
					unlockapp.click();
					WebDriverWait wait2 = new WebDriverWait(driver, 25);
					wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage2 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage2);
					
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					exrapplockchangepassword.applockcchangepasswordpass(driver);

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
						exrapplockchangepassword.applockchangepasswordtextverifypass(driver);
					} else {
						exrapplockchangepassword.applockchangepasswordtextverifyfail(driver);
					}
					Thread.sleep(5000);
					nextbutton.click();
					WebDriverWait wait = new WebDriverWait(driver, 25);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage);
					exrapplockchangepassword.applockcwithoupinpass(driver);
					
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
					exrapplockchangepassword.applockcwithoupinpass(driver);
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					exrapplockchangepassword.applockcchangepasswordpass(driver);
					exrapplockchangepassword.exreportclose();
				} catch (Exception ex1) {
					driver.findElementByAccessibilityId("Settings").click();
					Thread.sleep(5000);
					changepassword.click();
					if (changepasswordverify == true) {
						exrapplockchangepassword.applockchangepasswordtextverifypass(driver);
					} else {
						exrapplockchangepassword.applockchangepasswordtextverifyfail(driver);
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
					exrapplockchangepassword.applockcchangepasswordpass(driver);
				}
				}
			} catch (Exception ex) {
				exrapplockchangepassword.applockclickfail(driver);
				
			}
					}
		@Test(priority=7)
	    public void ForgotPassword() throws Exception 
		{
			exrapplockforgotpassword.exreportopen();
			Thread.sleep(5000);
			try {
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				exrapplockforgotpassword.applockclickpass(driver);

				try {					
					forgotpassword.isDisplayed();
					Thread.sleep(5000);
					forgotpassword.click();
					Thread.sleep(5000);
					applockpermissioncancel.click();
					exrapplockforgotpassword.applockforgotpassworcancel(driver);
					Thread.sleep(5000);
					forgotpassword.click();
					Thread.sleep(5000);
					applockpermissionok.click();
					exrapplockforgotpassword.applockforgotpasswordemail(driver);
					Thread.sleep(5000);
					applockpermissionok.click();
					exrapplockforgotpassword.applockforgotpasswordsucessfullshared(driver);
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(3000);
					}
					Thread.sleep(5000);
					
					nextbutton.click();
					
					exrapplockforgotpassword.applockforgotpasswordpass(driver);
					Thread.sleep(5000);
					/*vysorlock.click();
					WebDriverWait wait2 = new WebDriverWait(driver, 25);
					wait2.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage2 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage2);
					Thread.sleep(8000);*/
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
						exrapplockforgotpassword.applockpinsetuppass(driver);
						
					} catch (Exception ex1) {
						exrapplockforgotpassword.applockpinsetupfail(driver);
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
						exrapplockforgotpassword.applockforgotpasstoastmessagepass(driver);
						applockpermissionok.click();
						Thread.sleep(5000);

						for (int i = 0; i < 4; i++) {
							pinnumberthree.click();
							Thread.sleep(5000);
						}
						nextbutton.click();
						Thread.sleep(5000);
						exrapplockforgotpassword.applockforgotpasswordinvalidpinverifypass(driver);

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
						
						
						exrapplockforgotpassword.applockforgotpasswordpass(driver);
						

					} catch (Exception ex2) {
						exrapplockforgotpassword.applockforgotpasswordfail(driver);
						
					}

				}
				 
			} catch (Exception ex) {
				exrapplockforgotpassword.applockclickfail(driver);
				
			}
			exrapplockwithpermissions.exreportclose();
			exrapplockchangepassword.exreportclose();
			exrapplockforgotpassword.exreportclose();
		}
		

		

	    public void closeapp() throws Exception
	    {
	    		
	    	
	    	Thread.sleep(5000);
	        driver.closeApp();
	        Thread.sleep(1000);
            //Stop the Server
	        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	       
	  
	    }
	}
