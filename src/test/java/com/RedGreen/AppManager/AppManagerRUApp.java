package com.RedGreen.AppManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.ExtentReports.ExtentReportforRemoveUnsecureApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppManagerRUApp 
{
	 AndroidDriver<AndroidElement> driver;
	    
	    public AppManagerRUApp(AndroidDriver<AndroidElement> driver)
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
	    ExtentReportforRemoveUnsecureApp exrrunsecureapp= new ExtentReportforRemoveUnsecureApp();
	    
	    @Test  
	    public void appmanagerclick() throws Exception
	    {
	    	/* Open the Extent Report
	    	 * verifing splashscreens 
            */
	    	
	    	exrrunsecureapp.exreportopen();
	    	exrrunsecureapp.redgreenappopen(driver);
	    	Thread.sleep(5000);
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	       	gotit.click();
	       	Thread.sleep(5000);
	       	exrrunsecureapp.splashscreenverification(driver);
	       	allowphotosandmedia.click();
	       	Thread.sleep(5000);
	       	allowphones.click();
	       	Thread.sleep(5000);
	    	
	       
   	       /*Click on  Appmanager module to verify remove unsecure apps exist
           * Remove unsecure apps - To delete the unsecure apps
           * Great you don't have Unsecure Apps - message verification
           */
	       	
	       try { 
				    appmanager.click();
				    Thread.sleep(5000);
				    exrrunsecureapp.appmanagerpass(driver);
		  	 
		  	        try{
		  	              removeunsecureapps.isDisplayed();		     
		  	  	    }catch(Exception ex){
		  		       acceptpermissionok.click();
		  			   redgreenoption.click();
		  			   permitusageaccess.click();
		  			}
		  	        try{  Thread.sleep(5000);
		  	              removeunsecureapps.isDisplayed();
		  	        	  removeunsecureapps.click();
		  	        	  Thread.sleep(5000);
		  	        	  exrrunsecureapp.removeunsecurepass(driver);
	       	              try
	  		              {  
	       	            	  
	       	            	Thread.sleep(5000);
	       	            	  applockselect.isDisplayed();
	       	            	Thread.sleep(5000);
	       	            	  applockselect.click();
	       	            	  Thread.sleep(5000);
	       	            	  unsecureappcanceltodelete.isDisplayed();
	    		  	          unsecureappcanceltodelete.click();
	    		  	          try{ Thread.sleep(5000);
	    		  	        	    applockselect.isDisplayed();
	    		  	        	    exrrunsecureapp.cancelbuttonpass(driver);
	    		  	        	}catch(Exception ex){
	    		  	        		exrrunsecureapp.cancelbuttonfail(driver);
	    		  	        	}
	    		  	          try{  Thread.sleep(5000);
	    		  	                 applockselect.click();
	    		  	               Thread.sleep(5000);
	    		  	                 unsecureappdelete.isDisplayed();
	    		  	                 Thread.sleep(5000);
		  	                	     unsecureappdelete.click();
		  	                         WebDriverWait wait=new WebDriverWait(driver,25);
	  	                             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
	  	                             String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
	  	                             System.out.println(atoastmessage);
	  	                             Thread.sleep(8000);
	  	                             exrrunsecureapp.okbuttonpass(driver);
	  	                           Thread.sleep(5000);
	  	                             exrrunsecureapp.toastmessagepass(driver);  
	  	                             try {
    		  	                            	noapps.isDisplayed();
    		  	                            	Thread.sleep(5000);
    		  	                            	exrrunsecureapp.noappspass(driver);
    		  	                            	Thread.sleep(5000);
    		  	                            	driver.navigate().back();
    		  	                            	Thread.sleep(5000);
    		  	    		                    driver.navigate().back();
    		  	    		                  Thread.sleep(5000);
    		  	                      }catch(Exception e) {
    		  	                            	exrrunsecureapp.noappsfail(driver);
    		  	                            	Thread.sleep(5000);
    		  	                            	driver.navigate().back();
    		  	                            	Thread.sleep(5000);
    		  	    		                    driver.navigate().back();
    		  	    		                    Thread.sleep(5000);}
                                 }catch(Exception e) {
                                	   Thread.sleep(5000);
                                	   exrrunsecureapp.toastmessagefail(driver);
  	    		  	        		   exrrunsecureapp.okbuttonfail(driver);
  	    		  	        		   Thread.sleep(5000);
  	                            	   driver.navigate().back();
  	                                   Thread.sleep(5000);
  	    		                       driver.navigate().back();
  	    		                       Thread.sleep(5000);}
	    		  	      }catch(Exception e){
	       	            	exrrunsecureapp.allunsecureappsnotinstalled(driver);
	       	            	Thread.sleep(5000);
	       	            	driver.navigate().back();
	       	            	Thread.sleep(5000);
		  	        		driver.navigate().back();
		  	        		Thread.sleep(5000);
		                    driver.navigate().back();}
	       	         }catch(Exception e){
		  	        	exrrunsecureapp.removeunsecurefail(driver);
		  	        	Thread.sleep(5000);
	                    driver.navigate().back();
	                    Thread.sleep(5000);}
			}catch(Exception e){
	       		exrrunsecureapp.appmanagerfail(driver);
	       	}
	    	 exrrunsecureapp.exreportclose(); 
	    	 
	    }
	    
	    @AfterTest  
	    public void closeapp() throws Exception
	    {
	    		    	
	    	Thread.sleep(5000);
	        driver.closeApp();
	        
	        //Stop the Server
	      Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	      Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	    }
}
