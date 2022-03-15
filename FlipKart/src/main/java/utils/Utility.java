package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void screenshot(WebDriver driver , String testId) throws InterruptedException, IOException {
//		System.setProperty("webdriver.chrome.driver","F:\\Velocity\\Selenium\\chromedriver.exe");
//		
//		WebDriver driver2 = new ChromeDriver();
//		
//		driver.get("https://paytm.com/");
//		
//		Thread.sleep(2000);
	Date date = new Date();	
	
	String dateTime = date.toString().replace(":","_").replace(" ","_")+".jpg";
		
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest = new File("F:\\New folder\\TR"+testId+dateTime+".jpg");
	
	FileHandler.copy(source, dest);
}
	public static String getDataFromExcelSheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	String path = "F:\\Velocity\\ExcelDoc\\Class.xlsx" ;
	
	FileInputStream file = new FileInputStream(path);
	
	String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	
	//System.out.println(data);
	
	return data;

	}
}
