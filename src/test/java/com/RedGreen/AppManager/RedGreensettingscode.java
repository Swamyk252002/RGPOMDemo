package com.RedGreen.AppManager;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import com.ExtentReports.ExtentReportSettings;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class RedGreensettingscode {
	protected AndroidDriver<AndroidElement> driver;

	public RedGreensettingscode(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='PREFERENCES']")
	private AndroidElement SettingsPreference;

	@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/appsAutoLock']")
	private AndroidElement AutomaticallyLockappsoninstall;

	@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/appsAutoLock']")
	private AndroidElement AutomaticallyLockappsoninstallbuttonon;

	@AndroidFindBy(xpath = "//*[@text='OK']")
	private AndroidElement SetAppLockok;

	@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/tutorialSwitch']")
	private AndroidElement Tutorials;

	@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/tutorialSwitch']")
	private AndroidElement Tutorialson;

	@AndroidFindBy(xpath = "//*[@text='RATE US ON GOOGLE PLAY']")
	private AndroidElement Rateusongoogleplay;

	@AndroidFindBy(xpath = "//*[@text='RECOMMEND US']")
	private AndroidElement Recommendus;

	@AndroidFindBy(xpath = "//*[@text='Messages']")
	private AndroidElement Messages;

	@AndroidFindBy(xpath = "//*[@text='NEW MESSAGE']")
	private AndroidElement Newmessages;

	@AndroidFindBy(xpath = "//*[@class='android.widget.MultiAutoCompleteTextView']")
	private AndroidElement Phonenumber;

	@AndroidFindBy(xpath = "//*[@resource-id='com.google.android.apps.messaging:id/contact_picker_create_group']")
	private AndroidElement Sendtonumber;

	// @AndroidFindBy(xpath = "//*[@class='android.widget.LinearLayout']")
	// private AndroidElement Sendtonumber1;

	@AndroidFindBy(xpath = "//*[@text ='SMS']")
	private AndroidElement Send;

	@AndroidFindBy(xpath = "//*[@text='Gmail']")
	private AndroidElement Gmail;

	@AndroidFindBy(xpath = "//*[@resource-id ='com.google.android.gm:id/to']")
	private AndroidElement Toselect;

	@AndroidFindBy(xpath = "//*[@resource-id ='com.google.android.gm:id/send']")
	private AndroidElement Sendbutton;

	@AndroidFindBy(xpath = "//*[@text ='Copy to clipboard']")
	private AndroidElement Clipboard;

	@AndroidFindBy(xpath = "//*[@text ='Save to Drive']")
	private AndroidElement Savetodrive;

	@AndroidFindBy(xpath = "//*[@text ='I tried.txt']")
	private AndroidElement Documenttitle;

	@AndroidFindBy(xpath = "//*[@text ='SAVE']")
	private AndroidElement Savebutton;

	@AndroidFindBy(xpath = "//*[@text='GOT IT']")
	private AndroidElement gotit;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphoto;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphone;

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
	@AndroidFindBy(xpath = "//*[@text='GET APP LOCK PASSWORD']")
	private AndroidElement getapplockpassword;
	@AndroidFindBy(xpath = "//*[@text='Forgot Password?']")
	private AndroidElement forgotpasswordtext;
	@AndroidFindBy(xpath = "//*[@text='SEND']")
	private AndroidElement sendbuttonclick;

	@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/appsAutoLock']")
	private AndroidElement togglebuttonon;
    
	
	@AndroidFindBy(xpath = "//*[@text='Please']")
	AndroidElement pleaseentercorrectpassword;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphotosandmedia;
	@AndroidFindBy(xpath = "//*[@text='ALLOW']")
	private AndroidElement allowphones;
	@AndroidFindBy(xpath = "//*[@text='ABOUT US']")
	private AndroidElement aboutus;
	@AndroidFindBy(xpath = "//*[@text='UnfoldLabs Inc']")
	private AndroidElement unfoldlabs;
	@AndroidFindBy(xpath = "//*[@text='TERMS OF SERVICE']")
	private AndroidElement termsofservice;
	@AndroidFindBy(xpath = "//*[@text='android.widget.ImageButton']")
	private AndroidElement backbutton;
	@AndroidFindBy(xpath = "//*[@text='CONTACT US']")
	private AndroidElement contactus;
	@AndroidFindBy(xpath = "//*[@text='Gmail']")
	private AndroidElement gamil;
	@AndroidFindBy(xpath = "//*[@resource-id='com.google.android.gm:id/send']")
	private AndroidElement gamilsend;
	@AndroidFindBy(xpath = "//*[@Class='android.view.View']")
	private AndroidElement composeemail;
	@AndroidFindBy(xpath = "//*[@text='Subject']")
	private AndroidElement subjectemail;
	@AndroidFindBy(xpath = "//*[@text='SecureME']")
	private AndroidElement secureme;
	@AndroidFindBy(xpath = "//*[@resource-id='com.unfoldlabs.redgreen:id/recommendUsItemDownloadIV']")
	private AndroidElement download;
	@AndroidFindBy(xpath = "//*[@text='Install']")
	private AndroidElement install;
	@AndroidFindBy(xpath = "//*[@text='Open']")
	private AndroidElement open;
	@AndroidFindBy(xpath = "//*[@text='Exit App']")
	private AndroidElement exit;
	@AndroidFindBy(xpath = "//*[@text=' UnfoldPrints']")
	private AndroidElement unfoldprints;
	@AndroidFindBy(xpath = "//*[@text=' 2020AppLock']")
	private AndroidElement uflapplock;
	@AndroidFindBy(xpath = "//*[@text=' MobileSwitch']")
	private AndroidElement mobileswitch;
	@AndroidFindBy(xpath = "//*[@text=' 2020Wallet']")
	private AndroidElement uflwallet;
	@AndroidFindBy(xpath = "//*[@text='MyFamily']")
	private AndroidElement myfamily;
	@AndroidFindBy(xpath = "//*[@text='Cancel']")
	private AndroidElement cancel;
	
	
	ExtentReportSettings exrrunsettings = new ExtentReportSettings();

	@Test
	public void Preferencesclickpass() throws Exception {
   
		exrrunsettings.exreportopen();
		gotit.click();
		Thread.sleep(5000);
		allowphoto.click();
		Thread.sleep(5000);
		allowphone.click();
		// exrrunspeedbooster.splashscreenverification(driver);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Thread.sleep(5000);
	
		
		WebElement drag = driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
		Dimension d1 = drag.getSize();
		int start_x = (int) (d1.width * 0.5);
		int start_y = (int) (d1.height * 0.8);
		int end_x = (int) (d1.width * 0.5);
		int end_y = (int) (d1.height * 0.1);
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(end_x, end_y)).release().perform();

		try {
			SettingsPreference.isDisplayed();
			Thread.sleep(5000);
			SettingsPreference.click();
			Thread.sleep(5000);
			exrrunsettings.Preferenceslickpass(driver);
		} catch (Exception e) {
			exrrunsettings.Preferencesnotfound(driver);
		}

		// Automatically Lock apps on install toggle button
		try {
			driver.findElement(By.xpath("//*[contains(@text,'Automatically')]")).isDisplayed();

			try {
				String s = driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked");
				Thread.sleep(5000);
				exrrunsettings.AutomaticallyLockappsoninstallnotenable(driver);

				System.out.println("Automatically Lock apps on install toggle button is Enabled ");
				Thread.sleep(5000);

			} catch (Exception ex) {
				System.out.println("Automatically Lock apps on install toggle button is Disabled");
				exrrunsettings.Togglebuttonenablefailed(driver);
			}

			try {
				driver.findElement(By.xpath("(//*[@checked='true'])[1]")).click();

				String sap = driver.findElement(By.xpath("//*[contains(@text,'Password to enable')]")).getText();

				System.out.println("App Msg :" + sap);
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[@text='OK']")).click();

				try {
					driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked").equals("false");
					System.out.println("Toggle button is disbled");
					Thread.sleep(5000);
				} catch (Exception ex) {
					System.out.println("Fail cond for Automatically name not displaying");
					exrrunsettings.AutomaticallyLockappsoninstalloff(driver);
				}

			} catch (Exception e) {
				System.out.println("Toggle button not displaying");
				exrrunsettings.AutomaticallyLockappsoninstallnotfound(driver);
			}

		} catch (Exception e) {
			// Fail cond for Automatically name not displaying
			System.out.println("Fail cond for Automatically name not displaying");
		}

		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);

		WebElement drag2 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[4]"));
		Dimension d3 = drag.getSize();
		int start_x2 = (int) (d1.width * 0.5);
		int start_y2 = (int) (d1.height * 0.2);
		int end_x2 = (int) (d1.width * 0.5);
		int end_y2 = (int) (d1.height * 0.8);
		TouchAction ta2 = new TouchAction(driver);
		ta2.press(PointOption.point(start_x2, start_y2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(end_x2, end_y2)).release().perform();
		Thread.sleep(5000);

		// applock settings
		try {
			applock.isDisplayed();
			applock.click();
			Thread.sleep(5000);
			exrrunsettings.applockclickpass(driver);

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
				exrrunsettings.applockpermissionspass(driver);

			} catch (Exception ex) {
				vysorlock.isDisplayed();

			}

			try {
				vysorlock.click();
				for (int i = 0; i < 4; i++) {
					pinnumbertwo.click();
					Thread.sleep(5000);
				}
				nextbutton.click();
				for (int i = 0; i < 4; i++) {
					pinnumbertwo.click();
					Thread.sleep(5000);
				}
				nextbutton.click();
				allowpermission.click();
				Thread.sleep(5000);
				email.sendKeys("deepthik@ctrlaltfix.co");
				Thread.sleep(5000);
				emaildone.click();
				Thread.sleep(5000);
				exrrunsettings.pinsetuppass(driver);
				Thread.sleep(10000);
				driver.navigate().back();
				Thread.sleep(5000);
				try {
					SettingsPreference.isDisplayed();
					Thread.sleep(5000);
					SettingsPreference.click();
					Thread.sleep(5000);
					exrrunsettings.Preferenceslickpass(driver);
				} catch (Exception e) {
					exrrunsettings.Preferencesnotfound(driver);
				}

				try {
					driver.findElement(By.xpath("//*[contains(@text,'Automatically')]")).isDisplayed();

					try {
						String s = driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked");
						Thread.sleep(5000);
						exrrunsettings.AutomaticallyLockappsoninstallnotenable(driver);

						System.out.println("Toggle button is Enabled ");
						Thread.sleep(5000);
					} catch (Exception ex) {
						// System.out.println("");
						exrrunsettings.AutomaticallyLockappsoninstallnotfound(driver);

					}

					try {
						driver.findElement(By.xpath("(//*[@checked='true'])[1]")).click();

						System.out.println("Toggle button is disbled");
						Thread.sleep(5000);
						try {
							driver.findElement(By.xpath("(//*[@checked='true'])[1]")).getAttribute("checked")
									.equals("false");
							System.out.println("Toggle button is disble");
							Thread.sleep(5000);
							try {
								togglebuttonon.isDisplayed();
								Thread.sleep(5000);
								togglebuttonon.click();
								Thread.sleep(5000);
								driver.navigate().back();
								Thread.sleep(5000);

							} catch (Exception ex) {
								exrrunsettings.Togglebuttonfailed(driver);

							}
						} catch (Exception ex) {
							driver.findElement(By.xpath("//*[@text='OK']")).click();
							Thread.sleep(5000);
							System.out.println("Fail cond for Automatically name not displaying");
							exrrunsettings.AutomaticallyLockappsoninstalloff(driver);
						}

					} catch (Exception e) {
						Thread.sleep(5000);
						System.out.println("Toggle not displaying");
						exrrunsettings.AutomaticallyLockappsoninstallnotfound(driver);
					}

				} catch (Exception e) {
					// Fail cond for Automatically name not displaying
					System.out.println("Fail cond for Automatically name not displaying");
				}

			} catch (Exception ex) {
				System.out.println("Fail cond for Automatically name not displaying");

			}

		} catch (Exception ex) {
			exrrunsettings.pinsetupfail(driver);
			System.out.println("Fail cond for Automatically name not displaying");

		}

		WebElement drag1 = driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
		Dimension d2 = drag.getSize();
		int start_x1 = (int) (d1.width * 0.5);
		int start_y1 = (int) (d1.height * 0.8);
		int end_x1 = (int) (d1.width * 0.5);
		int end_y1 = (int) (d1.height * 0.1);
		TouchAction ta1 = new TouchAction(driver);
		ta1.press(PointOption.point(start_x1, start_y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(end_x1, end_y1)).release().perform();

		try {
			SettingsPreference.isDisplayed();
			Thread.sleep(5000);
			SettingsPreference.click();
			Thread.sleep(5000);
			exrrunsettings.Preferenceslickpass(driver);
		} catch (Exception e) {
			exrrunsettings.Preferencesnotfound(driver);
		}

		// Tutorial Functionality checking

		try {
			Tutorials.isDisplayed();
			Thread.sleep(5000);
			Tutorials.click();
			Thread.sleep(5000);
			exrrunsettings.Tutorialsoff(driver);
			Thread.sleep(5000);
			try {
				Tutorials.click();
				Thread.sleep(5000);
				exrrunsettings.Tutorialson(driver);
				Thread.sleep(5000);
				driver.navigate().back();

			} catch (Exception e) {
				exrrunsettings.Tutorialsfail(driver);
			}

		} catch (Exception e) {
			exrrunsettings.Tutorialsfail(driver);
		}
		Thread.sleep(5000);

		// Rate us on google play

		try {
			Rateusongoogleplay.isDisplayed();
			Thread.sleep(5000);
			Rateusongoogleplay.click();
			Thread.sleep(5000);
			exrrunsettings.Rateusongoogleplaypass(driver);
			Thread.sleep(5000);
			//WebElement we = driver.findElement(By.xpath("//*[@class='android.view.View']"));
			WebElement we = driver.findElement(By.xpath("(//*[@class='android.support.v7.widget.RecyclerView'])[1]"));
			
			Dimension d4 = we.getSize();
			int start_x4 = (int) (d1.width * 0.5);
			int start_y4 = (int) (d1.height * 0.8);
			int end_x4 = (int) (d1.width * 0.5);
			int end_y4 = (int) (d1.height * 0.1);
			TouchAction ta4 = new TouchAction(driver);
			ta4.press(PointOption.point(start_x4, start_y4)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(end_x4, end_y4)).release().perform();
			exrrunsettings.touchactions(driver);
			Thread.sleep(5000);
			driver.navigate().back();
		} catch (Exception e) {
			exrrunsettings.Rateusongoogleplayfail(driver);
		}

		// Recommned us for select Meassges
		try {
			Recommendus.isDisplayed();
			Thread.sleep(5000);
			Recommendus.click();
			Thread.sleep(5000);
			exrrunsettings.Recommenduspass(driver);
			Thread.sleep(5000);
			try {
				Thread.sleep(10000);
				Messages.click();
				Thread.sleep(5000);
				exrrunsettings.Messagespass(driver);
				Thread.sleep(5000);
				try {
					// Newmessages.isDisplayed();
					Thread.sleep(10000);
					Newmessages.click();
					Thread.sleep(5000);
					exrrunsettings.NewMessagespass(driver);
					Thread.sleep(5000);
					try {
						driver.findElement(By
								.xpath("//*[@resource-id='com.google.android.apps.messaging:id/recipient_text_view']"))
								.sendKeys("9121414017");

						((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

						Thread.sleep(5000);

						driver.findElement(By.xpath(
								"//*[@resource-id='com.google.android.apps.messaging:id/send_message_button_icon']"))
								.click();
						driver.navigate().back();
						Thread.sleep(5000);
						driver.navigate().back();
						Thread.sleep(5000);
					} catch (Exception e) {
						exrrunsettings.Sendbuttonfail(driver);
						Thread.sleep(5000);
					}

				} catch (Exception e) {
					exrrunsettings.NewMessagesfail(driver);
					Thread.sleep(5000);
				}

			} catch (Exception e) {
				exrrunsettings.Messagesfail(driver);
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			exrrunsettings.Recommendusfail(driver);
			Thread.sleep(5000);
		}

		// Recommened us functionality for gmail

		try {
			Recommendus.isDisplayed();
			Thread.sleep(5000);
			Recommendus.click();
			Thread.sleep(5000);
			exrrunsettings.Recommenduspass(driver);
			Thread.sleep(5000);
			try {
				Gmail.isDisplayed();
				Gmail.click();
				Thread.sleep(5000);
				try {
					Toselect.isDisplayed();
					Toselect.click();
					Thread.sleep(5000);
					Toselect.sendKeys("deepthik@ctrlaltfix.co");
					Thread.sleep(5000);
					try {
						Sendbutton.isDisplayed();
						Sendbutton.click();

					} catch (Exception e) {
						exrrunsettings.Sendbuttonfail(driver);
						Thread.sleep(5000);
					}

				} catch (Exception e) {
					exrrunsettings.Toselectfail(driver);
					Thread.sleep(5000);
				}

			} catch (Exception e) {
				exrrunsettings.Gmailselectfail(driver);
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			exrrunsettings.Recommendusfail(driver);
			Thread.sleep(5000);
		}

		// Recommend us copy clipboard

		try {
			Recommendus.isDisplayed();
			Thread.sleep(5000);
			Recommendus.click();
			Thread.sleep(5000);
			exrrunsettings.Recommenduspass(driver);
			Thread.sleep(5000);
			try {
				Clipboard.isDisplayed();
				Thread.sleep(5000);
				Clipboard.click();
				WebDriverWait wait = new WebDriverWait(driver, 25);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
				String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
				System.out.println(atoastmessage);
				exrrunsettings.Clipboardpass(driver);
				Thread.sleep(5000);

			} catch (Exception e) {
				exrrunsettings.Clipboardbuttonfail(driver);
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			exrrunsettings.Recommendusfail(driver);
			Thread.sleep(5000);
		}

		// Recommened us save to drive
		try {
			Recommendus.isDisplayed();
			Thread.sleep(5000);
			Recommendus.click();
			Thread.sleep(5000);
			exrrunsettings.Recommenduspass(driver);
			Thread.sleep(5000);
			try {
				Savetodrive.isDisplayed();
				Thread.sleep(5000);
				Savetodrive.click();
				Thread.sleep(5000);
				exrrunsettings.Savepass(driver);
				Thread.sleep(5000);
				try {
					Documenttitle.isDisplayed();
					Thread.sleep(5000);
					Documenttitle.click();
					Thread.sleep(5000);
					exrrunsettings.Documenttittlepass(driver);
					Thread.sleep(5000);
					try {
						Savebutton.isDisplayed();
						Thread.sleep(5000);
						Savebutton.click();
						WebDriverWait wait = new WebDriverWait(driver, 25);
						wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
						String atoastmessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast"))
								.getText();
						System.out.println(atoastmessage);
						exrrunsettings.Savepass(driver);
						Thread.sleep(5000);
					} catch (Exception e) {
						exrrunsettings.Savebuttonfail(driver);
						Thread.sleep(5000);
					}

				} catch (Exception e) {
					exrrunsettings.Documenttittlebuttonfail(driver);
					Thread.sleep(5000);
				}

			} catch (Exception e) {
				exrrunsettings.Clipboardbuttonfail(driver);
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			exrrunsettings.Recommendusfail(driver);
			Thread.sleep(5000);
		}
		WebElement drag3 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[4]"));
		Dimension d4 = drag.getSize();
		int start_x3 = (int) (d1.width * 0.5);
		int start_y3 = (int) (d1.height * 0.2);
		int end_x3 = (int) (d1.width * 0.5);
		int end_y3 = (int) (d1.height * 0.8);
		TouchAction ta3 = new TouchAction(driver);
		ta3.press(PointOption.point(start_x3, start_y3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(end_x3, end_y3)).release().perform();
		Thread.sleep(5000);
		
	}
	public void GetAppLockPasswordclick() throws Exception {
		Thread.sleep(5000);
		WebElement drag = driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
		Dimension d1 = drag.getSize();
		int start_x = (int) (d1.width * 0.5);
		int start_y = (int) (d1.height * 0.8);
		int end_x = (int) (d1.width * 0.5);
		int end_y = (int) (d1.height * 0.1);
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(end_x, end_y)).release().perform();
		Thread.sleep(5000);

		try {
			getapplockpassword.isDisplayed();
			getapplockpassword.click();
			Thread.sleep(5000);
			exrrunsettings.getapplockpasswordclick(driver);
			try {
				Thread.sleep(5000);
				email.sendKeys("bhanupriyam@ctrlaltfix.co");
				Thread.sleep(5000);
				sendbuttonclick.click();
				/*
				 * WebDriverWait wait2 = new WebDriverWait(driver, 25);
				 * wait2.until(ExpectedConditions
				 * .presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
				 * String atoastmessage2 =
				 * driver.findElement(By.xpath("/hierarchy/android.widget.Toast")) .getText();
				 * System.out.println(atoastmessage2);
				 */
				Thread.sleep(5000);
				exrrunsettings.pinsetupspass(driver);
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(5000);
				
				exrrunsettings.getapplockpass(driver);

			} catch (Exception ex) {
				try {
					// forgotpassword.isDisplayed();
					email.sendKeys("bhanupriyam@ctrlaltfix.co");
					sendbuttonclick.click();
					Thread.sleep(5000);
					applockpermissionok.click();
					Thread.sleep(5000);
					driver.navigate().back();
					Thread.sleep(5000);
					exrrunsettings.forgotpasswordspass(driver);

					WebElement drag1 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[4]"));
					Dimension d2 = drag.getSize();
					int start_x1 = (int) (d1.width * 0.5);
					int start_y1 = (int) (d1.height * 0.2);
					int end_x1 = (int) (d1.width * 0.5);
					int end_y1 = (int) (d1.height * 0.8);
					TouchAction ta1 = new TouchAction(driver);
					ta.press(PointOption.point(start_x1, start_y1))
							.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
							.moveTo(PointOption.point(end_x1, end_y1)).release().perform();
					Thread.sleep(5000);
					try {
						applock.isDisplayed();
						applock.click();
						Thread.sleep(5000);
						exrrunsettings.applockclickpass(driver);

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
							exrrunsettings.applockpermissionspass(driver);

						} catch (Exception ex1) {
							vysorlock.isDisplayed();

						}

						try {
							vysorlock.click();
							for (int i = 0; i < 4; i++) {
								pinnumbertwo.click();
								Thread.sleep(5000);
							}
							nextbutton.click();
							for (int i = 0; i < 4; i++) {
								pinnumbertwo.click();
								Thread.sleep(5000);
							}
							nextbutton.click();
							allowpermission.click();
							Thread.sleep(5000);
							email.sendKeys("bhanupriyam@ctrlaltfix.co");
							Thread.sleep(5000);
							emaildone.click();
							Thread.sleep(5000);
							driver.navigate().back();
							Thread.sleep(5000);
							exrrunsettings.pinsetupspass(driver);

							WebElement drag5 = driver
									.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
							Dimension d5 = drag.getSize();
							int start_x5 = (int) (d1.width * 0.5);
							int start_y5 = (int) (d1.height * 0.8);
							int end_x5 = (int) (d1.width * 0.5);
							int end_y5 = (int) (d1.height * 0.1);
							TouchAction ta5 = new TouchAction(driver);
							ta5.press(PointOption.point(start_x, start_y))
									.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
									.moveTo(PointOption.point(end_x, end_y)).release().perform();
							Thread.sleep(5000);
												} catch (Exception ex3) {
							exrrunsettings.pinsetupfail(driver);

						}

					} catch (Exception ex1) {
						exrrunsettings.applockclickfail(driver);

					}

				} catch (Exception ex2) {
					exrrunsettings.forgotpasswordfail(driver);

				}

				exrrunsettings.getapplockfail(driver);

			}


					} catch (Exception ex) {
			exrrunsettings.getapplockpasswordclickfail(driver);

		}

	}

	public void aboutusclick() throws Exception {

		/*
		 * WebElement drag =
		 * driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]")
		 * ); Dimension d1 = drag.getSize(); int start_x = (int) (d1.width * 0.5); int
		 * start_y = (int) (d1.height * 0.8); int end_x = (int) (d1.width * 0.5); int
		 * end_y = (int) (d1.height * 0.1); TouchAction ta = new TouchAction(driver);
		 * ta.press(PointOption.point(start_x,
		 * start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		 * .moveTo(PointOption.point(end_x, end_y)).release().perform();
		 * Thread.sleep(5000);
		 */
		try {
			aboutus.click();
			exrrunsettings.aboutusclickpass(driver);

			try {
				termsofservice.click();
				Thread.sleep(30000);
				exrrunsettings.termsofservicesclickpass(driver);
				WebElement drag = driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
				Dimension d1 = drag.getSize();
				int start_x = (int) (d1.width * 0.5);
				int start_y = (int) (d1.height * 0.8);
				int end_x = (int) (d1.width * 0.5);
				int end_y = (int) (d1.height * 0.1);
				TouchAction ta = new TouchAction(driver);
				ta.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
				Thread.sleep(5000);
				WebElement we2 = driver.findElement(By.xpath("//*[@class='android.webkit.WebView']"));
				Dimension d3 = we2.getSize();
				//System.out.print(d1);
				int start_x3 = (int) (d1.width * 0.30);
				int start_y3 = (int) (d1.height * 0.40);
				int end_x3 = (int) (d1.width * 0.30);
				int end_y3 = (int) (d1.height * 0.40);
				TouchAction ta3 = new TouchAction(driver);
				ta3.press(PointOption.point(start_x3, start_y3))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
				Thread.sleep(5000);
				WebElement we3 = driver.findElement(By.xpath("//*[@class='android.webkit.WebView']"));
				Dimension d4 = we3.getSize();
				//System.out.print(d1);
				int start_x4 = (int) (d1.width * 0.5);
				int start_y4 = (int) (d1.height * 0.8);
				int end_x4 = (int) (d1.width * 0.5);
				int end_y4 = (int) (d1.height * 0.1);
				TouchAction ta4 = new TouchAction(driver);
				ta4.press(PointOption.point(start_x4, start_y4))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
				Thread.sleep(5000);
				exrrunsettings.touchactions(driver);
				driver.navigate().back();
				Thread.sleep(10000);
				try {
					contactus.click();
					Thread.sleep(5000);
					exrrunsettings.contactusclickpass(driver);
					gamil.click();
					Thread.sleep(10000);
					subjectemail.sendKeys("Contact Me");
					Thread.sleep(5000);
					exrrunsettings.mailcomposedpass(driver);
					// composeemail.sendKeys("Please contact me on this no: 9959039554");
					// Thread.sleep(5000);
					gamilsend.click();
					Thread.sleep(5000);
					exrrunsettings.mailsentass(driver);
					try {
						secureme.isDisplayed();
						secureme.click();

						try {
							download.click();
							Thread.sleep(15000);
							exrrunsettings.downloadclickpass(driver);

							try {
								open.isDisplayed();
								open.click();
								exrrunsettings.appopenpass(driver);
							} catch (Exception ex) {
								install.isDisplayed();
								Thread.sleep(20000);
								install.click();
								exrrunsettings.appinstallpass(driver);
								Thread.sleep(50000);		
								cancel.click();
								Thread.sleep(20000);
								open.click();
								Thread.sleep(20000);
								exrrunsettings.appopenpass(driver);
								}
								try {
									exit.click();
									Thread.sleep(5000);
									driver.navigate().back();
									Thread.sleep(5000);
									secureme.click();
									Thread.sleep(10000);

									try {
										unfoldprints.click();
										exrrunsettings.unfoldprintspass(driver);
										Thread.sleep(15000);
										unfoldprints.click();
										Thread.sleep(5000);
										uflapplock.click();
										exrrunsettings.uflapplockpass(driver);
										Thread.sleep(10000);
										uflapplock.click();
										Thread.sleep(5000);
										WebElement dragau = driver.findElement(
												By.xpath("(//*[@class='android.widget.LinearLayout'])[1]"));
										Dimension d1au = drag.getSize();
										int start_xau = (int) (d1.width * 0.5);
										int start_yau = (int) (d1.height * 0.8);
										int end_xau = (int) (d1.width * 0.5);
										int end_yau = (int) (d1.height * 0.1);
										TouchAction tau = new TouchAction(driver);
										ta.press(PointOption.point(start_x, start_y))
												.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
												.moveTo(PointOption.point(end_x, end_y)).release().perform();
										Thread.sleep(5000);
										mobileswitch.click();
										exrrunsettings.mobileswitchpass(driver);
										Thread.sleep(10000);
										mobileswitch.click();
										Thread.sleep(5000);
										uflwallet.click();
										exrrunsettings.uflwalletpass(driver);
										Thread.sleep(10000);
										uflwallet.click();
										Thread.sleep(5000);
										myfamily.click();
										exrrunsettings.myfamilypass(driver);
										Thread.sleep(10000);
										myfamily.click();
										Thread.sleep(5000);
										driver.navigate().back();
										Thread.sleep(5000);
										driver.navigate().back();

									} catch (Exception ex) {
										exrrunsettings.unfoldprintsfail(driver);
									}
								} catch (Exception ex) {
									exrrunsettings.exitappfail(driver);
								}
							

						} catch (Exception ex) {
							exrrunsettings.downloadclickfail(driver);

						}

					} catch (Exception ex) {
						exrrunsettings.securemeclickfail(driver);

					}

				} catch (Exception ex) {
					exrrunsettings.contactusclickfail(driver);

				}
			} catch (Exception ex) {
				exrrunsettings.termsofservicesclickfail(driver);

			}

		} catch (Exception ex) {
			exrrunsettings.aboutusclickfail(driver);

		}
		exrrunsettings.exreportclose();
	}


	@AfterTest
	public void closeapp() throws IOException {
		driver.closeApp();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}
}
