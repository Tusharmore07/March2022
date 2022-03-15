package pom;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveMobilePage {
	
	@FindBy (xpath = "//div[text()='Remove']")  //div[text()='Remove']
	private WebElement remove ;   //mobile remove button 
	
	@FindBy ( xpath = "(//div[@id='container']//div)[9]")
	private WebElement removeItem ;   //remove item to cart it is hidden popup
	
    private WebDriver driver ;
	
	public RemoveMobilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
//		public void clickOnAddToCart() {
//			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(addr.get(1));
//			System.out.println(driver.getCurrentUrl());
//			addToCart.click();	
//		}
		
		public void clickOnRemove() {
			JavascriptExecutor js = (JavascriptExecutor)driver ;
			js.executeScript("arguments[0].scrollIntoView(true);",remove);
			remove.click();		
		}
		
		public void clickOnRemove(int a) {
			System.out.println(removeItem.getText());
			removeItem.click();
			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(0));
		}
	

}
