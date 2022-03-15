package testKart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.FlipKartHeaderPage;
import pom.FlipKartLoginPage;
import pom.LogOutFlipKart;
import pom.MobileWindowOpen;
import pom.RemoveMobilePage;

public class TestFlipClass {
	
	public static void main(String[] args) throws InterruptedException {
	 	
		System.setProperty("webdriver.chrome.driver","F:\\Velocity\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		FlipKartLoginPage flipKartLogin = new FlipKartLoginPage(driver) ;
		
		flipKartLogin.sendOnEmailId(null);
		flipKartLogin.sendOnPassword(null);
		flipKartLogin.clickOnLoginButton();
		Thread.sleep(6000);
		
		FlipKartHeaderPage flipKartHeaderPage = new FlipKartHeaderPage(driver) ;
		
		
		flipKartHeaderPage.clickOnFlipKartLogo();
		Thread.sleep(3000);
		flipKartHeaderPage.sendSearchContext();
		Thread.sleep(3000);
		flipKartHeaderPage.clickOnSearchButton();
		Thread.sleep(3000);
		flipKartHeaderPage.clickOnMobile();
		Thread.sleep(3000);
		
		MobileWindowOpen mobileWindow = new MobileWindowOpen(driver) ;
		mobileWindow.enterDeliveryPincode();
		Thread.sleep(5000);
		mobileWindow.clickOnCheckPincodeButton();
		Thread.sleep(5000);
		mobileWindow.clickOnAddToCart();
		Thread.sleep(5000);
		
		RemoveMobilePage removeMobile = new RemoveMobilePage(driver) ;
		removeMobile.clickOnRemove();
		Thread.sleep(5000);
		removeMobile.clickOnRemove(1);
		Thread.sleep(7000);
	
		LogOutFlipKart logoutFlipKart = new LogOutFlipKart(driver);
		logoutFlipKart.clickOnProfile();
		Thread.sleep(7000);
		logoutFlipKart.clickOnLogoutOption();
		Thread.sleep(5000);
		//logoutFlipKart.clickOnProfileOption();
		
		//mobileWindow.clearSearchContext(2);
		
	}

}
