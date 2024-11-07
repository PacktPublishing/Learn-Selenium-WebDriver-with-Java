package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class X_And_Y {

	public static void main(String[] args) {
		
		/*
		 * Getting Height and Width of an Element
		 * 
		 * 1. Using getLocation (Point Class)
		 * 2. Using getRect (Rectangle Class)
		 * 
		 */
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//webdrivers//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		
		Point p = login.getLocation();
		
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		Rectangle r = login.getRect();
		
		System.out.println(r.getX());
		System.out.println(r.getY());
		
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
