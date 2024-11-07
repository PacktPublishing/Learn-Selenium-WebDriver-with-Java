package com.dezlearn.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_Home_Page_Elements {
	
	WebDriver driver;
	
	@FindBy(css="input#gh-btn") public WebElement searchBtn;
	
	public Ebay_Home_Page_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
