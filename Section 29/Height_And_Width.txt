package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Height_And_Width {

	public static void main(String[] args) {
		
		/*
		 * Getting Height and Width of an Element
		 * 
		 * 1. Using getSize (Dimension Class)
		 * 2. Using getRect (Rectangle Class)
		 */
	
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//webdrivers//chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		
		Dimension d = login.getSize();
		
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
		
		Rectangle r = login.getRect();
		
		System.out.println(r.getHeight());
		System.out.println(r.getWidth());
		
		driver.quit();
		
	}

}
