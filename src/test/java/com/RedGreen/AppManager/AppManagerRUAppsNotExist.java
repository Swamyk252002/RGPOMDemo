package com.RedGreen.AppManager;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ExtentReports.ExtentReportforAppNotExist;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppManagerRUAppsNotExist
{
	
	AndroidDriver<AndroidElement> driver;
	    
	    public AppManagerRUAppsNotExist(AndroidDriver<AndroidElement> driver)
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
	    @AndroidFindBy(xpath="//*[@text='GOT IT']")
	    private AndroidElement gotit;
	    @AndroidFindBy(xpath="//*[@text='ALLOW']")
	    private AndroidElement allowphotosandmedia;
	    @AndroidFindBy(xpath="//*[@text='ALLOW']")
	    private AndroidElement allowphones;
	    SoftAssert softAssert= new SoftAssert();
	    ExtentReportforAppNotExist exrnotexist = new ExtentReportforAppNotExist();
	       
	      
	    
	    
	    
	    @Test  
	    public void Removeunsecureappsclick() throws Exception
	    {
	    	/* Open the Extent Report
	    	 * Verifying splashscreens 
             */
	    	
	    	exrnotexist.exreportopen();
	    	exrnotexist.redgreenappopen(driver);
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	       	gotit.click();
	       	exrnotexist.splashscreenverification(driver);
	       	allowphotosandmedia.click();
	       	allowphones.click();
	    	
	       
    	   /*Click on  Appmanager module to verify remove unsecure apps exist
            * Remove unsecure apps - To delete the unsecure apps
            * Great you don't have Unsecure Apps - message verification
            */
 	          
    	   
	       
	       /*String emname="App Manager";
    	   String amname=appmanager.getText();
		   if(emname.contentEquals(amname))*/
		   try {
			    appmanager.isDisplayed();
			    appmanager.click();  
			    exrnotexist.appmanagerpass(driver);
	  	        try
	  	        {
	  	              removeunsecureapps.isDisplayed();		     
	  	  	    }
	  	        catch(Exception ex)
	  	        {
	  		       acceptpermissionok.click();
	  			   redgreenoption.click();
	  			   permitusageaccess.click();
	  			}
	  	        try {     
	  	        	  removeunsecureapps.isDisplayed();
	  	        	  removeunsecureapps.click();		     
	  		          exrnotexist.removeunsecurepass(driver);
	  		    	 try {
	  		    		  noapps.isDisplayed();
	  		    		  exrnotexist.noappspass(driver);
	  		    	      driver.navigate().back();
	  		    		  Thread.sleep(3000);
	  		    		  driver.navigate().back();
	  		    	  }catch(Exception e) {
	  		    		  exrnotexist.noappsfail(driver); 
	  		    		  driver.navigate().back();
	  		    		  Thread.sleep(3000);
	  		    		  driver.navigate().back();
	  		    	  }
	 		    }catch(Exception e){
	 		    	exrnotexist.removeunsecurefail(driver);
	 			    Thread.sleep(5000);
		    		driver.navigate().back();
	 		    }
	  	    }catch(Exception e){
			   exrnotexist.appmanagerfail(driver);
		   }
		   exrnotexist.exreportclose();     
	  }    
	  
	  @AfterTest  
	  public void closeapp() throws Exception
	  {
		  /* To Close the app 
		   *  Stop the Server
		   */
	  		    	
	     Thread.sleep(3000);
	     driver.closeApp();  
	     Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	     Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	  }
}


