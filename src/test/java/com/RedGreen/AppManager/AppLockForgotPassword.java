package com.RedGreen.AppManager;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ExtentReports.ExtentReportAppLockForgotPassword;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLock;
import com.RedGreen.Utility.RegGreenDesiredCapabilitiesAppLockTesting_qw;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLockForgotPassword {
	AndroidDriver<AndroidElement> driver;

	
	// App Lock Setup Pin Forgot Password Functionality Testing Forgot Password
	 

	public AppLockForgotPassword(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='App Lock']")
	private AndroidElement applock;
	@AndroidFindBy(xpath = "//*[@text='RedGreen']")
	AndroidElement applockpermission;
	@AndroidFindBy(xpath = "//*[@text='OFF']")
	AndroidElement applockpermissionclickonoff;
	@AndroidFindBy(xpath = "//*[@text='OK']")
	AndroidElement applockpermissionok;
	@AndroidFindBy(xpath = "//*[@text='CANCEL']")
	AndroidElement applockpermissioncancel;
	@AndroidFindBy(xpath = "//*[@text='Vysor']")
	AndroidElement vysorlock;
	@AndroidFindBy(xpath = "//*[@text='5']")
	AndroidElement pinnumbertwo;
	@AndroidFindBy(xpath = "//*[@text='8']")
	AndroidElement pinnumberthree;
	@AndroidFindBy(xpath = "//*[@text='0']")
	AndroidElement pinnumberfour;
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
	@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/forgotPassword']")
	AndroidElement forgotpassword;
	@AndroidFindBy(xpath = "//*[@text='OK']")
	AndroidElement forgotpasswordemailsentok;
	@AndroidFindBy(xpath = "//*[@text='GOT IT']")
	private AndroidElement gotit;
	@AndroidFindBy(xpath = "//*[@text='Thank You']")
	AndroidElement forgotpasswordthankyou;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphotosandmedia;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphones;
	@AndroidFindBy(xpath = "//*[@text='Thank You']")
	private AndroidElement thankyouok;
	@AndroidFindBy(xpath = "//*[@text='Your password has been']")
	private AndroidElement passwordsentok;
	

	ExtentReportAppLockForgotPassword exrapplockforgotpassword = new ExtentReportAppLockForgotPassword();

	@Test
	public void ForgotPassword() throws Exception 
	{
		exrapplockforgotpassword.exreportopen();
		Thread.sleep(5000);
		exrapplockforgotpassword.redgreenappopen(driver);
		Thread.sleep(5000);
		gotit.click();
		Thread.sleep(5000);
		exrapplockforgotpassword.splashscreenverification(driver);
		Thread.sleep(5000);
		allowphotosandmedia.click();
		Thread.sleep(5000);
		allowphones.click();
		Thread.sleep(5000);
		exrapplockforgotpassword.allowphotosmediaandphonespermissionsallow(driver);
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
				applockpermissionok.click();
				Thread.sleep(5000);
				applockpermissionok.click();
				for (int i = 0; i < 4; i++) {
					pinnumbertwo.click();
				}
				Thread.sleep(5000);
				nextbutton.click();
			}

				catch (Exception ex) {
				applockpermission.isDisplayed();
				try {
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
					vysorlock.click();
					Thread.sleep(5000);
					for (int i = 0; i < 4; i++) {
						pinnumbertwo.click();
						Thread.sleep(2000);
					}
					nextbutton.click();
					Thread.sleep(5000);
					for (int j = 0; j < 4; j++) {
						pinnumbertwo.click();
						Thread.sleep(2000);
					}
					nextbutton.click();
					Thread.sleep(5000);
					exrapplockforgotpassword.applockpinsetuppass(driver);
					
				} catch (Exception ex2) {
					exrapplockforgotpassword.applockpinsetupfail(driver);
				}

				try {
					allowpermission.click();
					Thread.sleep(5000);
					email.sendKeys("k.swamy1719@gmail.com");
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
					//Thread.sleep(10000);

					//RegGreenDesiredCapabilitiesAppLockTesting_qw qw=new RegGreenDesiredCapabilitiesAppLockTesting_qw();
					//driver=RegGreenDesiredCapabilitiesAppLockTesting_qw.getAndroidDriver();
					
					Thread.sleep(15000);
					driver.activateApp("com.google.android.gm");
					Thread.sleep(10000);
					
					
					//driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
					//Thread.sleep(10000);
					
					//driver.findElement(By.xpath("//*[contains(@text,'TAKE')]")).click();
					//Thread.sleep(10000);
					//System.out.println("swamy");

					driver.findElement(By.xpath("//*[contains(@content-desc,'RedGreen Password')]")).click();
					Thread.sleep(12000);
					//System.out.println("swamy1");
                    
					
					//driver.findElement(By.xpath("(//*[contains(@text,'Hello RedGreen')])[1]")).click();
					//Thread.sleep(10000);
					//String s=driver.findElement(By.xpath("//*[contains(@text,'AppLock Password is')]")).getText();
					///System.out.println(s);
					//List<WebElement> l=driver.findElement(By.xpath("//*[@text='unfoldlabs.donotreply@gmail.com']"));
					
					//List<WebElement> l= driver.findElement(By.xpath("//*[@text='unfoldlabs.donotreply@gmail.com']"));
						//	driver.findElements(By.xpath("//*[@text='unfoldlabs.donotreply@gmail.com']"));

					/*System.out.println(l.size());
					if(l.size()>1)
					{
						driver.findElement(By.xpath("//*[@text='unfoldlabs.donotreply@gmail.com']")).click();
						Thread.sleep(5000);
						String s=driver.findElement(By.xpath("//*[contains(@text,'AppLock Password is')]")).getText();
						System.out.println(s);
					}
					else {
						String s=driver.findElement(By.xpath("//*[contains(@text,'AppLock Password is')]")).getText();
						System.out.println(s);
						Thread.sleep(5000);
					}*/
					Thread.sleep(5000);
					
					driver.activateApp("com.unfoldlabs.redgreen");
					Thread.sleep(10000);
					/*gotit.click();
					Thread.sleep(5000);
					allowphotosandmedia.click();
					Thread.sleep(5000);
					allowphones.click();
					Thread.sleep(5000);
					applock.click();*/
					Thread.sleep(3000);
					for (int j = 0; j < 4; j++) {
						pinnumbertwo.click();
						Thread.sleep(2000);
					}
					nextbutton.click();
					driver.navigate().back();
					Thread.sleep(5000);
					driver.navigate().back();
					driver.closeApp();
					
					exrapplockforgotpassword.applockforgotpasswordpass(driver);
					

				} catch (Exception ex1) {
					exrapplockforgotpassword.applockforgotpasswordfail(driver);
					
				}

			}
			
		} catch (Exception ex) {
			exrapplockforgotpassword.applockclickfail(driver);
			
		}
		exrapplockforgotpassword.exreportclose();
	}	

	public void closeApp() throws IOException, InterruptedException {
		driver.closeApp();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
