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
//import org.springframework.util.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ExtentReports.ExtentReportforAppManagerFavAndDel;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLockTesting_qw;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppMngrFavAndDel2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class AppManagerAppsUsedorNotUsed2
{
	AndroidDriver<AndroidElement> driver;
    
    public AppManagerAppsUsedorNotUsed2(AndroidDriver<AndroidElement> driver)
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
    @AndroidFindBy(xpath="//*[@text='APP MANAGER']")
    private AndroidElement appmanagertitle; 
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
    
  
  
    ExtentReportforAppManagerFavAndDel ERforAppManagerFavAndDel = new ExtentReportforAppManagerFavAndDel();
    
    
    @Test  
    public void appmanagerclick() throws Exception, InterruptedException, MalformedURLException
    {

    	/* Open the Extent Report
    	 * verifing splashscreens 
         */
    	
    	ERforAppManagerFavAndDel.exreportopen();
    	ERforAppManagerFavAndDel.redgreenappopen(driver);
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	gotit.click();
       	ERforAppManagerFavAndDel.splashscreenverification(driver);
       	allowphotosandmedia.click();
       	allowphones.click();
       	
       	/*Click on  Appmanager module to verify remove unsecure apps exist
         * Remove unsecure apps - To delete the unsecure apps
         * Great you don't have Unsecure Apps - message verification
         */
       	
       	//String emname="App Manager";
 	    //String amname=appmanager.getText();
		try {
			appmanager.isDisplayed();
		    appmanager.click();  
		    ERforAppManagerFavAndDel.appmanagerpass(driver);   
	  	    try{
	  	        	appmanagertitle.isDisplayed();		     
	  	  	    }
	  	        catch(Exception ex){
	  		       acceptpermissionok.click();
	  			   redgreenoption.click();
	  			   permitusageaccess.click();
	  			}
	  	        try {
	  	        /*String esmname="APP MANAGER";
	  	        String asmname=appmanagertitle.getText();
	  	        if(esmname.contentEquals(asmname))
	 		    {*/  
	  	              appmanagertitle.isDisplayed();
	 		          ERforAppManagerFavAndDel.headingsoflistappspass(driver);
	  	        	  	  try {
	  	        		   settingbuttonclick.isDisplayed();
	  	        	       settingclick.click();
     		  	                          Thread.sleep(5000);
    		                              oneweek.click();
     		                              Thread.sleep(5000);
     		                             doneclick.click();
     		                             driver.navigate().back();
     		                            Thread.sleep(5000);
     		           		                             
     		                            //RegGreenDesiredCapabilitiesAppMngrFavAndDel2 fe=new RegGreenDesiredCapabilitiesAppMngrFavAndDel2();
     		                        //   driver=RegGreenDesiredCapabilitiesAppMngrFavAndDel2.getAndroidDriver();
     		                  		
     		                           driver.activateApp("com.android.settings");
        		             			Thread.sleep(5000);
        		             			
     		                          Thread.sleep(2000);
     		             			driver.findElement(By.xpath("//*[@resource-id='com.android.settings:id/search_action_bar']")).click();
     		             			Thread.sleep(5000);
     		             			
     		             			driver.findElement(By.xpath("//*[@resource-id='android:id/search_src_text']")).sendKeys("date & time");
     		             			Thread.sleep(5000);
     		             			driver.findElement(By.xpath("//*[@text='Date & time']")).click();
     		             			
     		             			Thread.sleep(5000);
     		             			//WebElement BillTOwebElement=driver.findElement(By.xpath("(//*[@class='android.widget.Switch'])[1]"));
     		           			    
     		             			try
     		           			    {
     		             				driver.findElement(By.xpath("(//*[@class='android.widget.Switch'])[1][@text='ON']"));
     		             				driver.findElement(By.xpath("(//*[@text='ON'])[1]")).click();
     		           				 }catch(Exception ex) {
     		           					 System.out.println("option Yes");
     		           				 }
     		           		    
     		             			//driver.findElement(By.xpath("(//*[@text='ON'])[1]")).click();
     		             			
     		             			
     		             			
     		             			Thread.sleep(8000);
     		             			driver.findElement(By.xpath("//*[@text='Set date']")).click();
     		             			
     		             			Thread.sleep(5000);
     		             			driver.findElement(By.xpath("//*[@text='9']")).click();
     		             			
     		             			Thread.sleep(5000);
     		             			driver.findElement(By.xpath("//*[@text='OK']")).click();
     		             			
     		             			Thread.sleep(10000);
     		             			driver.findElement(By.xpath("//*[@text='Set time']")).click();
     		             			
     		             			Thread.sleep(5000);
     		             			driver.findElement(By.xpath("//*[@content-desc='16']")).click();
     		             			
     		             			Thread.sleep(5000);
     		             			driver.findElement(By.xpath("//*[@content-desc='0']")).click();
     		             			
     		             			Thread.sleep(5000);
     		             			driver.findElement(By.xpath("//*[@text='OK']")).click();
     		             			
     		             			Thread.sleep(5000);
     		             			Thread.sleep(5000);
     		             			
     		             			driver.activateApp("com.unfoldlabs.redgreen");
     		             			Thread.sleep(20000);
     		             			driver.findElement(By.xpath("//*[@text='Uninstall']")).click();
         		             			
     		             			
     	     		                             
     		                                    }catch(Exception e) {
    		     		                    	ERforAppManagerFavAndDel.doneoptionsfail(driver);}
     		                         }catch(Exception e) {
     		                        	ERforAppManagerFavAndDel.optionsfail(driver);}
     		                  }catch(Exception e){
   			  // Assert.assertNotSame(emname, amname);
   			  //softAssert.fail();
   			//ERforAppManagerFavAndDel.getScreenshot(driver);
   			ERforAppManagerFavAndDel.appmanagerfail(driver);
   		}
		ERforAppManagerFavAndDel.exreportclose();
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
