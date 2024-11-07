package misc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingElementScreenshot {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Taking screenshots of specific section (element) of web page
		 * 
		 */
		
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//webdrivers//chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.goodreads.com/");
		
		WebElement box = driver.findElement(By.id("newAccountBox"));
		
		File file = box.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("./screenshots/file2.png"));
		
		driver.quit();
		
	}

}
