package misc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingFullPageScreenshot {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Taking Full Page Screenshot
		 */
		
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//webdrivers//chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.goodreads.com");
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("./screenshots/file1.png"));
		
		driver.quit();
		
		

	}

}
