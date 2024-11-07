package com.dezlearn.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.dezlearn.lib.AppLib;

public class AbstractBaseTest{
	
	WebDriver driver;
	private AppLib app;
	
	@Parameters({"browser","driverexe"})
	@BeforeMethod(alwaysRun=true)
	public void setUp(@Optional("Chrome") String browser, 
			@Optional("/Users/mayurdeshmukh/Documents/Drivers/chromedriver") String exe) throws Exception {
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", exe);
			driver = new ChromeDriver();
		} else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", exe);
			driver = new FirefoxDriver();
		} 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		app = new AppLib(driver);
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
	public AppLib App() {
		return app;
	}

}
