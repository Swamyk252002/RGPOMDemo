package com.RedGreen.AppManager;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
//import org.springframework.util.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.ExtentReports.ExtentReportforSaveBattery;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SaveBattery
{
	AndroidDriver<AndroidElement> driver;
    
    public SaveBattery(AndroidDriver<AndroidElement> driver)
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
    
    @AndroidFindBy(xpath="//*[@text='GOT IT']")
    private AndroidElement gotit;
    @AndroidFindBy(xpath="//*[@text='ALLOW']")
    private AndroidElement allowphotosandmedia;
    @AndroidFindBy(xpath="//*[@text='ALLOW']")
    private AndroidElement allowphones;
    @AndroidFindBy(xpath="//*[@text='Save Battery']")
    private AndroidElement savebattery;
    @AndroidFindBy(xpath="//*[@text='OK']")
    private AndroidElement acceptpermissionok;  
    @AndroidFindBy(xpath="//*[@text='RedGreen']")
    private AndroidElement redgreenoption; 
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
 
    
    
  
    ExtentReportforSaveBattery ERforSaveBattery = new ExtentReportforSaveBattery();
    
    
    @Test  
    public void savebatteryclick() throws Exception, InterruptedException, MalformedURLException
    {

    	/* Open the Extent Report
    	 * verifing splashscreens 
         */
    	
    	ERforSaveBattery.exreportopen();
    	ERforSaveBattery.redgreenappopen(driver);
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	Thread.sleep(5000);
    	gotit.click();
    	Thread.sleep(5000);
    	ERforSaveBattery.splashscreenverification(driver);
       	allowphotosandmedia.click();
       	Thread.sleep(5000);
       	allowphones.click();
       	Thread.sleep(5000);
       	
       	/*Click on  Appmanager module to verify remove unsecure apps exist
         * Remove unsecure apps - To delete the unsecure apps
         * Great you don't have Unsecure Apps - message verification
         */
       	
		try {
			savebattery.isDisplayed();
			savebattery.click(); 
			Thread.sleep(5000);
			ERforSaveBattery.savebatterypass(driver);
			Thread.sleep(5000);
	  	    try{
	  	    	savebatterytitle.isDisplayed();
	  	    }catch(Exception ex){
	  		       acceptpermissionok.click();
	  		     Thread.sleep(5000);
	  		       try{
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
	  	             Thread.sleep(5000);
	  	        	 String bs=remainingbatteryinfo.getText();
	  	        	 System.out.println("Remaining Battery Info :"+bs);
	  	        	 ERforSaveBattery.remainingbatterypass(driver);
	  	        	 Thread.sleep(5000);
	  	        }catch(Exception e){
	  	        	ERforSaveBattery.remainingbatteryfail(driver);
	  	        }  
	  	        try {
	  	        	    systemappsname.isDisplayed();
	  	        	    ERforSaveBattery.systemappsspass(driver);
	  	        	    Thread.sleep(5000);
	  	        	    try {
	  	        		    systemappinfo.isDisplayed();
	  	        		    String s=systemappinfo.getText();
	  	        		    System.out.println("System App Info :" +s);
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
		  	        		cpucoolerinfo.isDisplayed();
		  	        		String s=cpucoolerinfo.getText();
		  	        		Thread.sleep(5000);
		  	        		System.out.println("CPU App Info :" +s);
		  	        		ERforSaveBattery.cpucoolerinfopass(driver);
		  	        		cpucoolername.click();
		  	        		Thread.sleep(5000);
		  	        	}catch(Exception e) {
		  	        		ERforSaveBattery.cpucoolerinfofail(driver);}
		  	        	try {
		  	        		cpucoolerpopup.isDisplayed();
		  	        		Thread.sleep(5000);
		  	        	}catch(Exception e) {
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
		  	        		cpucoolername.click();
		  	        		Thread.sleep(5000);
		  	        		cpucoolerpopup.isDisplayed();
		  	        		cpucoolerpopupcancel.click();
		  	        		Thread.sleep(5000);
		  	        		ERforSaveBattery.cpucoolercancelpass(driver);
		  	        	}catch(Exception e){
		  	        		ERforSaveBattery.cpucoolercancelfail(driver);
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
                            ERforSaveBattery.cpucoolbattery(driver);
                            Thread.sleep(5000);
                            driver.navigate().back();
                            Thread.sleep(5000);
                            
                            driver.findElement(By.id("com.android.settings:id/switchWidget")).click();
		  	        		Thread.sleep(5000);
		  	        		driver.findElement(By.id("com.android.settings:id/switchWidget")).click();
		  	        		Thread.sleep(5000);
		  	        		ERforSaveBattery.cpucoolerbaterysever(driver);
		  	        		driver.findElement(By.xpath("//*[@resource-id='android:id/switch_widget']")).click();
                            Thread.sleep(5000);
		  	        		driver.findElement(By.xpath("//*[@resource-id='android:id/switch_widget']")).click();
		  	        		Thread.sleep(5000);
		  	        		ERforSaveBattery.cpucoolerbaterypercentage(driver);
		  	        		driver.findElement(By.xpath("//*[@text='Sleep']")).click();
		  	        		Thread.sleep(5000);
		  	                driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='2 minutes']")).click();
		  	                Thread.sleep(5000);
		  	                driver.findElement(By.xpath("//*[@text='Sleep']")).click();
		  	                Thread.sleep(5000);
		  	                
		  	                driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='30 minutes']")).click();
		  	                Thread.sleep(5000);
		  	              
		  	                ERforSaveBattery.cpucoolermobilesleep(driver);
		  	              
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
		ERforSaveBattery.exreportclose();
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
