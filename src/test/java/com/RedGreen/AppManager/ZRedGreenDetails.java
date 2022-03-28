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

public class ZRedGreenDetails 
{
	 AndroidDriver<AndroidElement> driver;
	    
	    public ZRedGreenDetails(AndroidDriver<AndroidElement> driver)
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
		

		
		ExtentReportForSpeedBooster exrrunspeedbooster= new ExtentReportForSpeedBooster();
	    ExtentReportforAppManagerFavAndDel ERforAppManagerFavAndDel = new ExtentReportforAppManagerFavAndDel();
	    ExtentReportforRemoveUnsecureApps exrremoveunsecureapps = new ExtentReportforRemoveUnsecureApps();
	    ExtentReportforSaveBattery ERforSaveBattery = new ExtentReportforSaveBattery();
	    ExtentReportAppLockPinSetup exrapplockwithpermissions = new ExtentReportAppLockPinSetup();
        ExtentReportAppLockForgotPassword exrapplockforgotpassword = new ExtentReportAppLockForgotPassword();
		ExtentReportAppLockChangePassword exrapplockchangepassword = new ExtentReportAppLockChangePassword();
		ExtentReportSettings exrrunsettings = new ExtentReportSettings();
		
		@Test(priority=1)
	    public void appmanagerfavdelclick() throws Exception, InterruptedException, MalformedURLException
	    {

	    	/* Open the Extent Report
	    	 * verifing splashscreens 
	         */
	    	
	    	ERforAppManagerFavAndDel.exreportopen();
	    	ERforAppManagerFavAndDel.redgreenappopen(driver);
	    	Thread.sleep(5000);
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    	gotit.click();
	    	Thread.sleep(5000);
	       	ERforAppManagerFavAndDel.splashscreenverification(driver);
	       	allowphotosandmedia.click();
	       	Thread.sleep(5000);
	       	allowphones.click();
	       	
	       	/*Click on  Appmanager module to verify remove unsecure apps exist
	         * Remove unsecure apps - To delete the unsecure apps
	         * Great you don't have Unsecure Apps - message verification
	         */
	       	
	       	//String emname="App Manager";
	 	    //String amname=appmanager.getText();
			try {System.out.println("fevdel");
				allowphones.click();
				appmanager.isDisplayed();
			    appmanager.click();  
			    Thread.sleep(5000);
			    ERforAppManagerFavAndDel.appmanagerpass(driver);   
		  	    try{
		  	        	appmanagertitle.isDisplayed();	
		  	        	Thread.sleep(5000);
		  	  	    }
		  	        catch(Exception ex){
		  		       acceptpermissionok.click();
		  		       Thread.sleep(5000);
		  			   redgreenoption.click();
		  			   Thread.sleep(5000);
		  			   permitusageaccess.click();
		  			   Thread.sleep(5000);
		  			   driver.navigate().back();
		  			   Thread.sleep(5000);
		  			   appmanager.click(); 	   
		  			}
		  	        try {
		  	        
		  	              appmanagertitle.isDisplayed();
		 		          //ERforAppManagerFavAndDel.headingsoflistappspass(driver);
		  	        	  List<AndroidElement> Usedandnotusedapps= driver.findElementsByXPath("//*[contains(@text,'used')]");
			              //System.out.println("List Of Used and Not Used names : " + Usedandnotusedapps.size());
			              Thread.sleep(5000);
			              int appsacount=Usedandnotusedapps.size();
			              //System.out.println(appsacount);
			              Thread.sleep(5000);
			              //int appeacount=1;
		  	        	  if(appsacount!=0)
		  	        	  {  
		  	        		      
		  	        		      for(int i = 0; i<Usedandnotusedapps.size();i++){
					              //System.out.println(Usedandnotusedapps.get(i).getText());
					              Thread.sleep(5000);}
	        	        		  //ERforAppManagerFavAndDel.listofusedorunusedappspass(driver);
	        	        		  
	        	        		  if(appsacount==1){
			                         List<AndroidElement> Usedandnotusedapps1= driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
			                         System.out.println("List Of Used and Not Used names : " + Usedandnotusedapps1.size());
			                         Thread.sleep(5000);
			                        // System.out.println( Usedandnotusedapps1.size());
			                         Thread.sleep(5000);
			                         for(int i = 0; i<Usedandnotusedapps1.size();i++){
					                     System.out.println(Usedandnotusedapps1.get(i).getText());
					                     Thread.sleep(5000);}
			                         ERforAppManagerFavAndDel.listofusedorunusedappspass(driver);
			                      }
			                     /* else if(appsacount==2){
			            	         List<AndroidElement> Usedandnotusedapps1= driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
			                         System.out.println("List Of Used and Not Used named : " + Usedandnotusedapps1.size());
			                         for(int i = 0; i<Usedandnotusedapps1.size();i++){
					                     System.out.println(Usedandnotusedapps1.get(i).getText());}
			                         List<AndroidElement> Usedandnotusedapps2= driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
			                         System.out.println("List Of Used and Not Used named : " + Usedandnotusedapps2.size());
			                         for(int i = 0; i<Usedandnotusedapps2.size();i++){
					                      System.out.println(Usedandnotusedapps2.get(i).getText());}
			                         ERforAppManagerFavAndDel.listofusedorunusedappspass(driver);
			            	       }
			                       else if(appsacount==3){
			            	          List<AndroidElement> Usedandnotusedapps1= driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
			                          System.out.println("List Of Used and Not Used named : " + Usedandnotusedapps1.size());
			                          for(int i = 0; i<Usedandnotusedapps1.size();i++){
					                      System.out.println(Usedandnotusedapps1.get(i).getText());}
			                          List<AndroidElement> Usedandnotusedapps2= driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
			                          System.out.println("List Of Used and Not Used named : " + Usedandnotusedapps2.size());
			                          for(int i = 0; i<Usedandnotusedapps2.size();i++){
					                      System.out.println(Usedandnotusedapps2.get(i).getText());}
			                          List<AndroidElement> Usedandnotusedapps3= driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
			                          System.out.println("List Of Used and Not Used named : " + Usedandnotusedapps3.size());
			                          for(int i = 0; i<Usedandnotusedapps3.size();i++){
					                     System.out.println(Usedandnotusedapps3.get(i).getText());}
			                          ERforAppManagerFavAndDel.listofusedorunusedappspass(driver);
			                       }*/
	        	             try {
	        	            	  selectapp.click();
	        	        		  Thread.sleep(5000);
	   		                      favoriteappselection.click();
	   		                      WebDriverWait wait=new WebDriverWait(driver,25);
	   		  	                  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
	   		  	                  String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
	   		  	                  System.out.println(atoastmessage);
	   		  	                  Thread.sleep(5000);
	   		  	                  ERforAppManagerFavAndDel.favoritesapppass(driver);
	   		  	                  driver.navigate().back();
	   		  	                  Thread.sleep(5000);
	   		  	                  appmanager.click();
	                              Thread.sleep(5000);
	   		  	                       try {
	   		  	                    	      verifyingfavoritesisavailable.click();
	  		  	                              Thread.sleep(5000);
	  		  	                              selectapp.click();
	  		                                  Thread.sleep(5000);
	  		                                  favoriteappselection.click();
	  		                                  WebDriverWait wait1=new WebDriverWait(driver,25);
	  		  	                              wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
	  		  	                              String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
	  		  	                              System.out.println(atoastmessage1);
	  		  	                              Thread.sleep(5000);
	  		  	                              ERforAppManagerFavAndDel.changefavoritesapppass(driver);
	  		  	                              driver.navigate().back();
	  		  	                              Thread.sleep(5000);
	  		  	                              appmanager.click();
	  		   		  	                      Thread.sleep(5000);
	   		  	                        }catch(Exception e) {
	        	        			          ERforAppManagerFavAndDel.changefavoritesappfail(driver); }
	  		  	                  
	        	        	 }catch(Exception e) {
	        	        			  ERforAppManagerFavAndDel.favoritesappfail(driver);}
	   		  	              try {

	        	            	  selectappfordelete.click();
	   		  	                  Thread.sleep(5000);
	   		  	                  deleteappselection.click();
	   		  	                  Thread.sleep(5000);
	   		  	                  deletecancelbutton.click();
			  	                  Thread.sleep(5000);
			  	                  selectappfordelete.click();
			  	                  Thread.sleep(5000);
			  	                  ERforAppManagerFavAndDel.deleteappcancelpass(driver);
	   		  	              }catch(Exception ex) {
	   		  	                  ERforAppManagerFavAndDel.deleteappcancelfail(driver);}
		  	        	      try {
		  	        	    	  deleteappselection.click();
			  	                  Thread.sleep(5000);
			  	                  deleteokbutton.click();
		                          Thread.sleep(5000);
	   		  	                  ERforAppManagerFavAndDel.deleteappokpass(driver);
	   		  	                  driver.navigate().back();
	   		  	                  Thread.sleep(5000);
	   		  	                  appmanager.click();
			  	                  Thread.sleep(5000);
		  	        	        }catch(Exception e) {
		  	        	        	ERforAppManagerFavAndDel.deleteappokfail(driver);
		  	        	        }
		  	        	  }else {
			              ERforAppManagerFavAndDel.listofusedorunusedappsfail(driver);  
			              }
		  	        	  try {
		  	        		   settingbuttonclick.isDisplayed();
		  	        	       settingclick.click();
	     		  	           ERforAppManagerFavAndDel.settingbuttonpass(driver);
	     		  	           Thread.sleep(5000);
	     		  	           try {
	     		                    String Sname=settingtab.getText();
	     		                    System.out.println(Sname);
	     		                    ERforAppManagerFavAndDel.automaticallyuninstallpass(driver);
	     		                    Thread.sleep(5000);
	     		                    try {
	     		                         settingcheckbox.click();
	     		                         Thread.sleep(5000);
	    		                         settingcheckbox.click();
	    		                         ERforAppManagerFavAndDel.checkboxenableanddisablepass(driver);
	     		                         Thread.sleep(5000);
	     		                         try {
	     		                              oneweek.isDisplayed();
	     		                              System.out.println("1 Week");
	     		                              Thread.sleep(5000);
	    		                              oneweek.click();
	     		                              Thread.sleep(5000);
	     		                              fifteendays.isDisplayed();
	     		                              System.out.println("15 Days");
	     		                              Thread.sleep(5000);
	   		                                  fifteendays.click();
	     		                              Thread.sleep(5000);
	     		                              onemonth.isDisplayed();
	     		                              System.out.println("1 Month");
	    		                              Thread.sleep(5000);
	    		                              onemonth.click();
	    		                              ERforAppManagerFavAndDel.optionspass(driver);
	    		                              Thread.sleep(5000);
	    		                              try {
	    		                            	  doneclick.click();
	    		                            	  ERforAppManagerFavAndDel.doneoptionspass(driver);
	    		           		                  Thread.sleep(10000);
	    		           		                       try {
	    		           		                         	settingbuttonclick.click();
	    		           	     		                    Thread.sleep(5000);
	    		           	     		                    WebElement toggle1 = onemonth;
	    		           	     		                    toggle1.isSelected();
	    		           	     		                    /*if (toggle1.isSelected()){
	    		           	     				            System.out.println("Item not Selected");
	    		           	     			   	            }else{        	     
	    		           	     			   		             System.out.println("Item  Selected");
	    		           	     			   	             }*/
	    		           	     		                     Thread.sleep(5000);
	    		           	     		                     ERforAppManagerFavAndDel.optionseletionverifivationpass(driver);
	    		           	     		                     doneclick.click();
	    		           	     		                     Thread.sleep(5000);
	    		           	     		                     driver.navigate().back();
	    		           	     		                     
	    		           		  	        	   
	    		           		                       }catch(Exception e) {
	    		           		                    	ERforAppManagerFavAndDel.optionseletionverifivationfail(driver);
	    		           		                    	doneclick.click();
	    		           		                    	Thread.sleep(5000);
	    		           		                    	driver.navigate().back();}
	    		     		                    }catch(Exception e) {
	    		     		                    	ERforAppManagerFavAndDel.doneoptionsfail(driver);
	    		     		                    	doneclick.click();
    		           		                    	Thread.sleep(5000);
    		           		                    	driver.navigate().back();}
	     		                         }catch(Exception e) {
	     		                        	ERforAppManagerFavAndDel.optionsfail(driver);
	     		                        	doneclick.click();
	           		                    	Thread.sleep(5000);
	           		                    	driver.navigate().back();}
	     		                   }catch(Exception e) {
	     		                	  ERforAppManagerFavAndDel.checkboxenableanddisablefail(driver);
	     		                	 doneclick.click();
        		                    	Thread.sleep(5000);
        		                    	driver.navigate().back();}
	     		              }catch(Exception e) {
	     		  	        	ERforAppManagerFavAndDel.automaticallyuninstallfail(driver);
	     		  	        	doneclick.click();
   		                    	Thread.sleep(5000);
   		                    	driver.navigate().back();}
	     		        }catch(Exception e) {
		  	        		ERforAppManagerFavAndDel.settingbuttonpassfail(driver);
		  	        		driver.navigate().back();
		  	        		Thread.sleep(5000);
		                    driver.navigate().back();}
		  	        }catch(Exception ex) {
	       	        	ERforAppManagerFavAndDel.headingsoflistappsfail(driver);
	       	        	Thread.sleep(5000);
	                    driver.navigate().back();}
			    }catch(Exception e){
			    	Thread.sleep(5000);
                    driver.navigate().back();
	   			ERforAppManagerFavAndDel.appmanagerfail(driver);
	   		}
			
		}
	    
	    
		@Test(priority=2)
	    public void appmanagerclick() throws Exception
	    {

	    	/* Open the Extent Report
	    	 * verifing splashscreens 
	         */
	    	
	    	
	       	/*Click on  Appmanager module to verify remove unsecure apps exist
	         * Remove unsecure apps - To delete the unsecure apps
	         * Great you don't have Unsecure Apps - message verification
	         */     try {
	    	        System.out.println("Del");
	    	        allowphones.click();
	    	        appmanager.click();  
				    Thread.sleep(5000);
				    exrremoveunsecureapps.exreportopen();
				    exrremoveunsecureapps.appmanagerpass(driver);
		  	        String esmname="Remove Unsecure Apps";
		  	        String asmname=removeunsecureapps.getText();
		  	        try
		  	        {     Thread.sleep(5000);
		  	              removeunsecureapps.isDisplayed();		     
		  	  	    }
		  	        catch(Exception ex)
		  	        {
		  		       acceptpermissionok.click();
		  			   redgreenoption.click();
		  			   permitusageaccess.click();
		  			}
		  	        try {
		  	        	  Thread.sleep(5000);
		  	        	  removeunsecureapps.click();
		  	        	  Thread.sleep(5000);
		  	        	  exrremoveunsecureapps.removeunsecurepass(driver);
	       	              try
	  		              {
	  		    	               unsecureappexistornot.isDisplayed();
	  		    	   			   List<AndroidElement> ua= driver.findElementsById("com.unfoldlabs.redgreen:id/fraudapp_name");
	  				               System.out.println("List Of Unsecure of App Count : " + ua.size());
	  				               Thread.sleep(5000);
	  				               for(int i = 0; i<ua.size();i++)
	  				               {
	  					                  System.out.println(ua.get(i).getText());	
	  					                Thread.sleep(5000);
	  				               }
	  				               exrremoveunsecureapps.unsecureappsdetails(driver);
	  				               int i=0;
	  			            	   while(i<ua.size())
	  				               {
	  				       	             
	  				     	             driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/fraudapps_delete']")).click();
	  				     	             Thread.sleep(5000);
	  				     	             unsecureappcanceltodelete.click();
	  				     	             Thread.sleep(5000);
	  				     	             driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/fraudapps_delete']")).click();
	  				     	             Thread.sleep(5000);
	  				     	             unsecureappdelete.click();
	  				     	             WebDriverWait wait=new WebDriverWait(driver,25);
		  	                             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		  	                             String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		  	                             System.out.println(atoastmessage);
	  				                     Thread.sleep(8000);
	  				     	             i++;
	  				     	       }
	  			            	   try
	  			            	   {     Thread.sleep(5000);
	  			            	   
	  			            		     noapps.isDisplayed();
	  			            		     Thread.sleep(5000);
	  			            		     exrremoveunsecureapps.cancelbuttonpass(driver);
	    			            		 exrremoveunsecureapps.allunsecureappsremoved(driver);
	    			            		 exrremoveunsecureapps.noappspass(driver);
	    			            		 driver.navigate().back();
	    			  		            	Thread.sleep(5000);
	    			    		             driver.navigate().back();
	  			            		     //unsecureappexistornot.isDisplayed();
	  			            	         //exrremoveunsecureapps.allunsecureappsremovedfailed(driver);
	  			            	   }
	  			            	   catch(Exception ex)
	  			            	   {
	  			            		 unsecureappexistornot.isDisplayed();
				            	     exrremoveunsecureapps.allunsecureappsremovedfailed(driver);
				            	     Thread.sleep(5000);
				            	     driver.navigate().back();
			  		            	 Thread.sleep(5000);
			    		             driver.navigate().back();
			    		             Thread.sleep(5000);
			    		             driver.navigate().back();
				            	     
	  			            	   }
	  			           }
	  		               catch(Exception ex)
	  		               {
	  		            	 exrremoveunsecureapps.allunsecureappsnotinstalled(driver);   
	  		            	 driver.navigate().back();
	  		            	 Thread.sleep(5000);
	    		             driver.navigate().back();
	  		               }
		 		    }
	       	        catch(Exception e)
	   	 		    {
	   	 		        exrremoveunsecureapps.removeunsecurefail(driver);
	   	 		    }
	         }catch(Exception es) {}
	   	} 
		@Test(priority=3)
	    public void speedboosteropen() throws Exception
		{
			/*Splash screen validating and click got it button and moving to allows RedGreen access photos, media and files on your device
			    * Allows RedGreen access photos, media 
			    * Allows RedGreen access phone Calls */
	    	   
				exrrunspeedbooster.exreportopen();
				try
				{  System.out.println("Speed"); allowphones.click();
					Speedbooster.isDisplayed();
		            Speedbooster.click();		
			        exrrunspeedbooster.speedboosteropen(driver);
			          
			          // Autosync functionality disabled 
			          try
			          {
			        	  Thread.sleep(5000);
		                  Disableautosync.isDisplayed();
		                  Thread.sleep(5000);
		                  try
		                  {
		                	  Disableautosync.click();
				              Thread.sleep(5000);
			                  Permissionno.click();
				              exrrunspeedbooster.disableautosyncpermissionno(driver);
				              Thread.sleep(5000);
				              Disableautosync.click();
				              Thread.sleep(5000);
				              Permissionyes.click();
				              WebDriverWait wait=new WebDriverWait(driver,25);
				              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
				              String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
				              System.out.println(atoastmessage);           
		                      Thread.sleep(5000);
				              driver.navigate().back();
				              Thread.sleep(5000);
				              driver.navigate().back();
				              Thread.sleep(5000);
				              Speedbooster.click();
				              Thread.sleep(5000);
				              Enableautosync.isDisplayed();
			                  Thread.sleep(5000);
			                  exrrunspeedbooster.enableautosyncdisplayed(driver);
			                  Thread.sleep(5000);
			                  
		                  }
		                  catch(Exception e)
		                  {
		                	  exrrunspeedbooster.enableautosyncnotfound(driver);  
		                  }
			          }
			          catch(Exception e)
			          {
			        	  exrrunspeedbooster.disableautosyncfail(driver);
			          }
				
				/*WIFi disabled in device*/
				try
				{
					
					Thread.sleep(5000);
		 		    Disablewifi.isDisplayed();
		 		    Thread.sleep(5000);
		 		    try
		 		    {
		 		    	Disablewifi.click();
				        Thread.sleep(5000);
				        Disablewifino.click();
				        exrrunspeedbooster.disablewifipermissionno(driver);
				        Thread.sleep(5000);
				        Disablewifi.click();
				        Thread.sleep(5000);
				        Disablewifiyes.click();
				        WebDriverWait wait=new WebDriverWait(driver,25);
		                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		                String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		                System.out.println(atoastmessage);
				        driver.navigate().back();
				        Thread.sleep(5000);
				        Speedbooster.click();
			            Thread.sleep(5000);
			   	        exrrunspeedbooster.disablewifi(driver);		   	        
		 		    }
		 		    catch(Exception e)
		 		    {
		 		    	exrrunspeedbooster.disablewifinotclicked(driver);;
					    Thread.sleep(5000);
		 		    } 		    
				}
				catch(Exception e)
				{
					exrrunspeedbooster.disablewififail(driver);
				}
				
				// Disable device location
				try
				{
					Thread.sleep(5000);
			        Disablelocation.isDisplayed();
			        Thread.sleep(5000);
			        try
			        {
			        	Disablelocation.click();
			        	Thread.sleep(5000);
			        	Disablelocationno.click();
			        	exrrunspeedbooster.disablelocationpermissionno(driver);
			        	Thread.sleep(5000);
			        	Disablelocation.click();
			        	Thread.sleep(5000);
			        	Disablelocationyes.click();
			        	try
			        	{
			        		Disablelocation.isDisplayed();
			        		Thread.sleep(5000);
			        		Disablelocation.click();
				        	Thread.sleep(5000);
				        	Disablelocationyes.click();
				        	
			        		WebDriverWait wait=new WebDriverWait(driver,25);
			                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
			                String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
			                System.out.println(atoastmessage);
			                exrrunspeedbooster.disablelocation(driver);
			        	}catch(Exception e)
			        	{
			        		try {		        	
			        		Disablelocationoff.click();	
			        		Thread.sleep(5000);
			        	    driver.navigate().back();
			        		Thread.sleep(5000);
			        		Disablelocation.click();
			        		Thread.sleep(5000);
			        		Disablelocationyes.click();
			        		WebDriverWait wait1=new WebDriverWait(driver,25);
			                wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
			                String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
			                System.out.println(atoastmessage1);
			        		driver.navigate().back();
			        		Thread.sleep(5000);
			        		Speedbooster.click();
			        		Thread.sleep(5000);	        		
			        	    exrrunspeedbooster.disablelocation(driver);    
			        		}catch(Exception ex) {
			        			exrrunspeedbooster.disablelocationfail(driver);
			        		}
			        		
			        	}	        	  
			        }
			        catch(Exception e)
			        {
			        	exrrunspeedbooster.disablelocationfail(driver);
			        }
				}
				catch(Exception e)
				{
					exrrunspeedbooster.disablelocationfail(driver);
				}
				
				// Checking for device Update
				try
				{
					Updatedevice.isDisplayed();
		        	Thread.sleep(5000);
		        	try
		        	{
		        		Updatedevice.click();
		        		Thread.sleep(5000);
		        		Updatedeviceno.click();
		        		exrrunspeedbooster.updatedevicepermissionno(driver);
		        		Thread.sleep(5000);
		        		Updatedevice.click();
		        		Thread.sleep(5000);
		        		Updatedeviceyes.click();
		        		Thread.sleep(5000);
		        	    Updatecheck.click();
		        		Thread.sleep(5000);
		        		driver.navigate().back();
		        		Thread.sleep(5000);
		        		driver.navigate().back();
		        		Thread.sleep(5000);
		        	    Speedbooster.click();
		        	    Thread.sleep(5000);
		        		exrrunspeedbooster.updatedevice(driver);
		        	}
		        	catch(Exception e)
		        	{
		        		exrrunspeedbooster.updatedevicenotfound(driver);
		        		Thread.sleep(10000);
		        	}
				}
				catch(Exception e)
				{
					exrrunspeedbooster.updatedevicefail(driver);
		        	Thread.sleep(10000);
				}
				
			    // Scrolldown in the application
				
				WebElement we=driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/scrollview']"));
		        Dimension d1 =we.getSize();
		        //System.out.print(d1);
		        int start_x=(int) (d1.width * 0.5);
		        int start_y=(int) (d1.height * 0.8);
		        int end_x=(int) (d1.width * 0.5);
		        int end_y=(int) (d1.height * 0.1);
		        TouchAction ta=new TouchAction(driver);
		        ta.press(PointOption.point(start_x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x,end_y)).release().perform();
		        exrrunspeedbooster.touchactions(driver);
		        
		       // Blocking Device Notifications
		        try
		        {
		        	Notificationblock.isDisplayed();
		        	Thread.sleep(5000);
		        	Notificationblock.click();
		        	Thread.sleep(5000);
		        	permissionno.click();
		        	exrrunspeedbooster.notficationsblockno(driver);
		        	Thread.sleep(5000);
		        	Notificationblock.click();
		        	Thread.sleep(5000);
		        	permissionyes.click();
		        	Thread.sleep(5000);
		        	Notificationoff.click();
		        	try
		        	{
		        		permissionallow.click();
		        		Thread.sleep(20000);
		        	}
		        	catch(Exception e)
		        	{
		        		  System.out.println("notification permission not given");
		            }  
		        	exrrunspeedbooster.notficationsblock(driver);	
		        }
		        catch(Exception ex)
		        {
		        	exrrunspeedbooster.notificationblockfail(driver);
		        }
		        
		        driver.navigate().back();
		        Thread.sleep(5000);
		        driver.navigate().back();
		        Speedbooster.click();
		        
		       // Scrolldown in the application
		        
		        WebElement we1=driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/scrollview']"));
		        Dimension d2 =we1.getSize();
		       // System.out.print(d2);
		        int start_x1=(int) (d2.width * 0.5);
		        int start_y1=(int) (d2.height * 0.8);
		        int end_x1=(int) (d2.width * 0.5);
		        int end_y1=(int) (d2.height * 0.1);
		        TouchAction ta1=new TouchAction(driver);
		        ta1.press(PointOption.point(start_x1,start_y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x1,end_y1)).release().perform();
		        exrrunspeedbooster.touchactions(driver);
		        
		       // Cleahuphomescreen Functionaity
		        try
		        {
		        	  cleanuphomescreen.isDisplayed();
		        	  Thread.sleep(5000);
		        	  cleanuphomescreen.click();
		        	  Thread.sleep(5000);
		        	  popupno.click();
		        	  exrrunspeedbooster.cleanhomeappsno(driver);
		        	  Thread.sleep(5000);
		        	  cleanuphomescreen.click();
		        	  Thread.sleep(5000);
		        	  popupyes.click();
		        	  WebDriverWait wait=new WebDriverWait(driver,25);
		              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		              String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		              System.out.println(atoastmessage);
		        	  Thread.sleep(10000);
		        	  driver.activateApp("com.unfoldlabs.redgreen");
		        	  exrrunspeedbooster.cleanhomeapps(driver);
		        	  Thread.sleep(5000);
		        	  driver.navigate().back();
		        	  Speedbooster.click();
		        	  Thread.sleep(5000);
		        	  WebElement we2=driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/scrollview']"));
		        	  Dimension d3 =we2.getSize();
		        	  //System.out.print(d3);
		        	  int start_x2=(int) (d3.width * 0.5);
		        	  int start_y2=(int) (d3.height * 0.8);
		        	  int end_x2=(int) (d3.width * 0.5);
		        	  int end_y2=(int) (d3.height * 0.1);
		        	  TouchAction ta2=new TouchAction(driver);
		        	  ta2.press(PointOption.point(start_x2,start_y2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x2,end_y2)).release().perform();
		        	  exrrunspeedbooster.touchactions(driver);
		        }
		        catch(Exception ex)
		        {
		        	exrrunspeedbooster.cleanuphomeappfail(driver);
		        }
		        
		        // Restricting Device Hotspot
		        try
		        {
		        	Restricthotspot.isDisplayed();	 
	        	    Thread.sleep(5000);
	        	    Restricthotspot.click();
	        	    Thread.sleep(5000);
	        	    Restricthotspotpermissionno.click();
	        	    exrrunspeedbooster.restricthotspotno(driver);
	        	    Thread.sleep(5000);
	        	    Restricthotspot.click();
	        	    Thread.sleep(5000);
	        	    Restricthotspotpermissionyes.click();
	        	    Thread.sleep(5000);
	        	    driver.navigate().back();
	        	    Thread.sleep(5000);
	        	    driver.navigate().back();
	        	    Thread.sleep(5000);
	        	    exrrunspeedbooster.restricthotspot(driver);
	        	    Thread.sleep(5000);
	        	    
		        }
		        catch(Exception ex)
		        {
		        	exrrunspeedbooster.hotspotrestirctfail(driver);
		        }
		    }
		    catch(Exception e)
		    {
			   exrrunspeedbooster.speedboosternotfound(driver);
			   Thread.sleep(5000);
		    }
				
				
		 }

		@Test(priority=4)
	    public void savebatteryclick() throws Exception, InterruptedException, MalformedURLException
	    {

	    	/* Open the Extent Report
	    	 * verifing splashscreens 
	         */
	    	System.out.println("Save");
	    	ERforSaveBattery.exreportopen();
	    	ERforSaveBattery.redgreenappopen(driver);
	    	Thread.sleep(10000);
	    	gotit.click();
	    	Thread.sleep(5000);
	    	ERforSaveBattery.splashscreenverification(driver);
	    	Thread.sleep(5000);
	       	allowphotosandmedia.click();
	       	Thread.sleep(5000);
	       	allowphones.click();
	       	Thread.sleep(8000);

	    	
	       	
	       	/*Click on  Appmanager module to verify remove unsecure apps exist
	         * Remove unsecure apps - To delete the unsecure apps
	         * Great you don't have Unsecure Apps - message verification
	         */
	       	
			try {System.out.println("Save");allowphones.click();
				savebattery.isDisplayed();
				savebattery.click();  
				ERforSaveBattery.savebatterypass(driver);
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
		  	        	 ERforSaveBattery.remainingbatterypass(driver);
		  	        	 Thread.sleep(5000);
		  	        }catch(Exception e){
		  	        	ERforSaveBattery.remainingbatteryfail(driver);
		  	        }  
		  	        try {
		  	        	    systemappsname.isDisplayed();
		  	        	  Thread.sleep(5000);
		  	        	    ERforSaveBattery.systemappsspass(driver);
		  	        	    Thread.sleep(5000);
		  	        	    try {
		  	        		    systemappinfo.isDisplayed();
		  	        		  Thread.sleep(5000);
		  	        		    String s=systemappinfo.getText();
		  	        		    System.out.println("System App Info :" +s);
		  	        		  Thread.sleep(5000);
		  	        		    ERforSaveBattery.systemappinfopass(driver);
		  	        		    Thread.sleep(5000);
		  	        	    }catch(Exception e){
		  	        		    ERforSaveBattery.systemappinfofail(driver);}
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
		  	        	       ERforSaveBattery.alloptimizationinfopass(driver);
		  	        	       Thread.sleep(5000);
		  	        	    }catch(Exception e) {
		  	        		   ERforSaveBattery.alloptimizationinfofail(driver);
		  	        		 Thread.sleep(5000);
			  	        	   driver.navigate().back();
			  	        	 Thread.sleep(5000);
			  	        	   driver.navigate().back();}
		  	        	}catch(Exception ex) {
		  	        		ERforSaveBattery.alloptimizationinfofail(driver);
		  	        		Thread.sleep(5000);
		  	        		driver.navigate().back();
		  	        		Thread.sleep(5000);
		  	        		driver.navigate().back();
		  	        	}
		  	        	try{
		  	        		savebattery.click();
		  	        		cpucoolername.isDisplayed();
			  	        	ERforSaveBattery.cpucoolerpass(driver);
			  	        	Thread.sleep(5000);
			  	        	try {
			  	        		Thread.sleep(5000);
			  	        		cpucoolerinfo.isDisplayed();
			  	        		String s=cpucoolerinfo.getText();
			  	        		Thread.sleep(5000);
			  	        		System.out.println("CPU App Info :" +s);
			  	        		ERforSaveBattery.cpucoolerinfopass(driver);
			  	        		Thread.sleep(5000);
			  	        		cpucoolername.click();
			  	        		Thread.sleep(5000);
			  	        	}catch(Exception e) {
			  	        		ERforSaveBattery.cpucoolerinfofail(driver);}
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
			  	        		ERforSaveBattery.cpucoolercancelpass(driver);
			  	        	}catch(Exception e){
			  	        		ERforSaveBattery.cpucoolercancelfail(driver);
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        	}
			  	        	try {
			  	        		Thread.sleep(5000);
			  	        		cpucoolername.click();
			  	        		Thread.sleep(5000);
			  	        		cpucoolerpopup.isDisplayed();
			  	        		Thread.sleep(5000);
			  	        		cpucoolerpopupok.click();
			  	        		Thread.sleep(5000);
			  	        		ERforSaveBattery.cpucoolerokpass(driver);
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        	}catch(Exception e){
			  	        		ERforSaveBattery.cpucoolerokfail(driver);
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        		Thread.sleep(5000);
			  	        		driver.navigate().back();
			  	        	}
		  	        }catch(Exception e) {
		  	        	ERforSaveBattery.cpucoolerfail(driver);
		  	        }	  	        
			    }catch(Exception e){
	   			  ERforSaveBattery.savebatteryfail(driver);
	   		}
			
			
		}
		@Test(priority=5)
	    public void AppLockPinSetupWithpermissionclick() throws Exception 
	    {
			exrapplockwithpermissions.exreportopen();
			Thread.sleep(5000);
			try {System.out.println("Applockpin");allowphones.click();
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
		

			try {System.out.println("Change");allowphones.click();
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				exrapplockchangepassword.applockclickpass(driver);

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
					Thread.sleep(5000);
					unlockapp.click();
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
			try {System.out.println("forgot");allowphones.click();
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				exrapplockforgotpassword.applockclickpass(driver);

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
			
		}
		@Test(priority=8)
	    public void Preferencesclickpass() throws Exception {

			exrrunsettings.exreportopen();
			Thread.sleep(10000);
	    	gotit.click();
	    	Thread.sleep(5000);
	    	allowphoto.click();
			Thread.sleep(5000);
			allowphone.click();
			Thread.sleep(5000);
			

			WebElement drag = driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
			Dimension d1 = drag.getSize();
			int start_x = (int) (d1.width * 0.5);
			int start_y = (int) (d1.height * 0.8);
			int end_x = (int) (d1.width * 0.5);
			int end_y = (int) (d1.height * 0.1);
			TouchAction ta = new TouchAction(driver);
			ta.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(end_x, end_y)).release().perform();

			try {
				SettingsPreference.isDisplayed();
				Thread.sleep(5000);
				SettingsPreference.click();
				Thread.sleep(5000);
				exrrunsettings.Preferenceslickpass(driver);
			} catch (Exception e) {
				exrrunsettings.Preferencesnotfound(driver);
			}

			// Automatically Lock apps on install toggle button
			try {
				driver.findElement(By.xpath("//*[contains(@text,'Automatically')]")).isDisplayed();

				try {
					String s = driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked");
					Thread.sleep(5000);
					exrrunsettings.AutomaticallyLockappsoninstallnotenable(driver);

					System.out.println("Automatically Lock apps on install toggle button is Enabled ");
					Thread.sleep(5000);

				} catch (Exception ex) {
					System.out.println("Automatically Lock apps on install toggle button is Disabled");
					exrrunsettings.Togglebuttonenablefailed(driver);
				}

				try {
					driver.findElement(By.xpath("(//*[@checked='true'])[1]")).click();

					String sap = driver.findElement(By.xpath("//*[contains(@text,'Password to enable')]")).getText();

					System.out.println("App Msg :" + sap);
					Thread.sleep(5000);

					driver.findElement(By.xpath("//*[@text='OK']")).click();

					try {
						driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked").equals("false");
						System.out.println("Toggle button is disbled");
						Thread.sleep(5000);
					} catch (Exception ex) {
						System.out.println("Fail cond for Automatically name not displaying");
						exrrunsettings.AutomaticallyLockappsoninstalloff(driver);
					}

				} catch (Exception e) {
					System.out.println("Toggle button not displaying");
					exrrunsettings.AutomaticallyLockappsoninstallnotfound(driver);
				}

			} catch (Exception e) {
				// Fail cond for Automatically name not displaying
				System.out.println("Fail cond for Automatically name not displaying");
			}

			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);

			WebElement drag2 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[4]"));
			Dimension d3 = drag.getSize();
			int start_x2 = (int) (d1.width * 0.5);
			int start_y2 = (int) (d1.height * 0.2);
			int end_x2 = (int) (d1.width * 0.5);
			int end_y2 = (int) (d1.height * 0.8);
			TouchAction ta2 = new TouchAction(driver);
			ta2.press(PointOption.point(start_x2, start_y2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(end_x2, end_y2)).release().perform();
			Thread.sleep(5000);

			// applock settings
			try {
				applock.isDisplayed();
				applock.click();
				Thread.sleep(5000);
				exrrunsettings.applockclickpass(driver);

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
					exrrunsettings.applockpermissionspass(driver);

				} catch (Exception ex) {
					vysorlock.isDisplayed();

				}

				try {
					vysorlock.click();
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(5000);
					}
					nextbutton.click();
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(5000);
					}
					nextbutton.click();
					allowpermission.click();
					Thread.sleep(5000);
					email.sendKeys("deepthik@ctrlaltfix.co");
					Thread.sleep(5000);
					emaildone.click();
					Thread.sleep(5000);
					exrrunsettings.pinsetuppass(driver);
					Thread.sleep(10000);
					driver.navigate().back();
					Thread.sleep(5000);
					try {
						SettingsPreference.isDisplayed();
						Thread.sleep(5000);
						SettingsPreference.click();
						Thread.sleep(5000);
						exrrunsettings.Preferenceslickpass(driver);
					} catch (Exception e) {
						exrrunsettings.Preferencesnotfound(driver);
					}

					try {
						driver.findElement(By.xpath("//*[contains(@text,'Automatically')]")).isDisplayed();

						try {
							String s = driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked");
							Thread.sleep(5000);
							exrrunsettings.AutomaticallyLockappsoninstallnotenable(driver);

							System.out.println("Toggle button is Enabled ");
							Thread.sleep(5000);
						} catch (Exception ex) {
							// System.out.println("");
							exrrunsettings.AutomaticallyLockappsoninstallnotfound(driver);

						}

						try {
							driver.findElement(By.xpath("(//*[@checked='true'])[1]")).click();

							System.out.println("Toggle button is disbled");
							Thread.sleep(5000);
							try {
								driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked")
										.equals("false");
								System.out.println("Toggle button is disble");
								Thread.sleep(5000);
								try {
									togglebuttonon.isDisplayed();
									Thread.sleep(5000);
									togglebuttonon.click();
									Thread.sleep(5000);
									driver.navigate().back();
									Thread.sleep(5000);

								} catch (Exception ex) {
									exrrunsettings.Togglebuttonfailed(driver);

								}
							} catch (Exception ex) {
								driver.findElement(By.xpath("//*[@text='OK']")).click();
								Thread.sleep(5000);
								System.out.println("Fail cond for Automatically name not displaying");
								exrrunsettings.AutomaticallyLockappsoninstalloff(driver);
							}

						} catch (Exception e) {
							Thread.sleep(5000);
							System.out.println("Toggle not displaying");
							exrrunsettings.AutomaticallyLockappsoninstallnotfound(driver);
						}

					} catch (Exception e) {
						// Fail cond for Automatically name not displaying
						System.out.println("Fail cond for Automatically name not displaying");
					}

				} catch (Exception ex) {
					System.out.println("Fail cond for Automatically name not displaying");

				}

			} catch (Exception ex) {
				exrrunsettings.pinsetupfail(driver);
				System.out.println("Fail cond for Automatically name not displaying");

			}

			WebElement drag1 = driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
			Dimension d2 = drag.getSize();
			int start_x1 = (int) (d1.width * 0.5);
			int start_y1 = (int) (d1.height * 0.8);
			int end_x1 = (int) (d1.width * 0.5);
			int end_y1 = (int) (d1.height * 0.1);
			TouchAction ta1 = new TouchAction(driver);
			ta1.press(PointOption.point(start_x1, start_y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(end_x1, end_y1)).release().perform();

			try {
				SettingsPreference.isDisplayed();
				Thread.sleep(5000);
				SettingsPreference.click();
				Thread.sleep(5000);
				exrrunsettings.Preferenceslickpass(driver);
			} catch (Exception e) {
				exrrunsettings.Preferencesnotfound(driver);
			}

			// Tutorial Functionality checking

			try {
				Tutorials.isDisplayed();
				Thread.sleep(5000);
				Tutorials.click();
				Thread.sleep(5000);
				exrrunsettings.Tutorialsoff(driver);
				Thread.sleep(5000);
				try {
					Tutorials.click();
					Thread.sleep(5000);
					exrrunsettings.Tutorialson(driver);
					Thread.sleep(5000);
					driver.navigate().back();

				} catch (Exception e) {
					exrrunsettings.Tutorialsfail(driver);
				}

			} catch (Exception e) {
				exrrunsettings.Tutorialsfail(driver);
			}
			Thread.sleep(5000);

			// Rate us on google play

			try {
				Rateusongoogleplay.isDisplayed();
				Thread.sleep(5000);
				Rateusongoogleplay.click();
				Thread.sleep(5000);
				exrrunsettings.Rateusongoogleplaypass(driver);
				Thread.sleep(10000);
				//WebElement we = driver.findElement(By.xpath("//*[@class='android.view.View']"));
				WebElement we = driver.findElement(By.xpath("(//*[@class='android.support.v7.widget.RecyclerView'])[1]"));
				Dimension d4 = we.getSize();
				int start_x4 = (int) (d1.width * 0.5);
				int start_y4 = (int) (d1.height * 0.8);
				int end_x4 = (int) (d1.width * 0.5);
				int end_y4 = (int) (d1.height * 0.1);
				TouchAction ta4 = new TouchAction(driver);
				ta4.press(PointOption.point(start_x4, start_y4)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(end_x4, end_y4)).release().perform();
				exrrunsettings.touchactions(driver);
				Thread.sleep(5000);
				driver.navigate().back();
			} catch (Exception e) {
				exrrunsettings.Rateusongoogleplayfail(driver);
				driver.navigate().back();
			}

			// Recommned us for select Meassges
			try {
				Recommendus.isDisplayed();
				Thread.sleep(5000);
				Recommendus.click();
				Thread.sleep(5000);
				exrrunsettings.Recommenduspass(driver);
				Thread.sleep(5000);
				try {
					Thread.sleep(10000);
					Messages.click();
					Thread.sleep(5000);
					exrrunsettings.Messagespass(driver);
					Thread.sleep(5000);
					try {
						// Newmessages.isDisplayed();
						Thread.sleep(10000);
						Newmessages.click();
						Thread.sleep(5000);
						exrrunsettings.NewMessagespass(driver);
						Thread.sleep(5000);
						try {
							driver.findElement(By
									.xpath("//*[@resource-id='com.google.android.apps.messaging:id/recipient_text_view']"))
									.sendKeys("9121414017");

							((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

							Thread.sleep(5000);

							driver.findElement(By.xpath(
									"//*[@resource-id='com.google.android.apps.messaging:id/send_message_button_icon']"))
									.click();
							driver.navigate().back();
							Thread.sleep(5000);
							driver.navigate().back();
							Thread.sleep(5000);
						} catch (Exception e) {
							exrrunsettings.Sendbuttonfail(driver);
							Thread.sleep(5000);
						}

					} catch (Exception e) {
						exrrunsettings.NewMessagesfail(driver);
						Thread.sleep(5000);
					}

				} catch (Exception e) {
					exrrunsettings.Messagesfail(driver);
					Thread.sleep(5000);
				}
			} catch (Exception e) {
				exrrunsettings.Recommendusfail(driver);
				Thread.sleep(5000);
			}

			// Recommened us functionality for gmail

			try {
				Recommendus.isDisplayed();
				Thread.sleep(5000);
				Recommendus.click();
				Thread.sleep(5000);
				exrrunsettings.Recommenduspass(driver);
				Thread.sleep(5000);
				try {
					Gmail.isDisplayed();
					Gmail.click();
					Thread.sleep(5000);
					try {
						Toselect.isDisplayed();
						Toselect.click();
						Thread.sleep(5000);
						Toselect.sendKeys("deepthik@ctrlaltfix.co");
						Thread.sleep(5000);
						try {
							Sendbutton.isDisplayed();
							Sendbutton.click();

						} catch (Exception e) {
							exrrunsettings.Sendbuttonfail(driver);
							Thread.sleep(5000);
						}

					} catch (Exception e) {
						exrrunsettings.Toselectfail(driver);
						Thread.sleep(5000);
					}

				} catch (Exception e) {
					exrrunsettings.Gmailselectfail(driver);
					Thread.sleep(5000);
				}

			} catch (Exception e) {
				exrrunsettings.Recommendusfail(driver);
				Thread.sleep(5000);
			}

			// Recommend us copy clipboard

			try {
				Recommendus.isDisplayed();
				Thread.sleep(5000);
				Recommendus.click();
				Thread.sleep(5000);
				exrrunsettings.Recommenduspass(driver);
				Thread.sleep(5000);
				try {
					Clipboard.isDisplayed();
					Thread.sleep(5000);
					Clipboard.click();
					WebDriverWait wait = new WebDriverWait(driver, 25);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage);
					exrrunsettings.Clipboardpass(driver);
					Thread.sleep(5000);

				} catch (Exception e) {
					exrrunsettings.Clipboardbuttonfail(driver);
					Thread.sleep(5000);
				}

			} catch (Exception e) {
				exrrunsettings.Recommendusfail(driver);
				Thread.sleep(5000);
			}

			// Recommened us save to drive
			try {
				Recommendus.isDisplayed();
				Thread.sleep(5000);
				Recommendus.click();
				Thread.sleep(5000);
				exrrunsettings.Recommenduspass(driver);
				Thread.sleep(5000);
				try {
					Savetodrive.isDisplayed();
					Thread.sleep(5000);
					Savetodrive.click();
					Thread.sleep(5000);
					exrrunsettings.Savepass(driver);
					Thread.sleep(5000);
					try {
						Documenttitle.isDisplayed();
						Thread.sleep(5000);
						Documenttitle.click();
						Thread.sleep(5000);
						exrrunsettings.Documenttittlepass(driver);
						Thread.sleep(5000);
						try {
							Savebutton.isDisplayed();
							Thread.sleep(5000);
							Savebutton.click();
							WebDriverWait wait = new WebDriverWait(driver, 25);
							wait.until(ExpectedConditions
									.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
							String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast"))
									.getText();
							System.out.println(atoastmessage);
							exrrunsettings.Savepass(driver);
							Thread.sleep(5000);
						} catch (Exception e) {
							exrrunsettings.Savebuttonfail(driver);
							Thread.sleep(5000);
						}

					} catch (Exception e) {
						exrrunsettings.Documenttittlebuttonfail(driver);
						Thread.sleep(5000);
					}

				} catch (Exception e) {
					exrrunsettings.Clipboardbuttonfail(driver);
					Thread.sleep(5000);
				}

			} catch (Exception e) {
				exrrunsettings.Recommendusfail(driver);
				Thread.sleep(5000);
			}
			WebElement drag3 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[4]"));
			Dimension d4 = drag.getSize();
			int start_x3 = (int) (d1.width * 0.5);
			int start_y3 = (int) (d1.height * 0.2);
			int end_x3 = (int) (d1.width * 0.5);
			int end_y3 = (int) (d1.height * 0.8);
			TouchAction ta3 = new TouchAction(driver);
			ta3.press(PointOption.point(start_x3, start_y3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(end_x3, end_y3)).release().perform();
			Thread.sleep(5000);
			/*exrrunsettings.exreportclose();
			exrremoveunsecureapps.exreportclose();
	  	    ERforAppManagerFavAndDel.exreportclose();
	  	    exrrunspeedbooster.exreportclose();
			ERforSaveBattery.exreportclose();
			exrapplockwithpermissions.exreportclose();
			exrapplockchangepassword.exreportclose();
			exrapplockforgotpassword.exreportclose();*/


		}

	    public void closeapp() throws Exception
	    {
	    		
	    	
	    	Thread.sleep(5000);
	        driver.closeApp();
	        Thread.sleep(10000);
            //Stop the Server
	        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	        Thread.sleep(10000);
	  
	    }
	    public void closeappandserver() throws Exception
	    {
	    		
	    	
	    	Thread.sleep(5000);
	        driver.closeApp();
	        Thread.sleep(10000);
	        //Stop the Server
	        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	    }
}
