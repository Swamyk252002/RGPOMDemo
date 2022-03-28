package com.RedGreen.AppManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ExtentReports.ExtentReportAppLockPinSetup;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLockPinSetup {
	AndroidDriver<AndroidElement> driver;

	/*
	 * Open RedGreen Application Validating Splash Screens AppLock Permissions allow
	 * Verifying Pin setup functionality
	 */

	public AppLockPinSetup(AndroidDriver<AndroidElement> driver) {
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
	@AndroidFindBy(xpath = "//*[@text='GOT IT']")
	private AndroidElement gotit;
	@AndroidFindBy(xpath = "//*[@text='Thank You']")
	AndroidElement forgotpasswordthankyou;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphotosandmedia;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphones;

	ExtentReportAppLockPinSetup exrapplockwithpermissions = new ExtentReportAppLockPinSetup();

	Boolean vysorlockverify = false;

	@Test
	public void AppLockPinSetupWithpermissionclick() throws Exception {
		exrapplockwithpermissions.exreportopen();
		Thread.sleep(5000);
		exrapplockwithpermissions.redgreenappopen(driver);
		Thread.sleep(5000);
		gotit.click();
		Thread.sleep(5000);
		exrapplockwithpermissions.splashscreenverification(driver);
		Thread.sleep(5000);
		allowphotosandmedia.click();
		Thread.sleep(5000);
		allowphones.click();
		Thread.sleep(5000);
		exrapplockwithpermissions.allowphotosmediaandphonespermissionsallow(driver);
		Thread.sleep(5000);

		try {
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
					/*vysorlock.click();
					WebDriverWait wait2 = new WebDriverWait(driver, 25);
					wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
					String atoastmessage2 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
					System.out.println(atoastmessage2);
					Thread.sleep(8000);
				/*	driver.findElement(By.xpath("//android.widget.TextView[@text='SYSTEM APPS']")).click();
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

					//Activity activity = new Activity("com.android.calculator2", "com.android.calculator2.Calculator");
					//Thread.sleep(5000);
					//activity.setStopApp(false);
					//driver.startActivity(activity);*/
					Thread.sleep(5000);
					driver.activateApp("com.koushikdutta.vysor");
					
					
				    
					Thread.sleep(5000);
					for (int j = 0; j < 4; j++) {
						pinnumbertwo.click();
						Thread.sleep(5000);
					}
					driver.navigate().back();
					driver.navigate().back();
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
		exrapplockwithpermissions.exreportclose();
	}

	public void closeApp() throws IOException, InterruptedException {
		driver.closeApp();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
