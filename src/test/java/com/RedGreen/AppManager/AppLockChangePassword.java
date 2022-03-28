package com.RedGreen.AppManager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExtentReports.ExtentReportAppLockChangePassword;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLockChangePassword {
	AndroidDriver<AndroidElement> driver;

	/*
	 * Open RedGreen App Validating Splash Screens Clicking on App Lock Module and
	 * Verify the Change password functionality
	 */

	public AppLockChangePassword(AndroidDriver<AndroidElement> driver) {
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
	@AndroidFindBy(xpath = "//*[@text='2']")
	AndroidElement pinnumberone;
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
	@AndroidFindBy(xpath = "//*[@text='Change Password']")
	AndroidElement changepassword;
	@AndroidFindBy(xpath = "//*[@text='GOT IT']")
	private AndroidElement gotit;
	@AndroidFindBy(xpath = "//*[@text='Please']")
	AndroidElement pleaseentercorrectpassword;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphotosandmedia;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphones;

	ExtentReportAppLockChangePassword exrapplockchangepassword = new ExtentReportAppLockChangePassword();

	public void AppLockChangePasswordclick() throws Exception {
		exrapplockchangepassword.exreportopen();
		Thread.sleep(5000);
		exrapplockchangepassword.redgreenappopen(driver);
		Thread.sleep(5000);
		gotit.click();
		Thread.sleep(5000);
		exrapplockchangepassword.splashscreenverification(driver);
		Thread.sleep(5000);
		allowphotosandmedia.click();
		Thread.sleep(5000);
		allowphones.click();
		Thread.sleep(5000);
		exrapplockchangepassword.allowphotosmediaandphonespermissionsallow(driver);
		Thread.sleep(5000);

		try {
			applock.isDisplayed();
			applock.click();
			Thread.sleep(5000);
			exrapplockchangepassword.applockclickpass(driver);

			Boolean changepasswordverify = false;

			try {
				applockpermission.isDisplayed();
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
				driver.findElementByAccessibilityId("Settings").click();
				Thread.sleep(5000);
				changepassword.click();
				Thread.sleep(5000);
				changepasswordverify = true;
				if (changepasswordverify == true) {
					exrapplockchangepassword.applockchangepasswordtextverifypass(driver);
				} else {
					exrapplockchangepassword.applockchangepasswordtextverifyfail(driver);
				}
				Thread.sleep(5000);
				nextbutton.click();
				WebDriverWait wait = new WebDriverWait(driver, 25);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
				String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
				System.out.println(atoastmessage);
				exrapplockchangepassword.applockcwithoupinpass(driver);
				
				for (int i = 0; i < 4; i++) {
					pinnumbertwo.click();
				}
				nextbutton.click();
				Thread.sleep(5000);
				for (int j = 0; j < 4; j++) {
					pinnumbertwo.click();
				}
				nextbutton.click();
				Thread.sleep(5000);
				allowpermission.click();
				Thread.sleep(5000);
				// Email Id
				email.sendKeys("bhanupriyam@ctrlaltfix.co");
				Thread.sleep(5000);
				emaildone.click();
				Thread.sleep(5000);
				unlockapp.click();
				WebDriverWait wait1 = new WebDriverWait(driver, 25);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
				String atoastmessage1 = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
				System.out.println(atoastmessage1);
				exrapplockchangepassword.applockcwithoupinpass(driver);
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(5000);
				exrapplockchangepassword.applockcchangepasswordpass(driver);
				exrapplockchangepassword.exreportclose();
			} catch (Exception ex) {
				driver.findElementByAccessibilityId("Settings").click();
				Thread.sleep(5000);
				changepassword.click();
				if (changepasswordverify == true) {
					exrapplockchangepassword.applockchangepasswordtextverifypass(driver);
				} else {
					exrapplockchangepassword.applockchangepasswordtextverifyfail(driver);
				}
				for (int i = 0; i < 4; i++) {
					pinnumbertwo.click();
				}
				nextbutton.click();
				Thread.sleep(5000);
				for (int j = 0; j < 4; j++) {
					pinnumbertwo.click();
				}
				nextbutton.click();
				Thread.sleep(5000);
				allowpermission.click();
				Thread.sleep(5000);
				email.sendKeys("bhanupriyam@ctrlaltfix.co");
				Thread.sleep(5000);
				emaildone.click();
				Thread.sleep(5000);
				unlockapp.click();
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(5000);
				exrapplockchangepassword.applockcchangepasswordpass(driver);
			}

		} catch (Exception ex) {
			exrapplockchangepassword.applockclickfail(driver);
			
		}
		exrapplockchangepassword.exreportclose();

	}

	public void closeApp() throws IOException, InterruptedException {
		driver.closeApp();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
