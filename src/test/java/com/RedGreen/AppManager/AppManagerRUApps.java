package com.RedGreen.AppManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
//import org.springframework.util.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ExtentReports.ExtentReportforRemoveUnsecureApps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppManagerRUApps
{
	AndroidDriver<AndroidElement> driver;
    
    public AppManagerRUApps(AndroidDriver<AndroidElement> driver)
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
    
    /*-------------------RedGreenApps Locators------------------------------------------------------------------------*/
    
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
    @AndroidFindBy(xpath="//*[@text='GOT IT']")
    private AndroidElement gotit;
    @AndroidFindBy(xpath="//*[@text='ALLOW']")
    private AndroidElement allowphotosandmedia;
    @AndroidFindBy(xpath="//*[@text='ALLOW']")
    private AndroidElement allowphones;
    @AndroidFindBy(xpath="//*[@text='CANCEL']")
    private AndroidElement unsecureappcanceltodelete;
    
    SoftAssert softAssert= new SoftAssert();
    ExtentReportforRemoveUnsecureApps exrremoveunsecureapps = new ExtentReportforRemoveUnsecureApps();
    
    
    
    @Test  
    public void appmanagerclick() throws Exception
    {

    	/* Open the Extent Report
    	 * verifing splashscreens 
         */
    	
    	exrremoveunsecureapps.exreportopen();
    	exrremoveunsecureapps.redgreenappopen(driver);
    	Thread.sleep(5000);
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       	gotit.click();
       	Thread.sleep(5000);
       	exrremoveunsecureapps.splashscreenverification(driver);
       	allowphotosandmedia.click();
       	Thread.sleep(5000);
       	allowphones.click();
       	
       	/*Click on  Appmanager module to verify remove unsecure apps exist
         * Remove unsecure apps - To delete the unsecure apps
         * Great you don't have Unsecure Apps - message verification
         */
       	Thread.sleep(5000);
       	String emname="App Manager";
 	    String amname=appmanager.getText();
		if(emname.contentEquals(amname))
		{
			    appmanager.click();  
			    Thread.sleep(5000);
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
	  	        if(esmname.contentEquals(asmname))
	 		    {     Thread.sleep(5000);
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
  				               int count= ua.size();
  			            	   while(i<ua.size())
  				               {
  				       	             /*driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget."
  				           	    	 	+ "RelativeLayout/android.widget.ImageView[2]")).click();*/
  				     	            if(count==3)
  				     	            {
  			            		     driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/fraudapps_delete']")).click();
  				     	             Thread.sleep(5000);
  				     	             unsecureappcanceltodelete.click();
				     	             Thread.sleep(5000);
				     	             driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/fraudapps_delete']")).click();
 				     	             Thread.sleep(5000);
  				     	             unsecureappdelete.click();
  				                     Thread.sleep(8000);
  				     	             i++;
  				     	             count--;
  				     	             System.out.println(count);}
  				     	            else {
  				     	            	driver.findElement(By.xpath("//*[@resource-id='com.unfoldlabs.redgreen:id/fraudapps_delete']")).click();
  	  				     	             Thread.sleep(5000);
  					     	             unsecureappdelete.click();
  	  				                     Thread.sleep(8000);
  	  				     	             i++;
  				     	            }
  				     	       }
  			            	   try
  			            	   {     Thread.sleep(5000);
  			            		     noapps.isDisplayed();
  			            		     Thread.sleep(5000);
    			            		 exrremoveunsecureapps.allunsecureappsremoved(driver);
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
  			            		 /*exrremoveunsecureapps.allunsecureappsremoved(driver);
  			            		 String enounsecureapp="Greatyou don't have Unsecure Apps";
	  		    	             String aenounsecureapp= noapps.getText();
	  		    	             if(enounsecureapp.contains(aenounsecureapp))
	  		    	             {   System.out.println("Swamy3");
	  		    		              Assert.assertEquals(enounsecureapp, aenounsecureapp);
	  		    		              exrremoveunsecureapps.noappspass(driver);
	  		    	                  driver.navigate().back();
	  		    		              Thread.sleep(3000);
	  		    		              driver.navigate().back();
	  		    	             }
	  		    	             else
	  		    	             {	 System.out.println("Swamy4"); 		    		             
	  		    	            	  Assert.assertNotEquals(enounsecureapp, aenounsecureapp);
	  		    		              exrremoveunsecureapps.noappsfail(driver);
	  		    	              }*/ 
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
       	        else
   	 		    {
   	 		        exrremoveunsecureapps.removeunsecurefail(driver);
   	 		    }
   	  	    } 
   		    else
   		    {
   			   exrremoveunsecureapps.appmanagerfail(driver);
   		   }
   		   exrremoveunsecureapps.exreportclose();  
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

