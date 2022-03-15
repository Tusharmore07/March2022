package testKart;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseflip.BrowserFlip;
import pom.FlipKartHeaderPage;
import pom.FlipKartLoginPage;


import pom.LogOutFlipKart;

import pom.MobileWindowOpen;
import pom.RemoveMobilePage;
import utils.Utility;

public class FlipKartTestNg extends BrowserFlip{
	
	private WebDriver driver;
	private FlipKartLoginPage flipKartLogin;
	private FlipKartHeaderPage flipKartHeaderPage;
	private MobileWindowOpen mobileWindow;
	private RemoveMobilePage removeMobile;
	private LogOutFlipKart logoutFlipKart;
	
	private String testId;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	 @BeforeTest
	 @Parameters("browser")
		public void launchBrowser(String browserName) {
		 reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);
			System.out.println("LaunchBrowser");
			if(browserName.equals("Chrome"))
			{
				driver = luanchChromeBrowser();
//			System.setProperty("webdriver.chrome.driver","F:\\Velocity\\Selenium\\chromedriver.exe");
//			
//		    driver = new ChromeDriver();
			}
			
			if(browserName.equals("Firefox"))
			{
				driver = luanchFirefoxBrowser();
//			System.setProperty("webdriver.gecko.driver","F:\\Velocity\\Selenium\\geckodriver.exe");
//			
//		    driver = new FirefoxDriver();
			}
			
			if(browserName.equals("Edge"))
			{
				driver = luanchEdgeBrowser();
//			System.setProperty("webdriver.edge.driver","F:\\Velocity\\msedgedriver.exe");
//			
//		    driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	@BeforeClass
	//public void launchBrowser(){
		 public void ceateObject() {
			 flipKartLogin = new FlipKartLoginPage(driver) ;
			 flipKartHeaderPage = new FlipKartHeaderPage(driver) ;
			 mobileWindow = new MobileWindowOpen(driver) ;
			 removeMobile = new RemoveMobilePage(driver) ;
			 logoutFlipKart = new LogOutFlipKart(driver);
//		System.out.println("LaunchBrowser");
//		System.setProperty("webdriver.chrome.driver", "F:\\Velocity\\Selenium\\chromedriver.exe");
//	    driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void loginToFlipKartApplication() throws InterruptedException, EncryptedDocumentException, IOException {
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		System.out.println("Login");
		//flipKartLogin = new FlipKartLoginPage(driver) ;
		String email = Utility.getDataFromExcelSheet("Tushar", 1, 0);
		String pass = Utility.getDataFromExcelSheet("Tushar", 1, 1);
		
		flipKartLogin.sendOnEmailId(email);
		flipKartLogin.sendOnPassword(pass);
		flipKartLogin.clickOnLoginButton();
		Thread.sleep(6000);
	}
	
	@Test
	public void flipKartMainWindow() throws InterruptedException {
		testId = "101";
		System.out.println("FlipKartMainWindow");
		//flipKartHeaderPage = new FlipKartHeaderPage(driver) ;
		
			flipKartHeaderPage.clickOnFlipKartLogo();
			Thread.sleep(3000);
			flipKartHeaderPage.sendSearchContext();
			Thread.sleep(3000);
			flipKartHeaderPage.clickOnSearchButton();
			Thread.sleep(3000);
			flipKartHeaderPage.clickOnMobile();
			Thread.sleep(3000);
		
	   // mobileWindow = new MobileWindowOpen(driver) ;
		    
			mobileWindow.enterDeliveryPincode();
			Thread.sleep(5000);
			mobileWindow.clickOnCheckPincodeButton();
			Thread.sleep(5000);
			mobileWindow.clickOnAddToCart();
			Thread.sleep(5000);
			
		//removeMobile = new RemoveMobilePage(driver) ;
			removeMobile.clickOnRemove();
			Thread.sleep(5000);
			removeMobile.clickOnRemove(1);
			Thread.sleep(7000);
	}
	
//	@Test(priority = 0)
//	public void mobileWindow() throws InterruptedException {
//		System.out.println("MobileWindow");
//	    mobileWindow = new MobileWindowOpen(driver) ;
//	    
//		mobileWindow.enterDeliveryPincode();
//		Thread.sleep(5000);
//		mobileWindow.clickOnCheckPincodeButton();
//		Thread.sleep(5000);
//		mobileWindow.clickOnAddToCart();
//		Thread.sleep(5000);
//	}
	
//	@Test(priority = 1)
//	public void mobileRemoveWindow() throws InterruptedException {
//		System.out.println("MobileRemoveWindow");
//	    removeMobile = new RemoveMobilePage(driver) ;
//		removeMobile.clickOnRemove();
//		Thread.sleep(5000);
//		removeMobile.clickOnRemove(1);
//		Thread.sleep(7000);
//	}
	
	@AfterMethod
	public void logOut(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.screenshot(driver, testId);
		}
		
		System.out.println("LogOut");
	   // logoutFlipKart = new LogOutFlipKart(driver);
		logoutFlipKart.clickOnProfile();
		Thread.sleep(7000);
		logoutFlipKart.clickOnLogoutOption();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void clearPOMObject() {
		 flipKartLogin = null;
		 flipKartHeaderPage = null;
		 mobileWindow = null;
		 removeMobile = null;
		 logoutFlipKart= null;
	}
//	public void closeBrowser() {
//		System.out.println("CloseBrowser");
//		driver.close();
//	}
	
	@AfterTest
	 public void closeBrowser() {
    	System.out.println("CloseBrowser");
    	
    	driver.quit();
    	driver = null;
    	System.gc();
    }

}
