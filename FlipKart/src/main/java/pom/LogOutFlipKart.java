package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutFlipKart {
	
	@FindBy ( xpath = "(//div[@id='container']//div)[13]")
	private WebElement tusharProfile ;   //click on profile
	
	@FindBy ( xpath = "//div[text()='Logout']")
	private WebElement logout ;       //click on logout
	
	@FindBy ( xpath = "//div[text()='My Profile']")
	private WebElement profile ;   
	
	private WebDriver driver;
	private Actions actions;
	WebDriverWait wait;
	
	public LogOutFlipKart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver,20);
	}
	
	public void clickOnProfile() {
		//tusharProfile.click();
		//WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(tusharProfile));
		actions.moveToElement(tusharProfile).perform();
	}
	
//    public void clickOnProfileOption() {
//		
//		profile.click();
//	}
	
	public void clickOnLogoutOption() {
		
		logout.click();
	}
	
	

}
