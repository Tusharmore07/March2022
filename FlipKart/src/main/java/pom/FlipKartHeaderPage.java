package pom;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartHeaderPage {

		@FindBy ( xpath = "//div[@class='_3qX0zy']")
		private WebElement flipKartLogo ;  //flipkart logo
		
		@FindBy ( xpath = "//input[contains(@title,'Search for')]")
		private WebElement search ;        //search bar
		
		@FindBy ( xpath = "//button[@class='L0Z3Pu']")
		private WebElement searchButton ;   //search button
		
		@FindBy ( xpath = "(//div[@id='container']//a)[16]")     
		private WebElement selectMobile ;   //mobile select
		
		//@FindBy ( xpath = "//a[text()='Login']")
		//private WebElement login ;   //login button
		
		//@FindBy ( xpath = "(//div[@class='_28p97w'])[2]")
		//private WebElement more ;    //more button
		
		//@FindBy ( xpath = "//span[text()='Cart']")
		//private WebElement cart ;    //cart logo
		
		//@FindBy (xpath = "//div[text()='Remove']")
		//private WebElement remove ;   //mobile remove button 
		
		//@FindBy ( xpath = "//div[@class='row _1lPa3S']//div//div[2]")
		//private WebElement removeItem ;   //remove item to cart it is hidden popup
		
		//@FindBy ( xpath = "//input[contains(@title,'Search for')]")
		//private WebElement searchContext ;  //search bar 
		
		//private WebDriver driver ;
		
		public FlipKartHeaderPage(WebDriver driver)     //Constructor
		{
			PageFactory.initElements(driver, this);
			//this.driver = driver ;
		}
		
		
		public void clickOnFlipKartLogo() {
			flipKartLogo.click();
		}
		
		public void sendSearchContext() {
			search.sendKeys("mobile under 10000");
		}
		
		public void clickOnSearchButton() {
			searchButton.click();
		}
		
	    public void clickOnMobile() {
			selectMobile.click();
			System.out.println(selectMobile.getText());
		}
		
		
}
