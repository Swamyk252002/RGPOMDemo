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

import com.ExtentReports.ExtentReportSettings;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class RedGreenSettingscode1 {
	AndroidDriver<AndroidElement> driver;

	/*
	 * Open RedGreen App Validating Splash Screens Clicking on App Lock Module and
	 * Verify the Change password functionality
	 */

	public RedGreenSettingscode1(AndroidDriver<AndroidElement> driver) {
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
	@AndroidFindBy(xpath = "//*[@text='GET APP LOCK PASSWORD']")
	private AndroidElement getapplockpassword;
	@AndroidFindBy(xpath = "//*[@text='Forgot Password?']")
	private AndroidElement forgotpasswordtext;
	@AndroidFindBy(xpath = "//*[@text='SEND']")
	private AndroidElement sendbuttonclick;
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

	public void GetAppLockPasswordclick() throws Exception {
		exrrunsettings.exreportopen();
		Thread.sleep(5000);
		exrrunsettings.redgreenappopen(driver);
		Thread.sleep(5000);
		gotit.click();
		Thread.sleep(5000);
		exrrunsettings.splashscreenverification(driver);
		allowphotosandmedia.click();
		Thread.sleep(5000);
		allowphones.click();
		// exrgetapplockpassword.allowphotosmediaandphonespermissionsallow(driver);
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
		Thread.sleep(5000);

		try {
			getapplockpassword.isDisplayed();
			getapplockpassword.click();
			Thread.sleep(5000);
			exrrunsettings.getapplockpasswordclick(driver);

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
						try {
							getapplockpassword.click();
							Thread.sleep(5000);
							email.sendKeys("bhanupriyam@ctrlaltfix.co");
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
							driver.navigate().back();
							Thread.sleep(5000);
							exrrunsettings.getapplockpass(driver);

						} catch (Exception ex) {
							exrrunsettings.getapplockfail(driver);

						}
					} catch (Exception ex) {
						exrrunsettings.pinsetupfail(driver);

					}

				} catch (Exception ex) {
					exrrunsettings.applockclickfail(driver);

				}

			} catch (Exception ex) {
				exrrunsettings.forgotpasswordfail(driver);

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
				Thread.sleep(25000);
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
				System.out.print(d1);
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
				System.out.print(d1);
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
										Thread.sleep(5000);
										unfoldprints.click();
										Thread.sleep(5000);
										uflapplock.click();
										exrrunsettings.uflapplockpass(driver);
										Thread.sleep(5000);
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
										Thread.sleep(5000);
										mobileswitch.click();
										Thread.sleep(5000);
										uflwallet.click();
										exrrunsettings.uflwalletpass(driver);
										Thread.sleep(5000);
										uflwallet.click();
										Thread.sleep(5000);
										myfamily.click();
										exrrunsettings.myfamilypass(driver);
										Thread.sleep(5000);
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

	public void closeApp() throws IOException, InterruptedException {
		driver.closeApp();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
