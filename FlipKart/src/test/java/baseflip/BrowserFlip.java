package baseflip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFlip {
	
	public static WebDriver luanchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","F:\\Velocity\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver luanchFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","F:\\Velocity\\Selenium\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver luanchEdgeBrowser() {
		System.setProperty("webdriver.edge.driver","F:\\Velocity\\msedgedriver.exe");
	    WebDriver driver = new EdgeDriver();
		return driver;
	}

}
