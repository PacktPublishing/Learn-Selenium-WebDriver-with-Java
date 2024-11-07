package com.dezlearn.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.dezlean.lib.AppLib;

public class AbstractBaseTest {
	
	WebDriver driver;
	private AppLib app;
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/mayurdeshmukh/Documents/Drivers/chromedriver");
		driver = new ChromeDriver();
		app = new AppLib(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	public AppLib App() {
		return app;
	}

}
