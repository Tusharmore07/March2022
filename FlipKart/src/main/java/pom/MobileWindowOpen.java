package pom;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileWindowOpen {

	@FindBy ( xpath = "//input[@placeholder='Enter Delivery Pincode']")     
	private WebElement deliveryPincode ;   //enter delivery pincode
	
	@FindBy ( xpath = "//span[text()='Check']")     
	private WebElement pincodeCheckButton ;   //enter delivery pincode
	
	
	@FindBy ( xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCart ;      //mobile added in cart    411045
	
//	@FindBy (xpath = "//div[text()='Remove']")
//	private WebElement remove ;   //mobile remove button 
//	
//	@FindBy ( xpath = "//div[@class='row _1lPa3S']//div//div[2]")
//	private WebElement removeItem ;   //remove item to cart it is hidden popup
	
//	@FindBy ( xpath = "//input[contains(@title,'Search for')]")
//	private WebElement searchContext ;  //search bar 
//	
	private WebDriver driver ;
	
	public MobileWindowOpen(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
        }
	
		public void enterDeliveryPincode() {
			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			System.out.println(driver.getCurrentUrl());
			deliveryPincode.sendKeys("411045");
		}
		
		public void clickOnCheckPincodeButton() {
			pincodeCheckButton.click();
		}
		
		public void clickOnAddToCart() {
//			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(addr.get(1));
//			System.out.println(driver.getCurrentUrl());
			addToCart.click();	
		}
		
	
}
