package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartLoginPage {
	
		@FindBy ( xpath = "(//input[@type='text'])[2]")
		private WebElement emailId ;
		
		@FindBy ( xpath = "//input[@type='password']")
		private WebElement password ;
		
		@FindBy ( xpath = "(//span[text()='Login'])[2]")
		private WebElement login ;
		
		public FlipKartLoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void sendOnEmailId(String email) {
			//emailId.sendKeys("tushar.more35@gmail.com");
			emailId.sendKeys(email);
		}
		
		public void sendOnPassword(String pass) {
			//password.sendKeys("Tushar777");
			password.sendKeys(pass);
		}
		
		public void clickOnLoginButton() {
			login.click();
		}

}
