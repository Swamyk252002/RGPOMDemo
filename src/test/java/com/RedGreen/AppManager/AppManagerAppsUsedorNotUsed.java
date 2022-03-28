package com.RedGreen.AppManager;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.util.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ExtentReports.ExtentReportforAppManagerFavAndDel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppManagerAppsUsedorNotUsed
{
	AndroidDriver<AndroidElement> driver;
    
    public AppManagerAppsUsedorNotUsed(AndroidDriver<AndroidElement> driver)
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
	  	        	 /* List<AndroidElement> Usedandnotusedapps= driver.findElementsByXPath("//*[contains(@text,'used')]");
		              System.out.println("List Of Used and Not Used names : " + Usedandnotusedapps.size());
		              Thread.sleep(5000);
		              int appsacount=Usedandnotusedapps.size();
		              System.out.println(appsacount);
		              Thread.sleep(5000);
		              //int appeacount=1;
	  	        	  if(appsacount!=0)
	  	        	  {  
	  	        		      
	  	        		      for(int i = 0; i<Usedandnotusedapps.size();i++){
				              System.out.println(Usedandnotusedapps.get(i).getText());
				              Thread.sleep(5000);}
        	        		  //ERforAppManagerFavAndDel.listofusedorunusedappspass(driver);
        	        		  
        	        		  if(appsacount==1){
		                         List<AndroidElement> Usedandnotusedapps1= driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]");
		                         System.out.println("List Of Used and Not Used named : " + Usedandnotusedapps1.size());
		                         Thread.sleep(5000);
		                         System.out.println( Usedandnotusedapps1.size());
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
        	            /* try {
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
		              }*/
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
    		           	     		                     Thread.sleep(5000);
    		           	    		                     driver.navigate().back();
    		           		  	        	   
    		           		                       }catch(Exception e) {
    		           		                    	ERforAppManagerFavAndDel.optionseletionverifivationfail(driver);}
    		     		                    }catch(Exception e) {
    		     		                    	ERforAppManagerFavAndDel.doneoptionsfail(driver);}
     		                         }catch(Exception e) {
     		                        	ERforAppManagerFavAndDel.optionsfail(driver);}
     		                   }catch(Exception e) {
     		                	  ERforAppManagerFavAndDel.checkboxenableanddisablefail(driver);}
     		              }catch(Exception e) {
     		  	        	ERforAppManagerFavAndDel.automaticallyuninstallfail(driver);}
     		        }catch(Exception e) {
	  	        		ERforAppManagerFavAndDel.settingbuttonpassfail(driver);
	  	        		driver.navigate().back();}
	  	        }catch(Exception ex) {
       	        	ERforAppManagerFavAndDel.headingsoflistappsfail(driver);}
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
	    /*  Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	     Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");*/	
	  }
}
