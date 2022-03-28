package com.RedGreen.AppManager;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.ExtentReports.ExtentReportForSpeedBooster;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
public class SpeedBooster 
{
protected AndroidDriver<AndroidElement> driver;
	
	public SpeedBooster(AndroidDriver<AndroidElement> driver)
	{
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	/* Open RedGreen App
	    * Splash screen validating and click got it button and moving to allows RedGreen access photos, media and files on your device
	    * Allows RedGreen access photos, media 
	    * Allows RedGreen access phone Calls 
	    * Speed Bosster - Click and open speed booster
	    * Disbale Auto sync - permission yes, enable auto sync - yes , Disable WIFI - Accept button yes, Disable Location - Permissions yes
	    * Update device - Check for Update - Click yes to accept, Notification Block - Permission yes, Clean up Home Screen - permission Yes and redirect to home screen
	    * Restrict Hotspot - Permission Yes, Navigate back to Home
	    */   
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
	@AndroidFindBy(xpath="//*[@text='GOT IT']")
	private AndroidElement gotit;
	@AndroidFindBy(xpath="//*[@text='ALLOW']")
	private AndroidElement allowphoto;
	@AndroidFindBy(xpath="//*[@text='ALLOW']")
	private AndroidElement allowphone;
	
	ExtentReportForSpeedBooster exrrunspeedbooster= new ExtentReportForSpeedBooster();
	
	@Test	
	public void speedboosteropen() throws Exception
	{
		/*Splash screen validating and click got it button and moving to allows RedGreen access photos, media and files on your device
		    * Allows RedGreen access photos, media 
		    * Allows RedGreen access phone Calls */
			
			exrrunspeedbooster.exreportopen();
			exrrunspeedbooster.redgreenappopen(driver);
			Thread.sleep(5000);
			gotit.click();
			Thread.sleep(5000);
			allowphoto.click();
			Thread.sleep(5000);
			allowphone.click();
			exrrunspeedbooster.splashscreenverification(driver);
		    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(5000);
			try
			{
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
			        driver.navigate().back();
			        Thread.sleep(5000);
			        Speedbooster.click();
		            Thread.sleep(5000);
		            Disablewifi.click();
			        Thread.sleep(5000);
			        Disablewifiyes.click();
			        WebDriverWait wait1=new WebDriverWait(driver,25);
	                wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
	                String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
	                System.out.println(atoastmessage1);
			        Thread.sleep(5000);
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
			exrrunspeedbooster.exreportclose();
	    }
@AfterTest
public void closeapp() throws IOException
{
	   driver.closeApp();
	   Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	   Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
				
	}
}

