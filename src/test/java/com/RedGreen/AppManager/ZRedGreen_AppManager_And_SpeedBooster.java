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

public class ZRedGreen_AppManager_And_SpeedBooster 
{
	 AndroidDriver<AndroidElement> driver;
	    
	    public ZRedGreen_AppManager_And_SpeedBooster(AndroidDriver<AndroidElement> driver)
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
		
		ExtentReportForSpeedBooster ESpeedBooster= new ExtentReportForSpeedBooster();
	    ExtentReportforAppManagerFavAndDel ERforAppManagerFavAndDel = new ExtentReportforAppManagerFavAndDel();
	    ExtentReportforRemoveUnsecureApps ERemoveUnsecureApps = new ExtentReportforRemoveUnsecureApps();
	    
		@Test(priority=1)
	    public void appmanagerfavdelclick() throws Exception, InterruptedException, MalformedURLException
	    {

	    	/* Open the Extent Report
	    	 * Verifying splashscreens 
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
	       	
	       	try {
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
					                     Thread.sleep(3000);}
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
	        	        		  Thread.sleep(3000);
	   		                      favoriteappselection.click();
	   		                      WebDriverWait wait=new WebDriverWait(driver,25);
	   		  	                  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
	   		  	                  String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
	   		  	                  System.out.println(atoastmessage);
	   		  	                  Thread.sleep(3000);
	   		  	                  ERforAppManagerFavAndDel.favoritesapppass(driver);
	   		  	                  driver.navigate().back();
	   		  	                  Thread.sleep(3000);
	   		  	                  appmanager.click();
	                              Thread.sleep(3000);
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
	  		  	                              Thread.sleep(3000);
	  		  	                              ERforAppManagerFavAndDel.changefavoritesapppass(driver);
	  		  	                              driver.navigate().back();
	  		  	                              Thread.sleep(3000);
	  		  	                              appmanager.click();
	  		   		  	                      Thread.sleep(3000);
	   		  	                        }catch(Exception e) {
	        	        			          ERforAppManagerFavAndDel.changefavoritesappfail(driver); }
	  		  	                  
	        	        	 }catch(Exception e) {
	        	        			  ERforAppManagerFavAndDel.favoritesappfail(driver);}
	   		  	              try {

	        	            	  selectappfordelete.click();
	   		  	                  Thread.sleep(3000);
	   		  	                  deleteappselection.click();
	   		  	                  Thread.sleep(3000);
	   		  	                  deletecancelbutton.click();
			  	                  Thread.sleep(3000);
			  	                  selectappfordelete.click();
			  	                  Thread.sleep(3000);
			  	                  ERforAppManagerFavAndDel.deleteappcancelpass(driver);
	   		  	              }catch(Exception ex) {
	   		  	                  ERforAppManagerFavAndDel.deleteappcancelfail(driver);}
		  	        	      try {
		  	        	    	  deleteappselection.click();
			  	                  Thread.sleep(3000);
			  	                  deleteokbutton.click();
		                          Thread.sleep(3000);
	   		  	                  ERforAppManagerFavAndDel.deleteappokpass(driver);
	   		  	                  driver.navigate().back();
	   		  	                  Thread.sleep(3000);
	   		  	                  appmanager.click();
			  	                  Thread.sleep(3000);
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
	     		  	           Thread.sleep(3000);
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
	     		                              Thread.sleep(3000);
	    		                              oneweek.click();
	    		                              System.out.println("1 Week");
	    		                              Thread.sleep(3000);
	     		                              fifteendays.isDisplayed();
	     		                              Thread.sleep(3000);
	   		                                  fifteendays.click();
	   		                                  System.out.println("15 Days");
	   		                                  Thread.sleep(3000);
	     		                              onemonth.isDisplayed();
	     		                              Thread.sleep(3000);
	    		                              onemonth.click();
	    		                              System.out.println("1 Month");
	    		                              ERforAppManagerFavAndDel.optionspass(driver);
	    		                              Thread.sleep(3000);
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
	    		           	     		                     Thread.sleep(3000);
	    		           	     		                     ERforAppManagerFavAndDel.optionseletionverifivationpass(driver);
	    		           	     		                     doneclick.click();
	    		           	     		                     Thread.sleep(3000);
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
	    public void removeunsecureappsclick() throws Exception
	    {

	    	/* Open the Extent Report
	    	 * verifing splashscreens 
	         */
	    	
	    	
	       	/*Click on  Appmanager module to verify remove unsecure apps exist
	         * Remove unsecure apps - To delete the unsecure apps
	         * Great you don't have Unsecure Apps - message verification
	         */     try {
	        	    Thread.sleep(5000);
	    	        appmanager.click();  
				    Thread.sleep(3000);
				    ERemoveUnsecureApps.exreportopen();
				    ERemoveUnsecureApps.appmanagerpass(driver);
		  	        /*try
		  	        {     Thread.sleep(5000);
		  	              removeunsecureapps.isDisplayed();		     
		  	  	    }
		  	        catch(Exception ex)
		  	        {
		  		       acceptpermissionok.click();
		  			   redgreenoption.click();
		  			   permitusageaccess.click();
		  			}*/
		  	        try {
		  	        	  removeunsecureapps.click();
		  	        	  Thread.sleep(3000);
		  	        	  ERemoveUnsecureApps.removeunsecurepass(driver);
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
	  				               ERemoveUnsecureApps.unsecureappsdetails(driver);
	  				             int i=0;
	  				               int count= ua.size();
	  			            	   while(i<ua.size())
	  				               {
	  			            		 if(count==3)
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
	  				     	             count--;}
	  				     	            else {
	  				     	            	 driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/fraudapps_delete']")).click();
	  	  				     	             Thread.sleep(5000);
	  					     	             unsecureappdelete.click();
	  					     	             WebDriverWait wait=new WebDriverWait(driver,25);
			  	                             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
			  	                             String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
			  	                             System.out.println(atoastmessage);
	  	  				                     Thread.sleep(5000);
	  	  				     	             i++;
	  				     	            }
	  				       	             
	  				     	       }
	  			            	   try
	  			            	   {     Thread.sleep(3000);
	  			               		     noapps.isDisplayed();
	  			            		     Thread.sleep(5000);
	  			            		     ERemoveUnsecureApps.cancelbuttonpass(driver);
	    			            		 ERemoveUnsecureApps.allunsecureappsremoved(driver);
	    			            		 ERemoveUnsecureApps.noappspass(driver);
	    			            		 driver.navigate().back();
	    			  		            	Thread.sleep(5000);
	    			    		             driver.navigate().back();
	  			            		     //unsecureappexistornot.isDisplayed();
	  			            	         //ERemoveUnsecureApps.allunsecureappsremovedfailed(driver);
	  			            	   }
	  			            	   catch(Exception ex)
	  			            	   {
	  			            		 unsecureappexistornot.isDisplayed();
				            	     ERemoveUnsecureApps.allunsecureappsremovedfailed(driver);
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
	  		            	 ERemoveUnsecureApps.allunsecureappsnotinstalled(driver);   
	  		            	 driver.navigate().back();
	  		            	 Thread.sleep(5000);
	    		             driver.navigate().back();
	  		               }
		 		    }
	       	        catch(Exception e)
	   	 		    {
	   	 		        ERemoveUnsecureApps.removeunsecurefail(driver);
	   	 		    }
	         }catch(Exception es) {}
	   	} 
		@Test(priority=3)
	    public void speedboosteropen() throws Exception
		{
			/*Splash screen validating and click got it button and moving to allows RedGreen access photos, media and files on your device
			    * Allows RedGreen access photos, media 
			    * Allows RedGreen access phone Calls */
	    	   
				ESpeedBooster.exreportopen();
				try
				{   
					Speedbooster.isDisplayed();
					Thread.sleep(5000);
		            Speedbooster.click();		
			        ESpeedBooster.speedboosteropen(driver);
			          
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
				              ESpeedBooster.disableautosyncpermissionno(driver);
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
				             /* driver.navigate().back();
				              Thread.sleep(5000);
				              Speedbooster.click();
				              Thread.sleep(5000);*/
				              Enableautosync.isDisplayed();
			                  Thread.sleep(5000);
			                  ESpeedBooster.enableautosyncdisplayed(driver);
			                  Thread.sleep(5000);
			                  
		                  }
		                  catch(Exception e)
		                  {
		                	  ESpeedBooster.enableautosyncnotfound(driver);  
		                  }
			          }
			          catch(Exception e)
			          {
			        	  ESpeedBooster.disableautosyncfail(driver);
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
				        ESpeedBooster.disablewifipermissionno(driver);
				        Thread.sleep(5000);
				        Disablewifi.click();
				        Thread.sleep(5000);
				        Disablewifiyes.click();
				        WebDriverWait wait=new WebDriverWait(driver,25);
		                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		                String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		                System.out.println(atoastmessage);
		                try
			        	{
		                	Disablewifi.isDisplayed();
			        		
			        	}catch(Exception e)
			        	{
			        		driver.navigate().back();
			        	}
		                
				         Thread.sleep(5000);
				        //Speedbooster.click();
			            //Thread.sleep(5000);
			   	        ESpeedBooster.disablewifi(driver);		   	        
		 		    }
		 		    catch(Exception e)
		 		    {
		 		    	ESpeedBooster.disablewifinotclicked(driver);;
					    Thread.sleep(5000);
		 		    } 		    
				}
				catch(Exception e)
				{
					ESpeedBooster.disablewififail(driver);
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
			        	ESpeedBooster.disablelocationpermissionno(driver);
			        	Thread.sleep(5000);
			        	Disablelocation.click();
			        	Thread.sleep(5000);
			        	Disablelocationyes.click();
			        	WebDriverWait wait=new WebDriverWait(driver,25);
		                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		                String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
		                System.out.println(atoastmessage);
		                
			        	try
			        	{
			        		Disablelocation.isDisplayed();
			        		Thread.sleep(5000);
			        		ESpeedBooster.disablelocation(driver);
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
			        	    ESpeedBooster.disablelocation(driver);    
			        		}catch(Exception ex) {
			        			ESpeedBooster.disablelocationfail(driver);
			        		}
			        		
			        	}	        	  
			        }
			        catch(Exception e)
			        {
			        	ESpeedBooster.disablelocationfail(driver);
			        }
				}
				catch(Exception e)
				{
					ESpeedBooster.disablelocationfail(driver);
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
		        		ESpeedBooster.updatedevicepermissionno(driver);
		        		Thread.sleep(5000);
		        		Updatedevice.click();
		        		Thread.sleep(5000);
		        		Updatedeviceyes.click();
		        		Thread.sleep(5000);
		        	    Updatecheck.click();
		        		Thread.sleep(5000);
		        		driver.navigate().back();
		        		Thread.sleep(5000);
		        		/*driver.navigate().back();
		        		Thread.sleep(5000);
		        	    Speedbooster.click();
		        	    Thread.sleep(5000);*/
		        		ESpeedBooster.updatedevice(driver);
		        	}
		        	catch(Exception e)
		        	{
		        		ESpeedBooster.updatedevicenotfound(driver);
		        		Thread.sleep(10000);
		        	}
				}
				catch(Exception e)
				{
					ESpeedBooster.updatedevicefail(driver);
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
		        ESpeedBooster.touchactions(driver);
		        
		       // Blocking Device Notifications
		        try
		        {
		        	Notificationblock.isDisplayed();
		        	Thread.sleep(5000);
		        	Notificationblock.click();
		        	Thread.sleep(5000);
		        	permissionno.click();
		        	ESpeedBooster.notficationsblockno(driver);
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
		        	ESpeedBooster.notficationsblock(driver);	
		        }
		        catch(Exception ex)
		        {
		        	ESpeedBooster.notificationblockfail(driver);
		        }
		        
		        driver.navigate().back();
		        Thread.sleep(5000);
		        /*driver.navigate().back();
		        Speedbooster.click();*/
		        
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
		        ESpeedBooster.touchactions(driver);
		        
		       // Cleahuphomescreen Functionaity
		        try
		        {
		        	  cleanuphomescreen.isDisplayed();
		        	  Thread.sleep(5000);
		        	  cleanuphomescreen.click();
		        	  Thread.sleep(5000);
		        	  popupno.click();
		        	  ESpeedBooster.cleanhomeappsno(driver);
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
		        	  ESpeedBooster.cleanhomeapps(driver);
		        	  Thread.sleep(5000);
		        	 /* driver.navigate().back();
		        	  Speedbooster.click();
		        	  Thread.sleep(5000);*/
		        	  WebElement we2=driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/scrollview']"));
		        	  Dimension d3 =we2.getSize();
		        	  //System.out.print(d3);
		        	  int start_x2=(int) (d3.width * 0.5);
		        	  int start_y2=(int) (d3.height * 0.8);
		        	  int end_x2=(int) (d3.width * 0.5);
		        	  int end_y2=(int) (d3.height * 0.1);
		        	  TouchAction ta2=new TouchAction(driver);
		        	  ta2.press(PointOption.point(start_x2,start_y2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x2,end_y2)).release().perform();
		        	  ESpeedBooster.touchactions(driver);
		        }
		        catch(Exception ex)
		        {
		        	ESpeedBooster.cleanuphomeappfail(driver);
		        }
		        
		        // Restricting Device Hotspot
		        try
		        {
		        	Restricthotspot.isDisplayed();	 
	        	    Thread.sleep(5000);
	        	    Restricthotspot.click();
	        	    Thread.sleep(5000);
	        	    Restricthotspotpermissionno.click();
	        	    ESpeedBooster.restricthotspotno(driver);
	        	    Thread.sleep(5000);
	        	    Restricthotspot.click();
	        	    Thread.sleep(5000);
	        	    Restricthotspotpermissionyes.click();
	        	    Thread.sleep(5000);
	        	    driver.navigate().back();
	        	    Thread.sleep(5000);
	        	    driver.navigate().back();
	        	    Thread.sleep(5000);
	        	    ESpeedBooster.restricthotspot(driver);
	        	    Thread.sleep(5000);
	        	    
		        }
		        catch(Exception ex)
		        {
		        	ESpeedBooster.hotspotrestirctfail(driver);
		        }
		    }
		    catch(Exception e)
		    {
			   ESpeedBooster.speedboosternotfound(driver);
			   Thread.sleep(5000);
		    }
				
				ERforAppManagerFavAndDel.exreportclose();
				ERemoveUnsecureApps.exreportclose();
		  	    ESpeedBooster.exreportclose();
					
		 }

	    public void closeapp() throws Exception
	    {
	    		
	    	
	    	Thread.sleep(3000);
	        driver.closeApp();
	        Thread.sleep(1000);
            //Stop the Server
	        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	  
	    }
	   
}
